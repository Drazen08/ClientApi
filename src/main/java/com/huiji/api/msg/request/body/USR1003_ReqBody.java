package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
public class USR1003_ReqBody extends AbstractBaseRequestBody {
    /**
     * phone : 手机号
     */

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
