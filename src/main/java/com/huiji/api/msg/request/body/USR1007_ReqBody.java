package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Administrator on 2016/7/17.
 */
public class USR1007_ReqBody extends AbstractBaseRequestBody{


    /**
     * phone : 手机号
     * activeCode : 验证码
     * payPassword : 新密码
     */

    private String phone;
    private String activeCode;
    private String payPassword;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }
}
