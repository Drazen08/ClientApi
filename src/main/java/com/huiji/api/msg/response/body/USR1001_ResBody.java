package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

/**
 * Created by 孙旌翔 on 2016/7/16.
 */
public class USR1001_ResBody extends AbstractResponseBody {
    public USR1001_ResBody(){}
    public USR1001_ResBody(String sid, String userName, String phone) {
        this.sid = sid;
        this.userName = userName;
        this.phone = phone;
    }

    /**
     * sid : 会话编号
     * userName : 用户名
     * phone : 手机号
     */

    private String sid;
    private String userName;
    private String phone;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
