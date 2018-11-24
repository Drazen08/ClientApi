package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class ORD1002_Res<ORD1002_ResBody> extends AbstractBaseResponse<ORD1002_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
