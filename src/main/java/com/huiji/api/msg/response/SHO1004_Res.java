package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class SHO1004_Res<SHO1004_ResBody> extends AbstractBaseResponse<SHO1004_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
