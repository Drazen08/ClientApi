package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class USR1005_ReqBody extends AbstractBaseRequestBody {

    /**
     * token : 令牌
     * password : 密码
     */

    private String token;
    private String password;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
