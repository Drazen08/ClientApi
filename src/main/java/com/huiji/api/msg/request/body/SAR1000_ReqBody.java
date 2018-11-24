package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/4.
 */
public class SAR1000_ReqBody extends AbstractBaseRequestBody {


    /**
     * content : 搜索内容
     * type : 搜索类型（1:全部  2:人气  3:销量）
     * currentPage : 当前页都是int
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
