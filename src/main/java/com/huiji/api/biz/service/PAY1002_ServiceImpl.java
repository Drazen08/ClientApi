package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.PAY1002_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.PAY1002_ReqBody;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.PAY1002_ResBody;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.OrderCodeUtil;
import com.huiji.api.util.OutTradeNoUtil;
import com.huiji.api.util.PayContentUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/24.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class PAY1002_ServiceImpl implements PAY1002_Service {

    @Resource
    private OrderPayTaskMapper orderPayTaskMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserActMapper userActMapper;
    @Resource
    private ChangeBalanceUrlMapper changeBalanceUrlMapper;
    @Resource
    private UserAccountMapper userAccountMapper;
    @Resource
    private PayTaskForSellerMapper payTaskForSellerMapper;
    @Resource
    private UserBillDetailMapper userBillDetailMapper;
    @Resource
    private OutTradeNoMapper outTradeNoMapper;

    public void executeService(IResponse response, IRequest<PAY1002_ReqBody> request,String uid,String clientIPAddr)throws Exception{
        String orderIdGoBack="";
        String createDate= DateUtil.dateToString(new Date());
        try {

            PAY1002_ResBody pay1002_resBody=new PAY1002_ResBody();
/*
            String expiredDate = DateUtil.dateToString(new Date(new Date().getTime() + 30 * 60 * 1000));
*/
            Long balance = request.getBodyObject().getBalance();
            String date = DateUtil.dateToString2(new Date());
            String strDay = date;
            String strMonth = date.substring(4, 6);
            String strYear = date.substring(0, 4);
            List<String> orderIds = request.getBodyObject().getOrderIds();
//            System.out.println("size:"+orderIds.length);
            StringBuffer sb = new StringBuffer();
            String outTradeNo= OutTradeNoUtil.getOutTradeNo(orderIds, outTradeNoMapper);
            System.out.println("outTradeNo:" + outTradeNo);
            int orderSuccessNum=userBillDetailMapper.findOrderSuccess(outTradeNo);
            if(orderSuccessNum!=0){
                sb.append("订单已经支付成功无需再次支付");
                pay1002_resBody.setResult("0");
                pay1002_resBody.setResultDesc(sb.toString());//2016091000476627   2088421684411290yuanlai
                pay1002_resBody.setPayContent("");
                response.setBodyObject(pay1002_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }
            String RunningNum="NO"+ OrderCodeUtil.getOrderNo();//生成流水号
            long WXPirce = 0L;
            String payTypes = "";
            long orderPriceSum=0l;
            boolean paySuccess=false;
            StringBuffer sbf=new StringBuffer();
            sbf.append("in (");
            for(int i=0;i<orderIds.size()-1;i++){
                sbf.append(orderIds.get(i)+",");
            }
            sbf.append(orderIds.get(orderIds.size() - 1));
            sbf.append(")");
            System.out.println(sbf.toString());
            long wxused=0l;
            if(sbf.toString().length()!=0) {
                orderPriceSum= orderMapper.getOrderPriceSum(sbf.toString(),uid);
                wxused=orderMapper.getOrderZfbPrice(sbf.toString(),uid);//用的是和支付宝同样的查询。
            }
            System.out.println("wxused:"+wxused);
            if(balance-orderPriceSum>=0){//如果首次过来的余额比所有订单的金额都要多，说明可以支付所有的订单。
                paySuccess=true;//这样就可以为订单支付成功
            }
            Boolean flag = false;
            //余额-订总
            for (String orderId : orderIds) {  //10-15=-5 余额-订单单个  <0    10-8/10=2 /0  >=0
                Order orderDB = orderMapper.getOrderByOrderId(orderId);
                String expiredTime = orderDB.getPay_expired_time().replace(".0", "");
                System.out.println("orderDB.getPay_expired_time():"+expiredTime);
                if (createDate.compareTo(expiredTime) >= 0) {
                    sb.append("订单号：" + orderId + "支付时间已失效;");
                    continue;
                }
                if(orderDB.getPay_type()==10){
                    int payType=orderDB.getPayid();
                    if(payType==1)
                        payTypes="余额支付";
                    else if(payType==2)
                        payTypes="支付宝支付";
                    else
                        payTypes="微信支付";
                    sb.append("订单号：" + orderId + "已经"+payTypes+"成功;");
                    continue;
                }
                UserBillDetail odkUserBillDetail = null;
                long usedBalance = 0l;
                long useBalance1000 = 0l;
                long useBalance2000 = 0l;
                long useWXMoney = 0l;
                if(orderDB.getPay_type()==0) {
                    odkUserBillDetail=userBillDetailMapper.searOldchYuePay(uid, orderId);
//                    balance=odkUserBillDetail==null?balance:0L;//如果在未支付的情况下查出有余额支付成功 那使用余额强制为0
                    if (odkUserBillDetail != null) {//如果查出原有余额支付的就用原来的余额（余额绑定）完毕会continue
                        usedBalance = odkUserBillDetail.getPay_balance();//如果在未支付的情况下查出有余额支付成功 那使用余额强制为0
                        balance -= usedBalance;
                        useBalance1000 = odkUserBillDetail.getBlance1000();
                        useBalance2000 = odkUserBillDetail.getBlance2000();
                        useWXMoney = odkUserBillDetail.getPay_price();
                        WXPirce += useWXMoney;
                        userBillDetailMapper.updateBillDetailStateByout_trade_noWX(uid, outTradeNo,orderId);
//                        userBillDetailMapper.updateBillDetailState(uid, orderId);
                        String payCodeYE = "YEZF" + OrderCodeUtil.getOrderNo();//生成支付单号
                        UserBillDetail userBillDetail = new UserBillDetail(outTradeNo,RunningNum, uid, payCodeYE, orderId, orderDB.getPrice(), useWXMoney, usedBalance, useBalance1000, useBalance2000, 3, 10, createDate,null,
                                strDay, strMonth, strYear);
                        userBillDetailMapper.saveUserBillDetail(userBillDetail);
                        userActMapper.updateBlandeBillId(payCodeYE, odkUserBillDetail.getBill_id());
                        //
                        if (useWXMoney!=0l) {
                            String payCode = "WXZF" + OrderCodeUtil.getOrderNo();//生成支付单号
                            UserBillDetail userBillDetail1 = new UserBillDetail(outTradeNo,RunningNum, uid, payCode, orderId, orderDB.getPrice(), useWXMoney, 0L, 0L, 0L, 2, 0, createDate,null,
                                    strDay, strMonth, strYear);
                            userBillDetailMapper.saveUserBillDetail(userBillDetail1);


                            //
                            OrderPayTask orderPayTaskDB=orderPayTaskMapper.searchPayTaskWeiXin(orderId);
                            OrderPayTask orderPayTask=null;
                            String payCode1=null;
                            if(orderPayTaskDB==null){//如果根据订单号查支付任务 如果没查到表明要新建此定单号的任务
                                payCode1= "WXZF"+OrderCodeUtil.getOrderNo();//生成支付单号
//                        orderPayTaskMapper.updateExecute(orderId);
                                orderPayTaskMapper.updateState(orderId);
                                orderPayTask =new OrderPayTask(payCode1,RunningNum,orderId,uid,useWXMoney,usedBalance,1000,
                                        2,1,null,createDate,strDay,strMonth,strYear);
                                orderPayTaskMapper.savePayTask(orderPayTask);

                            }else{
                                payCode1= "WXZF"+OrderCodeUtil.getOrderNo();//生成支付单号
                                orderPayTaskMapper.updateState(orderId);
                                int count=orderPayTaskDB.getOpt_num();
                                orderPayTask =new OrderPayTask(payCode1,RunningNum,orderId,uid,useWXMoney,usedBalance,1000,
                                        2,++count,null,createDate,strDay,strMonth,strYear);
                                orderPayTaskMapper.savePayTask(orderPayTask);
//                        orderPayTaskMapper.updateWeiXinCount(orderId, ++count);
                            }
                        }
                        //paySuccess&&flag&&usePayMoney==0l
                        System.out.println("paySuccess:"+paySuccess);
                        System.out.println("WXPirce:"+WXPirce);
                        System.out.println("flag:"+flag);
                        if (wxused==0l&&paySuccess&&WXPirce==0l) {
                            Map<String, Object> map = new HashMap<String, Object>();
                            map.put("pay_type", 10);
                            map.put("type_desc", "订单付款成功，等待商家发货");
                            map.put("endprice", 0);
                            map.put("balance", usedBalance);
                            map.put("paytime", DateUtil.dateToString(new Date()));
                            map.put("payid", 1);
                            map.put("order_id", orderId);
                            orderMapper.updateOrderStauts1(map);
                            sb.append("订单号：" + orderId + "余额支付成功");
                        }else
                            sb.append("订单号：" + orderId + "付款中....");
                        continue;
                    }
                }
                userBillDetailMapper.updateBillDetailStateByout_trade_noWX(uid, outTradeNo,orderId);
//                userBillDetailMapper.updateBillDetailState(uid, orderId);
//                Boolean flag=null;
                balance = balance - orderDB.getPrice();//减去之后是余额所剩的钱 27000-13600=13400
                if (balance >= 0) {
//                    if (orderDB.getPid() == null) {//说明是主订单
                    flag = yueZhiFu(orderDB, orderDB.getPrice(), 0L, uid, strDay, strMonth, strYear, paySuccess, RunningNum,wxused,outTradeNo);
//                    }else{
//                        flag=yueZhiFu(orderDB, orderDB.getPrice(), uid, strDay, strMonth, strYear,2);
//                    }
                    if (flag) {
                        if(paySuccess&&wxused==0l)
                            sb.append("订单号：" + orderId + "余额支付成功");
                        else
                            sb.append("订单号：" + orderId + "余额支付中....");
                    }
                    else
                        sb.append("订单号：" + orderId + "支付失败");
                }else{//余额不够支付订单的
                    Long wxZF = odkUserBillDetail==null?Math.abs(balance):orderDB.getPrice()-odkUserBillDetail.getPay_balance();
                    WXPirce += wxZF;
//                    Long yueZH = 0L;//orderDB.getPrice() + balance;//15-5=10
                    Long yueZH=odkUserBillDetail==null?orderDB.getPrice() + balance:odkUserBillDetail.getPay_balance();
                    balance = odkUserBillDetail==null?orderDB.getPrice() + balance - yueZH:orderDB.getPrice() + balance;
                    OrderPayTask oderLastPay = orderPayTaskMapper.getOderLastPayByOrderId(orderId);
                    OrderPayTask orderPayTaskDB=orderPayTaskMapper.searchPayTaskWeiXin(orderId);
                    OrderPayTask orderPayTask=null;
                    String payCode=null;
                    if(orderPayTaskDB==null){//如果根据订单号查支付任务 如果没查到表明要新建此定单号的任务
                        payCode= "WXZF"+OrderCodeUtil.getOrderNo();//生成支付单号
//                        orderPayTaskMapper.updateExecute(orderId);
                        orderPayTaskMapper.updateState(orderId);
                        orderPayTask =new OrderPayTask(payCode,RunningNum,orderId,uid,wxZF,yueZH,1000,
                                2,1,null,createDate,strDay,strMonth,strYear);
                        orderPayTaskMapper.savePayTask(orderPayTask);

                    }else{
                        payCode= "WXZF"+OrderCodeUtil.getOrderNo();//生成支付单号
                        orderPayTaskMapper.updateState(orderId);
                        int count=orderPayTaskDB.getOpt_num();
                        orderPayTask =new OrderPayTask(payCode,RunningNum,orderId,uid,wxZF,yueZH,1000,
                                2,++count,null,createDate,strDay,strMonth,strYear);
                        orderPayTaskMapper.savePayTask(orderPayTask);
//                        orderPayTaskMapper.updateWeiXinCount(orderId, ++count);
                    }
                    sb.append("\n\r订单号："+orderId+"付款中....");
                    if(odkUserBillDetail==null&&yueZH!=0){
                        flag=yueZhiFu(orderDB, yueZH, wxZF, uid, strDay, strMonth, strYear, paySuccess, RunningNum,wxused,outTradeNo);
                    }
                    UserBillDetail userBillDetail = new UserBillDetail(outTradeNo,RunningNum,uid, payCode, orderId,orderDB.getPrice(), wxZF, 0L,0L,0L, 2, 0, createDate,null,
                            strDay, strMonth, strYear);
                    userBillDetailMapper.saveUserBillDetail(userBillDetail);
                    int zfbPayNum=userBillDetailMapper.findZFBPayNum(orderId);
                    GlobalLog.Pay.debug("接口PAY1002微信支付，订单" + orderId + "已经生成支付宝支付订单" + zfbPayNum + "次");
                    int wxPayNum=userBillDetailMapper.findWXPayNum(orderId);
                    GlobalLog.Pay.debug("接口PAY1002微信支付，订单" + orderId + "已经生成微信支付订单" + wxPayNum + "次");

                }
            }
            int orderSuccessNumSceond=userBillDetailMapper.findOrderSuccess(outTradeNo);
            if(orderSuccessNumSceond!=0){
                sb.append("订单已经支付成功无需再次支付");
                pay1002_resBody.setResult("0");
                pay1002_resBody.setResultDesc(sb.toString());//2016091000476627   2088421684411290yuanlai
                pay1002_resBody.setPayContent("");
                response.setBodyObject(pay1002_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }
            //接微信的接口吗
            String payContent=WXPirce!= 0 ? PayContentUtil.WXPayContent(new WXPayParamter()):"";
            pay1002_resBody.setResult("0");
            pay1002_resBody.setResultDesc("".equals(sb.toString()) ? "付款中...." : sb.toString());
            pay1002_resBody.setPayContent(payContent);
            response.setBodyObject(pay1002_resBody);
            response.setResult(ResultCode.SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> mapAdmin = new HashMap<String, Object>();
            mapAdmin.put("pay_type", 20);
            mapAdmin.put("type_desc", "订单付款失败");
            mapAdmin.put("endprice", 0);
            mapAdmin.put("balance", 0);
            mapAdmin.put("paytime", createDate);
            mapAdmin.put("payid", 1);
            mapAdmin.put("order_id", orderIdGoBack);
            orderMapper.updateOrderStauts1(mapAdmin);
            throw e;
        }
    }

    private Boolean yueZhiFu(Order order, Long balance, long zfbzf, String uid, String str_day, String str_month, String str_year, boolean type, String RunningNum,long wxused,String outTradeNo)throws Exception{
        String payCode = "YEZF" + OrderCodeUtil.getOrderNo();//生成支付单号
        String createDate=DateUtil.dateToString(new Date());
        String orderId = order.getOrder_id();
        int userActId = 0;
        int billDetailId = 0;
        Long balance1000rollback = 0L;
        Long balance2000rollback = 0L;
        try {
            if (type&&wxused==0l) {
                //更改 pay_type 付款状态 ，type_desc，endprice 实际支付，balance 余额支付，paytime 付款时间 ，payid
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("pay_type", 10);
                map.put("type_desc", "订单付款成功，等待商家发货");
                map.put("endprice", 0);
                map.put("balance", balance);
                map.put("paytime", DateUtil.dateToString(new Date()));
                map.put("payid", 1);
                map.put("order_id", orderId);
                orderMapper.updateOrderStauts1(map);
            }

            // zhifu 13600
            long useBalance1000 ,useBalance2000=0L;
            UserAccount userAccount1000 = userAccountMapper.getUserAccountByUserIdWith1000(uid);//可体现的
            UserAccount userAccount2000 = userAccountMapper.getUsetAccountByUserIdWith2000(uid);//不可体现的
            balance1000rollback = userAccount1000.getBalance();
            balance2000rollback = userAccount2000.getBalance();
            Long balance1000 = userAccount1000.getBalance();
            balance1000 = balance1000 - balance;//13600-13400=-200
            if (balance1000 >= 0) {
                userAccountMapper.updateUserAccountBalanceWith1000(uid, balance1000);
                useBalance1000=balance;
            } else {//<0
                System.out.println("orderid:" + orderId);
                userAccountMapper.updateUserAccountBalanceWith1000(uid, 0L);//
                useBalance1000=balance+balance1000;
                System.out.println("不可提：" + userAccount2000.getBalance() + ";" + "余额：" + balance1000);
                Long balance2000 = userAccount2000.getBalance() + balance1000;
                userAccountMapper.updateUserAccountBalanceWith2000(uid, balance2000);
                useBalance2000= Math.abs(balance1000);
            }


            List<UserAct> userActs = userActMapper.getUserChangeBalanceByUserId(uid);
            ChangeBalanceUrl changeBalanceUrl = changeBalanceUrlMapper.getUrlByType(6);
            if (userActs.size() == 0) {//
                //(String uid, Integer act_type, String url, String type, Long change_money,
                // String change_time, Long before_money, Long after_money, String change_desc,
                // String create_time, String str_day, String str_month, String str_year
                UserAct userAct = new UserAct(uid, payCode, 40,"40-1" ,changeBalanceUrl.getUrl(), "-", balance, 0L, -balance,useBalance1000,useBalance2000, "余额支付" + order.getId(),
                        createDate, str_day, str_month, str_year);
                userActMapper.saveChangeBalance(userAct);
                userActId = userAct.getId();
            } else {
                UserAct userAct = userActMapper.getLastAfterMoneyByUserID(uid);
                UserAct userAct1 = new UserAct(uid, payCode, 40,"40-1" ,changeBalanceUrl.getUrl(), "-", balance,
                        userAct.getAfter_money(), userAct.getAfter_money() - balance,useBalance1000,useBalance2000, "余额支付" + order.getOrder_id(),
                        createDate, str_day, str_month, str_year);
                userActMapper.saveChangeBalance(userAct1);
                userActId = userAct1.getId();
            }
            UserBillDetail userBillDetail = new UserBillDetail(outTradeNo,RunningNum,uid, payCode, orderId,order.getPrice(), 0L, balance,useBalance1000,useBalance2000, 3, 10, createDate,null,
                    str_day, str_month, str_year);
            userBillDetailMapper.saveUserBillDetail(userBillDetail);
//            billDetailId = userBillDetail.getId();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            if (billDetailId != 0) {
                userBillDetailMapper.updateBillDetailStateFail(uid, billDetailId);
            }
            if (userActId != 0) {
                userActMapper.delUserBalance(userActId);
            }
            if (balance1000rollback != 0L) {
                userAccountMapper.updateUserAccountBalanceWith1000(uid, balance1000rollback);
            }
            if (balance2000rollback != 0L) {
                userAccountMapper.updateUserAccountBalanceWith2000(uid, balance2000rollback);
            }
            String time=DateUtil.dateToString(new Date());
            Map<String, Object> mapAdmin = new HashMap<String, Object>();
            mapAdmin.put("pay_type", 20);
            mapAdmin.put("type_desc", "订单付款失败");
            mapAdmin.put("endprice", 0);
            mapAdmin.put("balance", 0);
            mapAdmin.put("paytime", time);
            mapAdmin.put("payid", 1);
            mapAdmin.put("order_id", orderId);
            orderMapper.updateOrderStauts1(mapAdmin);
            throw e;
        }
        //return false;
    }

}
