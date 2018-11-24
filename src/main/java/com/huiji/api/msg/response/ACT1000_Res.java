package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/5.
 */
public class ACT1000_Res<ACT1000_ResBody> extends AbstractBaseResponse<ACT1000_ResBody> {
    @Override
    public String getMode() {
        return mode2();
    }
}
