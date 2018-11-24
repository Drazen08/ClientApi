package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/11.
 */
public class ORD1004_Res<ORD1004_ResBody> extends AbstractBaseResponse<ORD1004_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
