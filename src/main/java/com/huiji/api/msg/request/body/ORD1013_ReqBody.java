package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Administrator on 2016/9/26.
 */
public class ORD1013_ReqBody extends AbstractBaseRequestBody {

    /**
     * orderId : 要提醒发货的订单
     */

    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
