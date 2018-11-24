package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/4.
 */
public class USR1021_Res<USR1021_ResBody> extends AbstractBaseResponse<USR1021_ResBody> {
    @Override
    public String getMode() {
        return mode2();
    }
}
