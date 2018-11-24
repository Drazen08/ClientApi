package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/5.
 */
public class ACT1000_ReqBody extends AbstractBaseRequestBody {
    public ACT1000_ReqBody(){}

    /**
     * month : 月份
     * type : 类型:1全部2充值3退款
     * currentPage : 当前页都是int
     */

    private Integer month;
    private Integer type;
    private Integer currentPage;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
