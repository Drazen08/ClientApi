package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙旌翔 on 2016/7/18.
 */
public class USR1015_ReqBody extends AbstractBaseRequestBody {

public USR1015_ReqBody(){}



    /**
     * id : 编号
     */

    private int id;

    public USR1015_ReqBody(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
