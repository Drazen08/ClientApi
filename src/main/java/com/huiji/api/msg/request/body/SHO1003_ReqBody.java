package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class SHO1003_ReqBody extends AbstractBaseRequestBody {
    public SHO1003_ReqBody(){}

    /**
     * searchContent :
     * pageNow :
     * shopid : 商铺id
     */

    private String searchContent;
    private Integer pageNow;
    private Integer shopid;

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public SHO1003_ReqBody(String searchContent, Integer pageNow, Integer shopid) {
        this.searchContent = searchContent;
        this.pageNow = pageNow;
        this.shopid = shopid;
    }
}
