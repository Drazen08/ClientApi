package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Administrator on 2016/7/17.
 */
public class USR1009_ReqBody extends AbstractBaseRequestBody{

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
