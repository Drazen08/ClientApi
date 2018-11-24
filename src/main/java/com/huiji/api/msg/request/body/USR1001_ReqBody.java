package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

import java.util.Map;

/**
 * Created by 孙旌翔 on 2016/7/16.
 */
public class USR1001_ReqBody extends AbstractBaseRequestBody {
    public USR1001_ReqBody(){}
    /**
     * phone : 手机号
     * password : 登录密码(32字节MD5)
     */
    private String phone;
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
