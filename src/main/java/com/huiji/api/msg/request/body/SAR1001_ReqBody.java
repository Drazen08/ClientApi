package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙文剑 on 2016/8/4 0004.
 */
public class SAR1001_ReqBody extends AbstractBaseRequestBody {

    /**
     * content : 搜索内容
     * type : 搜索类型（销量综合人气）
     * currentPage :
     */

    private String content;
    private int type;
    private int currentPage;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
