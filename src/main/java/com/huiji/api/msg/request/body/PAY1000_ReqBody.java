package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/8.
 */
public class PAY1000_ReqBody extends AbstractBaseRequestBody {
    /**
     * orderIds :
     */

    private List<String> orderId;

    public PAY1000_ReqBody() {
    }

    public List<String> getOrderId() {
        return orderId;
    }

    public void setOrderId(List<String> orderId) {
        this.orderId = orderId;
    }
}



