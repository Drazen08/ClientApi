package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class USR1004_ResBody extends AbstractResponseBody {

    /**
     * token : 令牌
     */

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
