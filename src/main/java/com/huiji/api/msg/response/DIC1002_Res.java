package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/13.
 */
public class DIC1002_Res<DIC1002_ResBody> extends AbstractBaseResponse<DIC1002_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
