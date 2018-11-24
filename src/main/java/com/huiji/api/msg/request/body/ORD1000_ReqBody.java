package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;
import com.huiji.api.util.DateUtil;

/**
 * Created by Jingxiang on 2016/8/6.
 */
public class ORD1000_ReqBody extends AbstractBaseRequestBody {
    public ORD1000_ReqBody(){}
    /**
     * type : 类型:1全部2待支付3待发货4待收货5待评价6退款
     * pageNow : 当前页
     */
    private int type;
    private Integer pageNow;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public ORD1000_ReqBody(int type) {
        this.type = type;
    }
}
