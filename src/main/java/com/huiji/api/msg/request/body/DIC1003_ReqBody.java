package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/14.
 */
public class DIC1003_ReqBody extends AbstractBaseRequestBody {
    public DIC1003_ReqBody(){}
    /**
     * navId : 导航id
     * type : 1人气/2销量
     * pagenow : 当前页
     */

    private Integer navId;
    private Integer type;
    private Integer pagenow;

    public Integer getNavId() {
        return navId;
    }

    public void setNavId(Integer navId) {
        this.navId = navId;
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

    public DIC1003_ReqBody(Integer navId, Integer type, Integer pagenow) {
        this.navId = navId;
        this.type = type;
        this.pagenow = pagenow;
    }
}
