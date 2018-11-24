package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/9.
 */
public class GOO1001_Res<GOO1001_ResBody> extends AbstractBaseResponse<GOO1001_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
