package com.huiji.api.alipay.service;

import com.alipay.api.internal.util.AlipaySignature;
import com.huiji.api.alipay.AlipayConfig;
import com.huiji.api.db.entity.ChangeBalanceUrl;
import com.huiji.api.db.entity.RollbackMoney;
import com.huiji.api.db.entity.UserAct;
import com.huiji.api.db.entity.UserBillDetail;
import com.huiji.api.db.mapper.*;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.OrderCodeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/10/10.
 */
@Transactional
@Service
public class AliCallBaclServiceImplCopy  {
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

    public String callBack(Map<String, String> map) throws Exception {
        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(map, AlipayConfig.alipay_public_key, AlipayConfig.input_charset);
            System.out.println(signVerified);

            String msgId=map.get("out_trade_no");
            int num=userBillDetailMapper.findHavedPayResultOrderWithMisId(msgId);
            if(num!=0)return "success";//已经有结果不需要进行订单验证修改状态
            List<UserBillDetail> list=userBillDetailMapper.findUserBillDetailsByMsgId(msgId);
            StringBuffer sbf=new StringBuffer();
            sbf.append("in (");
            if(list.size()==0)
                return "success";//已经有结果不需要进行订单验证修改状态
            else{
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
                String payStatus=map.get("trade_status");
                System.out.println("payStatus:"+payStatus);
                Map<String,Object> mapOrder=new HashMap<String,Object>();
                mapOrder.put("payid",2);
                if("TRADE_SUCCESS".equals(payStatus)||"TRADE_FINISHED".equals(payStatus)){
                    //修改tbUserBillDetail
                    userBillDetailMapper.updateStates(msgId,10);
                    //tb_order_detail
                    if(sbf.toString().length()!=0){
                        mapOrder.put("pay_type",10);
                        mapOrder.put("order_id",sbf.toString());
                        mapOrder.put("type_desc","支付成功");
                    }
                    orderMapper.updatePaystate(mapOrder);
                }else{
                    userBillDetailMapper.updateStates(msgId,20);
//                    if(sbf.toString().length()!=0) {
//                        UserBillDetail userBillDetail= userBillDetailMapper.findYeForBack(msgId, sbf.toString());
//                        userBillDetailMapper.updateYePayState(msgId,sbf.toString());
//                        System.out.println("userBillDetail:"+userBillDetail);
//                        if(userBillDetail!=null){
//                            long yue=userBillDetail.getPay_balance();
//                            long balance1000=userBillDetail.getBlance1000();
//                            long balance2000=userBillDetail.getBlance2000();
//                            String uid=userBillDetail.getUid();
//                            String order_id=userBillDetail.getOrder_id();
//    //                        String bill_id =userBillDetail.getBill_id();
//                            //还原1000和2000的余额数
//                            userAccountMapper.rollBackUserAccountBalanceWith1000(uid, balance1000);
//                            userAccountMapper.rollBackUserAccountBalanceWith2000(uid, balance2000);
//                            //
//                            String payCode = "YEHT" + OrderCodeUtil.getOrderNo();//生成支付单号
//                            ChangeBalanceUrl changeBalanceUrl = changeBalanceUrlMapper.getUrlByType(6);
//                            UserAct userAct = userActMapper.getLastAfterMoneyByUserID(uid);
//                            String reason="订单："+order_id+"，支付宝支付失败并还原所用的余额数"+(double)yue/1000D+"元";
//                            String date1 = DateUtil.dateToString2(new Date());
//                            String strday = date1;
//                            String strmonth = date1.substring(4, 6);
//                            String stryear = date1.substring(0, 4);
//                            String time = DateUtil.dateToString(new Date());
//                            rollbackMoneyMapper.saveRollbackMoney(
//                                    new RollbackMoney(uid,payCode, order_id, 10, yue,reason,time, strday, strmonth, stryear)
//                            );
//                            UserAct userAct1 = new UserAct(uid, payCode, 20, "20-1", changeBalanceUrl.getUrl(), "+", yue,
//                                    userAct.getAfter_money(), userAct.getAfter_money() + yue, balance1000, balance2000, "余额回退订单：" + order_id,
//                                    time, strday, strmonth, stryear);
//                            userActMapper.saveChangeBalance(userAct1);
//                        }
//                    }
                    //tb_order_detail
                    if(sbf.toString().length()!=0){
                        mapOrder.put("pay_type",20);
                        mapOrder.put("order_id",sbf.toString());
                        mapOrder.put("type_desc","支付失败");
                    }
                    orderMapper.updatePaystate(mapOrder);
                }
                System.out.println("操作成功");
                return "success";

            }else{
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
}
