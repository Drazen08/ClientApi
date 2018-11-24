package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class USR1004_ReqBody extends AbstractBaseRequestBody {

    /**
     * phone : 手机号
     * activeCode : 验证码
     */

    private String phone;
    private String activeCode;

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
}
