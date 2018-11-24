package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙旌翔 on 2016/7/16.
 */
public class USR1013_Res<USR1013_ResBody> extends AbstractBaseResponse<USR1013_ResBody> {

    @Override
    public String getMode() {
        return mode2();
    }
}
