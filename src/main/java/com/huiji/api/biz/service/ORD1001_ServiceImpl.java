package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.ORD1001_Service;
import com.huiji.api.db.entity.*;
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
 * Created by Administrator on 2016/9/23.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ORD1001_ServiceImpl implements ORD1001_Service {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private ShopAccountMapper shopAccountMapper;
    @Resource
    private ShopBalanceMapper shopBalanceMapper;
    @Resource
    private ChangeBalanceUrlMapper changeBalanceUrlMapper;
    @Resource
    private UserBillDetailMapper userBillDetailMapper;
    @Resource
    private UserAccountMapper userAccountMapper;
    @Resource
    private UserActMapper userActMapper;
    @Resource
    private FreezeTaskMapper freezeTaskMapper;
    @Resource
    private RollbackMoneyMapper rollbackMoneyMapper;

    public void executeService(String orderId) throws Exception{

            /*发货状态
            3.已发货--已收货：20
              订单主状态
            2.交易成功（确认收货了）：20
            `type` varchar(45) DEFAULT NULL COMMENT '订单总状态',20
            `send_type` varchar(45) DEFAULT NULL COMMENT '发货状态',20
             `type_desc` varchar(45) DEFAULT NULL,”用户已确认收货“
             `getdell_time` varchar(45) DEFAULT NULL COMMENT '成交时间',now()
             */

        try {
            Date date=new Date();
            String time= DateUtil.dateToString(date);
            String date1 = DateUtil.dateToString2(date);
            String strDay = date1;
            String strMonth = date1.substring(4, 6);
            String strYear = date1.substring(0, 4);
            // 1》改变订单的状态
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("type",20);
            map.put("send_type",20);
            map.put("type_desc","用户已确认收货");
            map.put("getdell_time", time);
            map.put("order_id", orderId);
            orderMapper.updateState(map);
            Order order=orderMapper.getOrderByOrderId(orderId);
            //2>>如果是主订单就把所有子订单为付款的都屏蔽
            if(order.getPid()==null){//说明是主订单
                List<Order> orders=orderMapper.getSubOrderByOrderId(orderId);
                if(orders.size()!=0) {
                    Map<String, Object> subMap=null;
                    String billId=null;
                    Long useBalance1000=0L;
                    Long useBalance2000=0L;
                    Long payBalance=0L;
                    String payCode="";
                    ChangeBalanceUrl changeBalanceUrl=null;
                    UserAct userAct=null;
                    UserAct userAct1=null;
                    UserBillDetail userBillDetail=null;
                    String reason="";
                    for (Order subOrder : orders) {//预选的未付 关闭订单 现在的按钮是删除订单。
                        if (subOrder.getPay_type() == 0) {
                            subMap= new HashMap<String, Object>();
                            subMap.put("type", 40);
                            subMap.put("type_desc", "订单已关闭");
                            subMap.put("closing_time", time);
                            subMap.put("order_id", subOrder.getOrder_id());
                            orderMapper.closeOrder(subMap);
                            userBillDetail=userBillDetailMapper.searOldchYuePay(subOrder.getUid(),subOrder.getOrder_id());
                            if(userBillDetail!=null){
                                billId=userBillDetail.getBill_id();
                                payBalance=userBillDetail.getPay_balance();
                                useBalance1000=userBillDetail.getBlance1000();
                                useBalance2000=userBillDetail.getBlance2000();
                                //还原1000和2000的余额数
                                userAccountMapper.rollBackUserAccountBalanceWith1000(subOrder.getUid(),useBalance1000);
                                userAccountMapper.rollBackUserAccountBalanceWith2000(subOrder.getUid(),useBalance2000);
                                //
                                payCode= "YEHT" + OrderCodeUtil.getOrderNo();//生成支付单号
                                //String bill_id, String relative_id, String relative_type, Long change_money, Striing rollback_reason,
                                // String create_time, String str_day, String str_month, String str_year
                                reason="订单："+order.getOrder_id()+"确认订单后" +
                                        "关闭子订单："+subOrder.getOrder_id()+"时，还原其所支付的余额数："+(double)payBalance/1000+"元";
                                rollbackMoneyMapper.saveRollbackMoney(
                                        new RollbackMoney(subOrder.getUid(),payCode, subOrder.getOrder_id(), 10, payBalance,reason,time, strDay, strMonth, strYear )
                                );
                                changeBalanceUrl= changeBalanceUrlMapper.getUrlByType(6);
                                userAct= userActMapper.getLastAfterMoneyByUserID(subOrder.getUid());
                                userAct1 = new UserAct(subOrder.getUid(), payCode, 20,"20-1" ,changeBalanceUrl.getUrl(), "+", payBalance,
                                        userAct.getAfter_money(), userAct.getAfter_money() +payBalance,useBalance1000,useBalance2000, "余额回退订单：" + subOrder.getOrder_id(),
                                        time, strDay, strMonth, strYear);
                                userActMapper.saveChangeBalance(userAct1);
                                //将刚才的意向订单的支付订单在userBillDetail中全部改为失效状态
                                userBillDetailMapper.updateBillDetailState(subOrder.getUid(),subOrder.getOrder_id());
                            }
                        }
                    }
                }
            }

            //3>>更改商户余额
            ShopAccount shopAccount=shopAccountMapper.getShopAccount(order.getSeller_id(),1000);
            Long nowShopAccountBalance=shopAccount==null?0:shopAccount.getBalance()+order.getPrice();
            //(@Param("seller_id") String seller_id,@Param("account_type") int account_type);
            shopAccountMapper.updateShopAccount(order.getSeller_id(),1000,nowShopAccountBalance);


            //4>>添加商户流水
            ShopBalance shopBalance=shopBalanceMapper.searchLastBalance(order.getSeller_id());
            Long beforePrice=shopBalance==null?0:shopBalance.getAfter_money();
            Long afterPrice=beforePrice+order.getPrice();
            String payCode = "JYDK" + OrderCodeUtil.getOrderNo();//生成支付单号    交易付款
            ChangeBalanceUrl changeBalanceUrl = changeBalanceUrlMapper.getUrlByType(7);

            /*
            (String seller_id, String bill_id, Integer act_type, String url,
            String type, Long change_money, Long before_money, Long after_money,
            String opt_desc, String create_time, String str_day, String str_month, String str_year)
             */
            shopBalanceMapper.saveNewShopBalance(
                    new ShopBalance
                            (
                                    order.getSeller_id(), payCode, 1, changeBalanceUrl.getUrl(), "+", order.getPrice(),
                                    beforePrice, afterPrice, "交易订单号：" + orderId + "打款", time, strDay, strMonth, strYear
                            ));


            //5>>生成商户可提现的task
            //(String seller_id, String order_id, Long price, Integer state, Integer opt_num, String opt_desc,
            // String opt_time, String create_time, String start_time, String str_year, String str_month,
            // String str_day)
            String startTime=DateUtil.dateToString(new Date(date.getTime()+(long)3*24*60*60*1000));
            freezeTaskMapper.saveFreezeTask(new FreezeTask(order.getSeller_id(), orderId, order.getPrice(), 1000, 0,
                    "生成商户可提现任务", null, time, startTime, strYear, strMonth, strDay));
            //------------------
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}
