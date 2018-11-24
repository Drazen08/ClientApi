package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.ORD1003_Service;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.msg.request.body.ORD1003_ReqBody;
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
 * Created by Administrator on 2016/9/23.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ORD1003_ServiceImpl implements ORD1003_Service {
    @Resource
    private FreezeTaskMapper freezeTaskMapper;
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

    public  void executeService(long tuiPrice,Order order,ORD1003_ReqBody ord1003_reqBody)throws Exception{
        try {
            String time = DateUtil.dateToString(new Date());
            String date1 = DateUtil.dateToString2(new Date());
            String strday = date1;
            String strmonth = date1.substring(4, 6);
            String stryear = date1.substring(0, 4);
            FreezeTask freezeTask = freezeTaskMapper.getfreezeInfo(ord1003_reqBody.getOrderId());
            if (freezeTask!= null) {
                //该记录在三天之内
                //读取确认收货时给商家生成的task中的体现钱数
                long sellerTaskGetMoneyPrice = freezeTask.getPrice();
                long getMoney =  sellerTaskGetMoneyPrice- tuiPrice;//100-90=10
                //终止原先的task记录作为历史记录使用
                int c = freezeTaskMapper.UpdateInThreeDay("3日内退货，任务中止", ord1003_reqBody.getOrderId());
                //重新生成新的getMoney  的task
                String startTime=freezeTask.getStart_time().replace(".0","");
                if(getMoney>0) {
                    freezeTaskMapper.saveFreezeTask(new FreezeTask(order.getSeller_id(), order.getOrder_id(), getMoney, 1000, 0,
                            "再次生成商户可提现任务", null, time, startTime, stryear, strmonth, strday));
                }
                //------------------
            }else {
                Order order1 = orderMapper.getOrderByOrderId(ord1003_reqBody.getOrderId());
                long getMoney =  order1.getPrice()- tuiPrice;//100-90=10
                if(getMoney>0) {
                    String startTime=DateUtil.dateToString(new Date(new Date().getTime()+(long)3*24*60*60*1000));
                    freezeTaskMapper.saveFreezeTask(new FreezeTask(order.getSeller_id(), order.getOrder_id(), getMoney, 1000, 0,
                            "生成商户可提现任务", null, time, startTime, stryear, strmonth, strday));
                }
            }
            //(#{order_id},#{reject_type},#{reject_cause},#{reject_price}," +
            //" #{note},#{money},now(),#{str_day},#{str_month},#{str_year})")
            //改变订单状态 和 向退货表里插入数据
            int a = orderMapper.tui("30", ord1003_reqBody.getOrderId());
            int b = orderMapper.tuitype(ord1003_reqBody.getOrderId(), ord1003_reqBody.getMonand(), ord1003_reqBody.getReason(), tuiPrice, ord1003_reqBody.getWanttosay(), order.getPrice(), strday, strmonth, stryear);

            //2>>如果是主订单就把所有子订单为付款的都屏蔽
            if (order.getPid() == null) {//说明是主订单
                List<Order> orders = orderMapper.getSubOrderByOrderId(ord1003_reqBody.getOrderId());
                if (orders.size() != 0) {
                    Map<String, Object> subMap = null;

                    Long useBalance1000 = 0L;
                    Long useBalance2000 = 0L;
                    Long payBalance = 0L;
                    String payCode = "";
                    ChangeBalanceUrl changeBalanceUrl = null;
                    UserAct userAct = null;
                    UserAct userAct1 = null;
                    UserBillDetail userBillDetail = null;
                    for (Order subOrder : orders) {//预选的未付 关闭订单 现在的按钮是删除订单。
                        if (subOrder.getPay_type() == 0) {
                            subMap = new HashMap<String, Object>();
                            subMap.put("type", 40);
                            subMap.put("type_desc", "订单已关闭");
                            subMap.put("closing_time", time);
                            subMap.put("order_id", subOrder.getOrder_id());
                            orderMapper.closeOrder(subMap);
                            userBillDetail = userBillDetailMapper.searOldchYuePay(subOrder.getUid(), subOrder.getOrder_id());
                            if (userBillDetail != null) {
                                payBalance = userBillDetail.getPay_balance();
                                useBalance1000 = userBillDetail.getBlance1000();
                                useBalance2000 = userBillDetail.getBlance2000();
                                //还原1000和2000的余额数
                                userAccountMapper.rollBackUserAccountBalanceWith1000(subOrder.getUid(), useBalance1000);
                                userAccountMapper.rollBackUserAccountBalanceWith2000(subOrder.getUid(), useBalance2000);
                                //
                                payCode = "YEHT" + OrderCodeUtil.getOrderNo();//生成支付单号
                                changeBalanceUrl = changeBalanceUrlMapper.getUrlByType(6);
                                userAct = userActMapper.getLastAfterMoneyByUserID(subOrder.getUid());
                                String reason="取消订单："+order.getOrder_id()+"，并还原所用的余额数"+(double)payBalance/1000+"元";
                                rollbackMoneyMapper.saveRollbackMoney(
                                        new RollbackMoney(order.getUid(),payCode, order.getOrder_id(), 10, payBalance,reason,time, strday, strmonth, stryear)
                                );
                                userAct1 = new UserAct(subOrder.getUid(), payCode, 20, "20-1", changeBalanceUrl.getUrl(), "+", payBalance,
                                        userAct.getAfter_money(), userAct.getAfter_money() + payBalance, useBalance1000, useBalance2000, "余额回退订单：" + subOrder.getOrder_id(),
                                        time, strday, strmonth, stryear);
                                userActMapper.saveChangeBalance(userAct1);
                                //将刚才的意向订单的支付订单在userBillDetail中全部改为失效状态
                                userBillDetailMapper.updateBillDetailState(subOrder.getUid(), subOrder.getOrder_id());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
