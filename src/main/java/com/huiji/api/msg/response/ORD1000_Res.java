package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/6.
 */
public class ORD1000_Res<ORD1000_ResBody> extends AbstractBaseResponse<ORD1000_ResBody> {
    @Override
    public String getMode() {
        return mode2();
    }
}
