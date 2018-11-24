package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/8.
 */
public class SHO1000_Res<SHO1000_ResBody> extends AbstractBaseResponse<SHO1000_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
