package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙文剑 on 2016/7/23 0023.
 */
public class USR1017_ReqBody extends AbstractBaseRequestBody {
    private int id;
    private String topFlag;

    public String getTopFlag() {
        return topFlag;
    }

    public void setTopFlag(String topFlag) {
        this.topFlag = topFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
