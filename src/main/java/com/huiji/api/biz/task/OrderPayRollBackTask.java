package com.huiji.api.biz.task;

import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.OrderCodeUtil;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/26.
 */
@Component
@Transactional
public class OrderPayRollBackTask {
    @Resource
    private OrderPaySuccessMapper orderPaySuccessMapper;
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


    @Scheduled(fixedRate = 15000)
    public void goBack() throws Exception {
        try {
//            System.out.println(1);
            List<Map<String, Object>> map = orderPaySuccessMapper.findPayedOrders();
            Map<String,Object> rollBackOrderMap=null;
            for (Map maplist : map) {
                String order = (String) maplist.get("order_id");
                List<OrderPaySuccess> paySuccesses = orderPaySuccessMapper.getOrdersByOrderId(order);
                StringBuffer sbf = new StringBuffer();
                sbf.append("in (");
                for (int i = 1; i < paySuccesses.size(); i++) {
                    String uid = paySuccesses.get(i).getUid();
                    long payPricde = paySuccesses.get(i).getPay_price();
                    String order_id = paySuccesses.get(i).getOrder_id();
                    sbf.append(paySuccesses.get(i).getId() + ",");
                    //增加1000的余额
                    userAccountMapper.rollBackUserAccountBalanceWith1000(uid, payPricde);
                    //
                    String payCode =  paySuccesses.get(i).getBill_id();//生成支付单号
                    ChangeBalanceUrl changeBalanceUrl = changeBalanceUrlMapper.getUrlByType(6);
                    UserAct userAct = userActMapper.getLastAfterMoneyByUserID(uid);
                    String reason = "订单：" + order_id + "，重复扣款" + (double) payPricde / 1000D + "元，现把多余支付回退到余额";
                    String date1 = DateUtil.dateToString2(new Date());
                    String strday = date1;
                    String strmonth = date1.substring(4, 6);
                    String stryear = date1.substring(0, 4);
                    String time = DateUtil.dateToString(new Date());
                    rollbackMoneyMapper.saveRollbackMoney(
                            new RollbackMoney(uid, payCode, order_id, 30, payPricde, reason, time, strday, strmonth, stryear)
                    );
                    UserAct userAct1 = new UserAct(uid, payCode, 20, "20-3", changeBalanceUrl.getUrl(), "+", payPricde,
                            userAct.getAfter_money(), userAct.getAfter_money() + payPricde, payPricde, 0l, "余额回退订单：" + order_id,
                            time, strday, strmonth, stryear);
                    userActMapper.saveChangeBalance(userAct1);
                }
                sbf.deleteCharAt(sbf.length() - 1);
                sbf.append(" )");
                orderPaySuccessMapper.updateOrderState(sbf.toString());
                OrderPaySuccess orderPaySuccess=paySuccesses.get(0);
                if(orderPaySuccess.getOrder_id().equals(order)) {
                    rollBackOrderMap = new HashMap<String,Object>();
                    rollBackOrderMap.put("payid", orderPaySuccess.getPay_type());
                    rollBackOrderMap.put("endprice", orderPaySuccess.getPay_type());
                    rollBackOrderMap.put("balance", orderPaySuccess.getCash_pirce());
                    rollBackOrderMap.put("order_id", order);
                    rollBackOrderMap.put("pay_time",orderPaySuccess.getPay_success_time());
                    orderMapper.restoreStatus(rollBackOrderMap);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
