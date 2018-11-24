package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.ORD1004_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.msg.request.body.ORD1004_ReqBody;
import com.huiji.api.msg.response.body.ORD1004_ResBody;
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
public class ORD1004_ServiceImpl implements ORD1004_Service {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private BillDetailMapper billDetailMapper;
    @Resource
    private UserBillDetailMapper userBillDetailMapper;
    @Resource
    private UserActMapper userActMapper;
    @Resource
    private UserAccountMapper userAccountMapper;
    @Resource
    private ChangeBalanceUrlMapper changeBalanceUrlMapper;
    @Resource
    private RollbackMoneyMapper rollbackMoneyMapper;

    public void executeService(String uid,ORD1004_ReqBody ord1004_reqBody) throws Exception{

        try {
            Date date = new Date();
            String createDate = DateUtil.dateToString(date);
            String orderId=ord1004_reqBody.getOrderId();
            String date1 = DateUtil.dateToString2(new Date());
            String strDay = date1;
            String strMonth = date1.substring(4, 6);
            String strYear = date1.substring(0, 4);

            Order order=orderMapper.getOrderByOrderId(orderId);

            BillDetail billDetail=null;
            if (order.getPay_type()==0){
                billDetail=billDetailMapper.getbalanceBill(ord1004_reqBody.getOrderId());
            }

            if(billDetail==null){
                //未使用余额的情况
                int a=orderMapper.closeordeer(ord1004_reqBody.getOrderId(),String.valueOf(ord1004_reqBody.getReason()));

//                if(a==1){
//                    ord1004_resBody.setResult("0");
//                    ord1004_resBody.setResultDesc("操作成功");
//                    response.setBodyObject(ord1004_resBody);
//                    response.setResult(ResultCode.SUCCESS);
//
//                }else{
//                    ord1004_resBody.setResult("1");
//                    ord1004_resBody.setResultDesc("操作失败");
//                    response.setBodyObject(ord1004_resBody);
//                    response.setResult(ResultCode.PARAM_ERROR);

//                }

            }else {
                /*  private Integer id;private String  uid;private String  bill_id;
   //资金变动性质
    private Integer act_type;
    private String  url;
    private String  type;
    private Long    change_money;
    private Long    before_money;
    private Long    after_money;
    private Long    balance1000;
    private Long    balance2000;
    private String  opt_desc;
    private String create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;
    */

                //生成退还余额的bill_id
                String bill_id = OrderCodeUtil.getOrderNo();
                UserAct userActs= userActMapper.getLastAfterMoneyByUserID(uid);
                //获取之前的余额付款明细记录
                UserAct userAct = userActMapper.getbalancechange(billDetail.getBill_id());
                Long balance = userAct.getBalance1000() + userAct.getBalance2000();
                String reason="取消订单："+order.getOrder_id()+"，并还原所用的余额数"+(double)balance/1000+"元";
                rollbackMoneyMapper.saveRollbackMoney(
                        new RollbackMoney(order.getUid(),bill_id, order.getOrder_id(), 10, balance,reason,createDate, strDay, strMonth, strYear )
                );
                UserAct userAct1 = new UserAct(uid, bill_id, 20,"20-1" , userAct.getUrl(), "+", balance, userActs.getAfter_money(), userActs.getAfter_money() + balance, userAct.getBalance1000(), userAct.getBalance2000(), "余额返还",
                        createDate, strDay, strMonth, strYear);
                //生成新的余额退款记录
                userActMapper.saveChangeBalance(userAct1);
                //获取变动前的用户余额数

                UserAccount userAccount2000 = userAccountMapper.getUsetAccountByUserIdWith2000(uid);//不可体现的
                UserAccount userAccount1000 = userAccountMapper.getUserAccountByUserIdWith1000(uid);//可体现的
                Long balance1000 = userAccount1000.getBalance() + userAct.getBalance1000();
                Long balance2000 = userAccount2000.getBalance() + userAct.getBalance2000();

                userAccountMapper.updateUserAccountBalanceWith1000(uid, balance1000);
                userAccountMapper.updateUserAccountBalanceWith2000(uid, balance2000);
                Integer b = orderMapper.closeordeer(ord1004_reqBody.getOrderId(), String.valueOf(ord1004_reqBody.getReason()));


            }

            List<Order> orders=orderMapper.getSubOrderByOrderId(orderId);
            if(orders.size()!=0) {
                Map<String, Object> subMap = null;
                for (Order subOrder : orders) {//预选的未付 关闭订单 现在的按钮是删除订单。
                    if (subOrder.getPay_type() == 0) {
                        subMap = new HashMap<String, Object>();
                        subMap.put("type", 40);
                        subMap.put("type_desc", "订单已关闭");
                        subMap.put("closing_time", createDate);
                        subMap.put("order_id", subOrder.getOrder_id());
                        orderMapper.closeOrder(subMap);
                    }
                }

            }
            //userBillDetail中全部改为失效状态
            userBillDetailMapper.updateBillDetailState(uid,ord1004_reqBody.getOrderId());

        } catch (Exception e) {
            e.printStackTrace();
            throw  e;
        }
    }

}
