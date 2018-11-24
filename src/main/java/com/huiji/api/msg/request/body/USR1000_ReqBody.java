package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by yasenagat on 16/7/14 Time 上午10:29.
 */
public class USR1000_ReqBody extends AbstractBaseRequestBody{


    /**
     * phone : 手机号
     * password : 登录密码(32字节MD5)
     * activeCode : 验证码
     */

    private String phone;
    private String password;
    private String activeCode;

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

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }
}
