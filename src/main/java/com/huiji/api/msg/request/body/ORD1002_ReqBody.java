package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class ORD1002_ReqBody extends AbstractBaseRequestBody {
    public ORD1002_ReqBody(){}

    /**
     * orderId : 订单号
     */

    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ORD1002_ReqBody(String orderId) {
        this.orderId = orderId;
    }
}
