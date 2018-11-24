package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
public class PAY1003_ReqBody extends AbstractBaseRequestBody {

    /**
     * balance : 余额数
     * orderId : 订单号
     */

    private Long balance;
    private String orderId;

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
