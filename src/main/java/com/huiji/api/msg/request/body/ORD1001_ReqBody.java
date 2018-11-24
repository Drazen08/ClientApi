package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙文剑 on 2016/8/13 0013.
 */
public class ORD1001_ReqBody extends AbstractBaseRequestBody {

    /**
     * orderId : 订单号
     * payPassword : 支付密码
     */

    private String orderId;
    private String payPassword;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }
}
