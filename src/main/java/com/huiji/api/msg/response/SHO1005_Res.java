package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/10/9.
 */
public class SHO1005_Res<SHO1005_ResBody> extends AbstractBaseResponse<SHO1005_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
