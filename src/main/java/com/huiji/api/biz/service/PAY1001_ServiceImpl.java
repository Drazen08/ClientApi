package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.PAY1001_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.PAY1001_ReqBody;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.PAY1001_ResBody;
import com.huiji.api.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/23.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PAY1001_ServiceImpl implements PAY1001_Service {
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
    private UserBillDetailMapper userBillDetailMapper;
    @Resource
    private OutTradeNoMapper outTradeNoMapper;

    public void executeService(IResponse response, IRequest<PAY1001_ReqBody> request, String uid) throws Exception {
        String orderIdGoBack = "";
        Date date = new Date();
        String createDate = DateUtil.dateToString(date);
        try {
            PAY1001_ResBody pay1001_resBody = new PAY1001_ResBody();
            Long balance = request.getBodyObject().getBalance();
           /* String expiredDate = DateUtil.dateToString(new Date(date.getTime() + 30 * 60 * 1000));*/
            String date1 = DateUtil.dateToString2(new Date());
            String strDay = date1;
            String strMonth = date1.substring(4, 6);
            String strYear = date1.substring(0, 4);
            List<String> orderIds = request.getBodyObject().getOrderIds();
            StringBuffer sb = new StringBuffer();
//            System.out.println("size:" + orderIds.length);
            String outTradeNo=OutTradeNoUtil.getOutTradeNo(orderIds, outTradeNoMapper);
            System.out.println("outTradeNo:" + outTradeNo);
            int orderSuccessNum=userBillDetailMapper.findOrderSuccess(outTradeNo);
            if(orderSuccessNum!=0){
                sb.append("订单已经支付成功无需再次支付");
                pay1001_resBody.setResult("0");
                pay1001_resBody.setResultDesc(sb.toString());//2016091000476627   2088421684411290yuanlai
                pay1001_resBody.setPayContent("");
                response.setBodyObject(pay1001_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }

            StringBuffer sbPayOrders=new StringBuffer();
            String RunningNum = "NO" + OrderCodeUtil.getOrderNo();//生成流水号
            sbPayOrders.append(RunningNum+",");
            long aliPayPirce = 0L;
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
            long zfbused=0l;
            if(sbf.toString().length()!=0) {
                orderPriceSum= orderMapper.getOrderPriceSum(sbf.toString(),uid);
                zfbused=orderMapper.getOrderZfbPrice(sbf.toString(),uid);
            }
            System.out.println("zfbused:"+zfbused);
            if(balance-orderPriceSum>=0){//如果首次过来的余额比所有订单的金额都要多，说明可以支付所有的订单。
                paySuccess=true;//这样就可以为订单支付成功
            }
            Boolean flag = false;

            //余额-订总
            for (String orderId : orderIds) {  //10-15=-5 余额-订单单个  <0    10-8/10=2 /0  >=0
                System.out.println("orderId:" + orderId);
                orderIdGoBack = orderId;
                Order orderDB = orderMapper.getOrderByOrderId(orderId);

                String expiredTime = orderDB.getPay_expired_time().replace(".0", "");
                System.out.println("orderDB.getPay_expired_time():" + expiredTime);
                if (createDate.compareTo(expiredTime) >= 0) {
                    sb.append("订单号：" + orderId + "支付时间已失效;");
                    continue;
                }
                if (orderDB.getPay_type() == 10) {
                    int payType = orderDB.getPayid();
                    if (payType == 1)
                        payTypes = "余额支付";
                    else if (payType == 2)
                        payTypes = "支付宝支付";
                    else
                        payTypes = "微信支付";
                    sb.append("订单号：" + orderId + "已经" + payTypes + "成功无需再次支付;");
                    continue;
                }
//                List<UserBillDetail> countPaySuccess = userBillDetailMapper.searchSeccessPayDetail(orderId, userSession.getUid());
//                if (countPaySuccess.size() != 0) {
//                    sb.append("订单号：" + orderId + "在订单历史中已经支付成功不能再次支付;");
//                    continue;
//                }

                UserBillDetail odkUserBillDetail = null;
                long usedBalance = 0l;
                long useBalance1000 = 0l;
                long useBalance2000 = 0l;
                long usePayMoney = 0l;
                if (orderDB.getPay_type() == 0) {
                    odkUserBillDetail = userBillDetailMapper.searOldchYuePay(uid, orderId);
                    if (odkUserBillDetail != null) {//如果查出原有余额支付的就用原来的余额（余额绑定）完毕会continue
                        usedBalance = odkUserBillDetail.getPay_balance();//如果在未支付的情况下查出有余额支付成功 那使用余额强制为0
                        balance -= usedBalance;
                        useBalance1000 = odkUserBillDetail.getBlance1000();
                        useBalance2000 = odkUserBillDetail.getBlance2000();
                        usePayMoney = odkUserBillDetail.getPay_price();
                        aliPayPirce += usePayMoney;
                        userBillDetailMapper.updateBillDetailStateByout_trade_noZFB(uid, outTradeNo,orderId);
//                        userBillDetailMapper.updateBillDetailState(uid, orderId);
                        String payCodeYE = "YEZF" + OrderCodeUtil.getOrderNo();//生成支付单号
                        UserBillDetail userBillDetail = new UserBillDetail(outTradeNo,RunningNum, uid, payCodeYE, orderId, orderDB.getPrice(), usePayMoney, usedBalance, useBalance1000, useBalance2000, 3, 10, createDate,null,
                                strDay, strMonth, strYear);
                        userBillDetailMapper.saveUserBillDetail(userBillDetail);
                        userActMapper.updateBlandeBillId(payCodeYE, odkUserBillDetail.getBill_id());
                        //
                        if (usePayMoney!=0l) {
                            String payCode = "ZFBZF" + OrderCodeUtil.getOrderNo();//生成支付单号
                            UserBillDetail userBillDetail1 = new UserBillDetail(outTradeNo,RunningNum, uid, payCode, orderId, orderDB.getPrice(), usePayMoney, 0L, 0L, 0L, 1, 0, createDate,null,
                                    strDay, strMonth, strYear);
                            userBillDetailMapper.saveUserBillDetail(userBillDetail1);
                            sbPayOrders.append(orderId+",");

                            //
                            OrderPayTask orderPayTask = null;
                            String payCode1 = "";
                            OrderPayTask orderPayTaskDB = orderPayTaskMapper.searchPayTaskZhiFuBao(orderId);//最后一次获取支付的task
                            if (orderPayTaskDB == null) {//如果根据订单号查支付任务 如果没查到表明要新建此定单号的任务
                                payCode1 = "ZFBZF" + OrderCodeUtil.getOrderNo();//生成支付单号
                                //orderPayTaskMapper.updateExecute(orderId);
                                orderPayTaskMapper.updateState(orderId);
                                orderPayTask = new OrderPayTask(payCode1, RunningNum, orderId, uid, usePayMoney, usedBalance, 1000,
                                        1, 1, null, createDate, strDay, strMonth, strYear);
                                orderPayTaskMapper.savePayTask(orderPayTask);

                            } else {
                                payCode1 = "ZFBZF" + OrderCodeUtil.getOrderNo();//生成支付单号
                                orderPayTaskMapper.updateState(orderId);
                                int count = orderPayTaskDB.getOpt_num();
                                orderPayTask = new OrderPayTask(payCode1, RunningNum, orderId, uid, usePayMoney, usedBalance, 1000,
                                        1, ++count, null, createDate, strDay, strMonth, strYear);
                                orderPayTaskMapper.savePayTask(orderPayTask);
                                //orderPayTaskMapper.updateZhifuCount(orderId, ++count);
                            }
                        }
                        //paySuccess&&flag&&usePayMoney==0l
                        System.out.println("paySuccess:"+paySuccess);
                        System.out.println("aliPayPirce:"+aliPayPirce);
                        System.out.println("flag:"+flag);
                        if (zfbused==0l&&paySuccess&&aliPayPirce==0l) {
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
                userBillDetailMapper.updateBillDetailStateByout_trade_noZFB(uid, outTradeNo,orderId);
//                userBillDetailMapper.updateBillDetailState(uid, orderId);

                balance = balance - orderDB.getPrice();//减去之后是余额所剩的钱 27000-13600=13400
                if (balance >= 0) {
//                    if (orderDB.getPid() == null) {//说明是主订单
                    flag = yueZhiFu(orderDB, orderDB.getPrice(), 0L, uid, strDay, strMonth, strYear, paySuccess, RunningNum,zfbused,outTradeNo);
//                    }
//                    else {
//                        flag=yueZhiFu(orderDB, orderDB.getPrice(), userSession.getUid(), strDay, strMonth, strYear, 2);
//                    }
                    if (flag) {
                        if(paySuccess&&zfbused==0l)
                            sb.append("订单号：" + orderId + "余额支付成功");
                        else
                            sb.append("订单号：" + orderId + "余额支付中....");
                    }
                    else
                        sb.append("订单号：" + orderId + "支付失败");
                } else {//余额不够支付订单的
                    Long zfbZF = odkUserBillDetail == null ? Math.abs(balance) : orderDB.getPrice() - odkUserBillDetail.getPay_balance();
                    aliPayPirce += zfbZF;
//                    Long yueZH = 0L;//orderDB.getPrice() + balance;//15-5=10
                    Long yueZH = odkUserBillDetail == null ? orderDB.getPrice() + balance : odkUserBillDetail.getPay_balance();
                    balance = odkUserBillDetail == null ? orderDB.getPrice() + balance - yueZH : orderDB.getPrice() + balance;
                    OrderPayTask oderLastPay = orderPayTaskMapper.getOderLastPayByOrderId(orderId);
                    OrderPayTask orderPayTaskDB = orderPayTaskMapper.searchPayTaskZhiFuBao(orderId);//最后一次获取支付的task
                    OrderPayTask orderPayTask = null;
                    String payCode = null;
                    if (orderPayTaskDB == null) {//如果根据订单号查支付任务 如果没查到表明要新建此定单号的任务
                        payCode = "ZFBZF" + OrderCodeUtil.getOrderNo();//生成支付单号
                        //orderPayTaskMapper.updateExecute(orderId);
                        orderPayTaskMapper.updateState(orderId);
                        orderPayTask = new OrderPayTask(payCode, RunningNum, orderId, uid, zfbZF, yueZH, 1000,
                                1, 1, null, createDate, strDay, strMonth, strYear);
                        orderPayTaskMapper.savePayTask(orderPayTask);

                    } else {
                        payCode = "ZFBZF" + OrderCodeUtil.getOrderNo();//生成支付单号
                        orderPayTaskMapper.updateState(orderId);
                        int count = orderPayTaskDB.getOpt_num();
                        orderPayTask = new OrderPayTask(payCode, RunningNum, orderId, uid, zfbZF, yueZH, 1000,
                                1, ++count, null, createDate, strDay, strMonth, strYear);
                        orderPayTaskMapper.savePayTask(orderPayTask);
                        //orderPayTaskMapper.updateZhifuCount(orderId, ++count);
                    }
                    sb.append("订单号：" + orderId + "付款中....");
                    if (odkUserBillDetail == null && yueZH != 0) {//当余额支付一部分的时候同时减去余额和生成余额支付的billdetal
                        flag=yueZhiFu(orderDB, yueZH, zfbZF, uid, strDay, strMonth, strYear, paySuccess, RunningNum,zfbused,outTradeNo);
                    }
                    UserBillDetail userBillDetail = new UserBillDetail(outTradeNo,RunningNum, uid, payCode, orderId, orderDB.getPrice(), zfbZF, 0L, 0L, 0L, 1, 0, createDate,null,
                            strDay, strMonth, strYear);
                    userBillDetailMapper.saveUserBillDetail(userBillDetail);

                    sbPayOrders.append(orderId + ",");
                    int zfbPayNum=userBillDetailMapper.findZFBPayNum(orderId);
                    GlobalLog.Pay.debug("接口PAY1001支付宝支付，订单" + orderId + "已经生成支付宝支付订单" + zfbPayNum + "次");
                    int wxPayNum=userBillDetailMapper.findWXPayNum(orderId);
                    GlobalLog.Pay.debug("接口PAY1001支付宝支付，订单" + orderId + "已经生成微信支付订单" + wxPayNum + "次");

                }
            }
            int orderSuccessNumSceond=userBillDetailMapper.findOrderSuccess(outTradeNo);
            if(orderSuccessNumSceond!=0){
                sb.append("订单已经支付成功无需再次支付");
                pay1001_resBody.setResult("0");
                pay1001_resBody.setResultDesc(sb.toString());//2016091000476627   2088421684411290yuanlai
                pay1001_resBody.setPayContent("");
                response.setBodyObject(pay1001_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }
            String payOrders=sbPayOrders.deleteCharAt(sbPayOrders.length()-1).toString();
            System.out.println("payOrders:"+payOrders);
            pay1001_resBody.setResult("0");
            pay1001_resBody.setResultDesc("".equals(sb.toString()) ? "付款中...." : sb.toString());//2016091000476627   2088421684411290yuanlai
            pay1001_resBody.setPayContent(aliPayPirce != 0 ? Base64Util.encode(PayContentUtil.getPayContentUtil(new AliPayParamter("2016101002076705", "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANn0J5hVpGwYTF2B\n" +
                    "JZYIWaQGhiEV8+qopWdG6v5TD3PQE4SsytUDsXrWQNUKMpmVH10Q0pn3cT9aSL6A\n" +
                    "uDR32XWMmDK2PM4P0V0CMjPdKewiYdsRb+AYJT7alfwewfK/2Xdf2ZFUNtbHfw8R\n" +
                    "54WgbnswTytqQxdvkPPGEzWCFs4jAgMBAAECgYEA0YKHhUHeGiKJVeDNVpmUQb4b\n" +
                    "tTY7EDkpNkvPnMYPNo6wFHtdRsKUGrZV//Qbi9LzIS0IpQRdEj8hai6l45nJqBSu\n" +
                    "KzUAOrPX5ufQBgwJb5w5Ku31b36aAPqf94ka/bZuP5GGr4/5UlCcyf5GGFdt7IOw\n" +
                    "ZdQwHrsNI4pVNfLBd7ECQQD6E2XsjDa2k6dwCqqfRDYAFwI9SNZPCr1mdbr/orNy\n" +
                    "Xa22CupRff8LlQirP7Gs1gc3BNZwuZsFZzlcQtmtnYx9AkEA3x3zPb/GK1oo4aKV\n" +
                    "Ryoah/ot7sBgizE3A36tEDCvXQoMCAJSKuyFzbdqCWMRp87TEn0+MRQuiOJvALes\n" +
                    "1ZbnHwJAaRsoFqDkCh7LHBtPlTsdGzKQfWOUt4oDCwJmgzVGCMZ40W+LBo9XV+3e\n" +
                    "w+M0cTlPtP8yhhRspHu7Lxzl0sPKHQJAUWPYjqb9gGUEUsL/V5V5Vi8iQFz3Gu+a\n" +
                    "FPFJ6oUIA5Wdq/JEzRm4+cE1sjTshN2Cy9TaMgcdrpuDSKy4JLZGmwJBALirxyHB\n" +
                    "6nLZ/qHMhSCHyccn6jha29A3Jq8Sn47acVKnv8OJ8fIR12iEjU7uUpagZWx1sCm+\n" +
                    "KAM1iUkwvz7Nu64=", outTradeNo,payOrders, String.valueOf((double) aliPayPirce / 100D))).getBytes("utf-8")) : "");
            response.setBodyObject(pay1001_resBody);
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

    //    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    private Boolean yueZhiFu(Order order, Long balance, long zfbzf, String uid, String str_day, String str_month, String str_year, boolean type, String RunningNum,long zfbused,String outTradeNo) throws Exception{
        String payCode = "YEZF" + OrderCodeUtil.getOrderNo();//生成支付单号
        String createDate = DateUtil.dateToString(new Date());
//        Boolean flag = true;
        String orderId = order.getOrder_id();
        int userActId = 0;
        int billDetailId = 0;
        Long balance1000rollback = 0L;
        Long balance2000rollback = 0L;
        try {

            if (type&&zfbused==0l) {
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
//            if (flag) {


            // zhifu 13600
            long useBalance1000, useBalance2000 = 0L;
            UserAccount userAccount1000 = userAccountMapper.getUserAccountByUserIdWith1000(uid);//可体现的
            UserAccount userAccount2000 = userAccountMapper.getUsetAccountByUserIdWith2000(uid);//不可体现的
            balance1000rollback = userAccount1000.getBalance();
            balance2000rollback = userAccount2000.getBalance();
            Long balance1000 = userAccount1000.getBalance();
            balance1000 = balance1000 - balance;//13600-13400=200  balance1000 用了13400 还剩了200
            if (balance1000 >= 0) {
                userAccountMapper.updateUserAccountBalanceWith1000(uid, balance1000);
                useBalance1000 = balance;
            } else {//<0    13600-13700=-100    13600-20000=-6400
                System.out.println("orderid:" + orderId);
                userAccountMapper.updateUserAccountBalanceWith1000(uid, 0L);//
                useBalance1000 = balance + balance1000;
                System.out.println("不可提：" + userAccount2000.getBalance() + ";" + "余额：" + balance1000);
                Long balance2000 = userAccount2000.getBalance() + balance1000;//100+ -100=0
                userAccountMapper.updateUserAccountBalanceWith2000(uid, balance2000);
                useBalance2000 = Math.abs(balance1000);
            }


            List<UserAct> userActs = userActMapper.getUserChangeBalanceByUserId(uid);
            ChangeBalanceUrl changeBalanceUrl = changeBalanceUrlMapper.getUrlByType(6);
            if (userActs.size() == 0) {//
                //(String uid, Integer act_type, String url, String type, Long change_money,
                // String change_time, Long before_money, Long after_money, String change_desc,
                // String create_time, String str_day, String str_month, String str_year
                UserAct userAct = new UserAct(uid, payCode, 40, "40-1", changeBalanceUrl.getUrl(), "-", balance, 0L, -balance, useBalance1000, useBalance2000, "余额支付" + order.getId(),
                        createDate, str_day, str_month, str_year);
                userActMapper.saveChangeBalance(userAct);
                userActId = userAct.getId();
            } else {
                UserAct userAct = userActMapper.getLastAfterMoneyByUserID(uid);
                UserAct userAct1 = new UserAct(uid, payCode, 40, "40-1", changeBalanceUrl.getUrl(), "-", balance,
                        userAct.getAfter_money(), userAct.getAfter_money() - balance, useBalance1000, useBalance2000, "余额支付" + order.getOrder_id(),
                        createDate, str_day, str_month, str_year);
                userActMapper.saveChangeBalance(userAct1);
                userActId = userAct1.getId();
            }
            UserBillDetail userBillDetail = new UserBillDetail(outTradeNo,RunningNum, uid, payCode, orderId, order.getPrice(), zfbzf, balance, useBalance1000, useBalance2000, 3, 10, createDate,null,
                    str_day, str_month, str_year);
            userBillDetailMapper.saveUserBillDetail(userBillDetail);

            billDetailId = userBillDetail.getId();
            return true;

//            }
        } catch (Exception e) {
//
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
//            userBillDetailMapper.saveUserBillDetail(new UserBillDetail(uid, payCode, orderId, 0L, balance, 3, 20, createDate,
//                    str_day, str_month, str_year));
            String time = DateUtil.dateToString(new Date());
            //回执主订单的状态
//            if(type==1) {
            Map<String, Object> mapAdmin = new HashMap<String, Object>();
            mapAdmin.put("pay_type", 20);
            mapAdmin.put("type_desc", "订单付款失败");
            mapAdmin.put("endprice", 0);
            mapAdmin.put("balance", 0);
            mapAdmin.put("paytime", time);
            mapAdmin.put("payid", 1);
            mapAdmin.put("order_id", orderId);
            orderMapper.updateOrderStauts1(mapAdmin);
//        }
//            //回执意向订单的状态
//            if(type==2) {
//                Map<String, Object> mapCould = new HashMap<String, Object>();
//                mapCould.put("type", 10);
//                mapCould.put("send_type", 0);
//                mapCould.put("pay_type", 20);
//                mapCould.put("type_desc", "订单付款失败");
//                mapCould.put("endprice", 0);
//                mapCould.put("balance", 0);
//                mapCould.put("paytime",time );
//                mapCould.put("payid", 1);
//                mapCould.put("send_time", null);
//                mapCould.put("order_id", orderId);
//                orderMapper.updateOrderStauts2(mapCould);
//            }

            e.printStackTrace();

              throw e;
        }
//        return false;
    }
}
