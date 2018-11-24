package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/12.
 */
public class USR1022_Res<USR1022_ResBody> extends AbstractBaseResponse<USR1022_ResBody> {
    @Override
    public String getMode() {
        return mode2();
    }
}
