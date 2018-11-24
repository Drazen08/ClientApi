package com.huiji.api.alipay.service;

import com.alipay.api.internal.parser.json.ObjectJsonParser;
import com.alipay.api.internal.util.AlipaySignature;
import com.huiji.api.alipay.AlipayConfig;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.OrderCodeUtil;
import com.huiji.api.util.StringSplitUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;



/**
 * Created by Administrator on 2016/10/10.
 */
@Transactional
@Service
public class AliCallBaclServiceImpl implements AliCallBackService {
    @Resource
    private UserBillDetailMapper userBillDetailMapper;
    @Resource
    private UserAccountMapper userAccountMapper;
    @Resource
    private ChangeBalanceUrlMapper changeBalanceUrlMapper;
    @Resource
    private UserActMapper userActMapper;
    @Resource
    private RollbackMoneyMapper rollbackMoneyMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderPayLockMapper orderPayLockMapper;
    @Resource
    private OrderPaySuccessMapper orderPaySuccessMapper;
    @Override
    public String callBack(Map<String, String> map) throws Exception {
        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(map, AlipayConfig.alipay_public_key, AlipayConfig.input_charset);
            System.out.println(signVerified);
            System.out.println(map);
            String outTradeNo=map.get("out_trade_no").replaceAll(" ","").trim();
            GlobalLog.Pay.debug("out_trade_no:" + outTradeNo);

            Map<String,Object> mapParam=StringSplitUtil.stringSplit(map.get("body"));
            String msgId=(String)mapParam.get("msgId");
            GlobalLog.Pay.debug("MsgId:" + msgId);
            List<String> payOrders=(List<String>)mapParam.get("payOrders");
            int msgIdNum=userBillDetailMapper.findMsgId(msgId);
            if(msgIdNum==0){
                GlobalLog.Pay.debug("msgId"+msgId+"并未在数据库找到");
                return "fail";
            }
            int num=userBillDetailMapper.findHavedPayResultOrderWithMisId(msgId);
            if(num!=0) {
                List<String> orders=userBillDetailMapper.getOrdersByMsgId(msgId);
                for(String order:orders){
                    Order order1=orderMapper.getOrderByOrderId(order);
                    GlobalLog.Pay.debug("回调屏蔽因交易订单的支付时间为："+order1.getPay_time().replaceAll(".0",""));
                }
                return "success";
            }//已经有结果不需要进行订单验证修改状态
            List<UserBillDetail> list=userBillDetailMapper.findUserBillDetailsByMsgId(msgId);
            StringBuffer sbf=new StringBuffer();
            System.out.println("listSize:"+list.size());
            if(list.size()==0)
                return "success";//已经有结果不需要进行订单验证修改状态
            else{
                sbf.append("in (");
                float ordersPrice=0f;
                for(int i=0;i<list.size()-1;i++){
                    sbf.append(list.get(i).getOrder_id()+",");
                    ordersPrice+=list.get(i).getPay_price();
                }
                sbf.append(list.get(list.size()-1).getOrder_id());
                sbf.append(")");
                ordersPrice+=list.get(list.size()-1).getPay_price();
                ordersPrice=ordersPrice/100f;
                System.out.println(ordersPrice);
                float msgPrice=Float.valueOf(map.get("total_amount"));
                if(msgPrice!=ordersPrice)
                    return "过滤此操作";
                System.out.println("订单号："+sbf.toString());
            }
        //AlipayNotify.verify(map)
            if(signVerified){
                GlobalLog.Pay.debug("支付宝支付的签名验证成功，时间："+DateUtil.dateToString(new Date()));
                String payStatus=map.get("trade_status");
                System.out.println("payStatus:"+payStatus);

                if("TRADE_SUCCESS".equals(payStatus)||"TRADE_FINISHED".equals(payStatus)){
                    GlobalLog.Pay.debug("支付宝返回的支付状态为："+payStatus+"成功");
                    updateOrderStatus(msgId,true);
                    //修改tbUserBillDetail
                    userBillDetailMapper.updateStates(msgId,10);
                }else{
                    GlobalLog.Pay.debug("支付宝返回的支付状态为："+payStatus+"失败");
                    userBillDetailMapper.updateStates(msgId,20);
                    List<String> yuSrccess=userBillDetailMapper.getYuePaySuccess(msgId);
                    if(yuSrccess!=null&&yuSrccess.size()!=0){
                        sbf.deleteCharAt(sbf.length()-1);
                        sbf.append(",");
                        for(int i=0;i<yuSrccess.size()-1;i++){
                            sbf.append(yuSrccess.get(i)+",");
                        }
                        sbf.append(yuSrccess.get(list.size()-1));
                        sbf.append(")");
                    }
                    GlobalLog.Pay.debug("当付款失败时要回滚余额的订单:"+sbf.toString());
                    if(sbf.toString().length()!=0) {
                        List<UserBillDetail> userBillDetails= userBillDetailMapper.findYeForBack(msgId, sbf.toString());
                        userBillDetailMapper.updateYePayState(msgId,sbf.toString());
                        System.out.println("userBillDetail:"+userBillDetails);
                        if(userBillDetails.size()!=0) {
                            for (UserBillDetail userBillDetail : userBillDetails) {
                                long yue = userBillDetail.getPay_balance();
                                long balance1000 = userBillDetail.getBlance1000();
                                long balance2000 = userBillDetail.getBlance2000();
                                String uid = userBillDetail.getUid();
                                String order_id = userBillDetail.getOrder_id();
                                //                        String bill_id =userBillDetail.getBill_id();
                                //还原1000和2000的余额数
                                userAccountMapper.rollBackUserAccountBalanceWith1000(uid, balance1000);
                                userAccountMapper.rollBackUserAccountBalanceWith2000(uid, balance2000);
                                //
                                String payCode = "YEHT" + OrderCodeUtil.getOrderNo();//生成支付单号
                                ChangeBalanceUrl changeBalanceUrl = changeBalanceUrlMapper.getUrlByType(6);
                                UserAct userAct = userActMapper.getLastAfterMoneyByUserID(uid);
                                String reason = "订单：" + order_id + "，支付宝支付失败并还原所用的余额数" + (double) yue / 1000D + "元";
                                String date1 = DateUtil.dateToString2(new Date());
                                String strday = date1;
                                String strmonth = date1.substring(4, 6);
                                String stryear = date1.substring(0, 4);
                                String time = DateUtil.dateToString(new Date());
                                rollbackMoneyMapper.saveRollbackMoney(
                                        new RollbackMoney(uid, payCode, order_id, 10, yue, reason, time, strday, strmonth, stryear)
                                );
                                UserAct userAct1 = new UserAct(uid, payCode, 20, "20-1", changeBalanceUrl.getUrl(), "+", yue,
                                        userAct.getAfter_money(), userAct.getAfter_money() + yue, balance1000, balance2000, "余额回退订单：" + order_id,
                                        time, strday, strmonth, stryear);
                                userActMapper.saveChangeBalance(userAct1);
                            }
                        }
                    }
//                    //tb_order_detail
                    updateOrderStatus(msgId,false);
//                    if(sbf.toString().length()!=0){
//                        mapOrder.put("pay_type",20);
//                        mapOrder.put("order_id",sbf.toString());
//                        mapOrder.put("type_desc","支付失败");
//                    }
//                    orderMapper.updatePaystate(mapOrder);
            }
            System.out.println("操作成功");
                return "success";

            }else{
                GlobalLog.Pay.debug("支付宝支付的签名验证失败，时间："+DateUtil.dateToString(new Date()));
                System.out.println("过滤此操作");
                return "fail";
            }
//        return "";
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
//        return "";
    }
    private void updateOrderStatus(String msgId,boolean flag){
        Map<String,Object> mapOrder=new HashMap<String,Object>();
        //
        List<String> orders=userBillDetailMapper.getOrdersByMsgId(msgId);
        GlobalLog.Pay.debug("要操作订单状态的订单号:"+orders.toString());
        //tb_order_detail
        for(String order:orders){
            long usedBalance = 0l;
            long usePayMoney = 0l;
            int payid=0;
            String bill_id="";
            int payType=flag?10:20;
            String typeDesc=flag?"订单付款成功，等待商家发货":"支付失败";
            //看该Order有没有余额支付成功过，如果有可以得到余额支付和支付宝支付的金额数然后
            GlobalLog.Pay.debug("要操作订单状态的订单号(for循环中的单个order):"+order+"；msgid:"+msgId);

            UserBillDetail userBillDetailYue= userBillDetailMapper.getUserBillDetailByOrderIdWithYue(msgId,order);
            GlobalLog.Pay.debug(order+"是否获取到有余额付款成功的UserBillDetail："+userBillDetailYue);
            String uid="";
            if(userBillDetailYue!=null){
                usedBalance=userBillDetailYue.getPay_balance();
                usePayMoney=userBillDetailYue.getPay_price();
                bill_id=userBillDetailYue.getBill_id();
                uid=userBillDetailYue.getUid();
                if(usePayMoney==0l){
                    payid=1;
                }else {
                    payid=2;
                }

            }else {
                UserBillDetail userBillDetailPay=userBillDetailMapper.getUserBillDetailByOrderIdWithPay(msgId, order);
                payid=2;
                bill_id=userBillDetailPay.getBill_id();
                usePayMoney=userBillDetailPay.getPay_price();
                uid=userBillDetailPay.getUid();
            }
            mapOrder.put("pay_type", payType);
            mapOrder.put("type_desc",typeDesc );
            mapOrder.put("endprice", usePayMoney);
            mapOrder.put("balance", usedBalance);
            mapOrder.put("paytime", DateUtil.dateToString(new Date()));
            mapOrder.put("payid", payid);
            mapOrder.put("order_id", order);
            orderMapper.updateOrderStauts1(mapOrder);
            orderPayLockMapper.updateOrderPayed(order);
            if(flag){
                orderPaySuccessMapper.saveOrderPaySuccess(
                        //String order_id, Long pay_price, Date pay_success_time, Integer state, Date create_time
                        new OrderPaySuccess(uid,bill_id,order,usePayMoney,usedBalance,new Date(),1,2,new Date())
                );
            }

        }



    }
}
