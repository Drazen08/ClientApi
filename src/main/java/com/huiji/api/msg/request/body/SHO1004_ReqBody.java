package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class SHO1004_ReqBody extends AbstractBaseRequestBody {
    public SHO1004_ReqBody(){}


    /**
     * type : 是否关注1关注/0 不关注
     * shopId :
     */

    private Integer type;
    private String shopId;



    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public SHO1004_ReqBody(Integer type, String shopId) {
        this.type = type;
        this.shopId = shopId;
    }
}
