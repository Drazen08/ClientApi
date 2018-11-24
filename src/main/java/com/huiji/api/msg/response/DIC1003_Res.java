package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/14.
 */
public class DIC1003_Res<DIC1003_ResBody> extends AbstractBaseResponse<DIC1003_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
