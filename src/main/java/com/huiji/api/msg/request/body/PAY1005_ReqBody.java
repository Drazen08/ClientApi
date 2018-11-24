package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
public class PAY1005_ReqBody extends AbstractBaseRequestBody {

    private List<String> orders;

    public List<String> getOrders() {
        return orders;
    }

    public void setOrders(List<String> orders) {
        this.orders = orders;
    }
}
