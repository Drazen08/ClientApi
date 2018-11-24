package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/8.
 */
public class SHO1001_ReqBody extends AbstractBaseRequestBody {
    public SHO1001_ReqBody(){}

    /**
     * shopid : 店铺id
     */

    private Integer shopid;

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public SHO1001_ReqBody(Integer shopid) {
        this.shopid = shopid;
    }
}
