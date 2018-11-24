package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
public class PAY1002_ReqBody extends AbstractBaseRequestBody {
    /**
     * orderId : 订单号
     * balance : 余额数
     */

    private  List<String> orderIds;
    private Long balance;

    public List<String> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<String> orderIds) {
        this.orderIds = orderIds;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
