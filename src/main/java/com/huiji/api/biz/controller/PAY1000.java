package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.msg.request.PAY1000_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.PAY1000_ReqBody;
import com.huiji.api.msg.response.PAY1000_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.PAY1000_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingxiang on 2016/8/8.支付方式查询
 */
@RestController
public class PAY1000 extends AbstractBaseController<PAY1000_Req, PAY1000_ReqBody, PAY1000_Res, PAY1000_ResBody> {

    @Resource
    private BillDetailMapper billDetailMapper;
    @Resource
    private PayMapper payMapper;
    /*@Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private UserAccountMapper userAccountMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderPayLockMapper orderPayLockMapper;

    @RequestMapping(URLPREFIX + "/PAY1000/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(PAY1000_Req pay1000_req) {
        return true;
    }

    @Override
    public PAY1000_Res getRes() {
        return new PAY1000_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<PAY1000_ReqBody> request, String uid) throws Exception {
        try {
            PAY1000_ReqBody pay1000_reqBody = request.getBodyObject();
            PAY1000_ResBody pay1000_resBody = new PAY1000_ResBody();
            StringBuffer sbf = new StringBuffer("");
            Long money = 0L;
            long usedBalance = 0l;
            List<String> orderIds = pay1000_reqBody.getOrderId();//
            StringBuffer paying = new StringBuffer();
            paying.append("in (");
            for (int i = 0; i < orderIds.size() - 1; i++) {
                paying.append(orderIds.get(i) + ",");
            }
            paying.append(orderIds.get(orderIds.size() - 1));
            paying.append(")");
            StringBuffer ordPaying=new StringBuffer();
            List<Order> orderPaySuccess=orderMapper.getOrderPaySuccess(paying.toString());
            for (Order order : orderPaySuccess) {
                ordPaying.append("订单"+order.getOrder_id()+"已付款成功；");
            }
            if(ordPaying.length()!=0) {
                ordPaying.append("无法使用支付方式");
                pay1000_resBody.setItems(new ArrayList<PAY1000_ResBody.ItemsBean>());
                pay1000_resBody.setBalance(0);
                pay1000_resBody.setFlag(0);
                pay1000_resBody.setBalancedesc(ordPaying.toString());
                pay1000_resBody.setPayingState("1");
                response.setBodyObject(pay1000_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }

            List<OrderPayLock> orderPayings = orderPayLockMapper.getPayLock(paying.toString());

            for (OrderPayLock orderPaying : orderPayings) {
                ordPaying.append("订单"+orderPaying.getOrder_id()+"付款进行中；");
            }
            if(ordPaying.length()!=0) {
                ordPaying.append("无法使用支付方式");
                pay1000_resBody.setItems(new ArrayList<PAY1000_ResBody.ItemsBean>());
                pay1000_resBody.setBalance(0);
                pay1000_resBody.setFlag(0);
                pay1000_resBody.setBalancedesc(ordPaying.toString());
                pay1000_resBody.setPayingState("1");
                response.setBodyObject(pay1000_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }


            for (String orderId : orderIds) {
                Order order = orderMapper.getOrderByOrderId(orderId);
                BillDetail billDetail = null;
                if (order.getPay_type() == 0) {
                    billDetail = billDetailMapper.getbalanceBill(orderId);
                }
                if (billDetail != null) {
//                    pay1000_resBody.setFlag(1);//"您已绑定过的余额，支付时间为" + billDetail.getCreate_time()
                    usedBalance += billDetail.getPay_balance();
                    sbf.append("订单:" + orderId + "已绑定的余额:" + billDetail.getPay_balance() + ";");

                }
            }
            List<UserAccount> userAccounts = userAccountMapper.getBalance1(uid);
            if (userAccounts.size() != 0) {
                for (UserAccount userAccount : userAccounts) {
                    money += userAccount.getBalance();
                }
            }
            List<Pay> li = payMapper.getPays();
            List<PAY1000_ResBody.ItemsBean> list = new ArrayList<PAY1000_ResBody.ItemsBean>();
            for (Pay pay : li) {
                PAY1000_ResBody.ItemsBean itemsBean = new PAY1000_ResBody.ItemsBean();
                itemsBean.setPayType(pay.getId());
                itemsBean.setPayTypeName(pay.getDescribe());
                itemsBean.setPayTypeIcon(pay.getUrl());
                list.add(itemsBean);
            }
            if (usedBalance == 0) {
                pay1000_resBody.setFlag(0);
            } else {
                pay1000_resBody.setFlag(1);
            }
            pay1000_resBody.setItems(list);
            pay1000_resBody.setBalance(money + usedBalance);
            pay1000_resBody.setBalancedesc(sbf.toString());
            pay1000_resBody.setPayingState("0");
            response.setBodyObject(pay1000_resBody);
            response.setResult(ResultCode.SUCCESS);


        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<PAY1000_Req> getReqType() {
        return PAY1000_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }


}
