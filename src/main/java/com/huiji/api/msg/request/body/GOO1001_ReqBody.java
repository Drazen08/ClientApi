package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/9.
 */
public class GOO1001_ReqBody extends AbstractBaseRequestBody {

public GOO1001_ReqBody(){}
    /**
     * goodid : 商品id
     * type : 1 全部 2 好评， 3中评，4差评
     * pagenow :
     */

    private Integer goodid;
    private Integer type;
    private Integer pagenow;

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPagenow() {
        return pagenow;
    }

    public void setPagenow(Integer pagenow) {
        this.pagenow = pagenow;
    }

    public GOO1001_ReqBody(Integer goodid, Integer type, Integer pagenow) {
        this.goodid = goodid;
        this.type = type;
        this.pagenow = pagenow;
    }
}
