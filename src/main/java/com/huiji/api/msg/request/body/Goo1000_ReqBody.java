package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙文剑 on 2016/8/5 0005.
 */
public class Goo1000_ReqBody extends AbstractBaseRequestBody {


    /**
     * goodId : 商品id
     */

    private int goodId;

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }
}
