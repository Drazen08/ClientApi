package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/11.
 */
public class ORD1004_ReqBody extends AbstractBaseRequestBody {
    /**
     * orderId : 订单号
     * reason : 取消原因
     */

    private String orderId;
    private Integer reason;

    public ORD1004_ReqBody(){}


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getReason() {
        return reason;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }

    public ORD1004_ReqBody(String orderId, Integer reason) {
        this.orderId = orderId;
        this.reason = reason;
    }
}
