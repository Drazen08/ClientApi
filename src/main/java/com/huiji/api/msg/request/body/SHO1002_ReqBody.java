package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/9.
 */
public class SHO1002_ReqBody extends AbstractBaseRequestBody {

public SHO1002_ReqBody(){}
    /**
     * shopId : 店铺id
     * type : 类别(1全部、2新品 3人气)
     * pagenow :
     */

    private Integer shopId;
    private Integer typee;
    private Integer pagenow;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getTypee() {
        return typee;
    }

    public void setTypee(Integer typee) {
        this.typee = typee;
    }

    public Integer getPagenow() {
        return pagenow;
    }

    public void setPagenow(Integer pagenow) {
        this.pagenow = pagenow;
    }

    public SHO1002_ReqBody(Integer shopId, Integer typee, Integer pagenow) {
        this.shopId = shopId;
        this.typee = typee;
        this.pagenow = pagenow;
    }
}
