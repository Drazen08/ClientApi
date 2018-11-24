package com.huiji.api.msg.response;


import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙旌翔 on 2016/7/18.
 */
public class USR1014_Res<USR1014_ResBody> extends AbstractBaseResponse<USR1014_ResBody> {

    @Override
    public String getMode() {
        return mode2();
    }
}
