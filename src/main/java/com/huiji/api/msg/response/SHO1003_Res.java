package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class SHO1003_Res<SHO1003_ResBody> extends AbstractBaseResponse<SHO1003_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
