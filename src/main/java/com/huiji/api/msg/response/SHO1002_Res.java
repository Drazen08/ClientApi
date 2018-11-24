package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/9.
 */
public class SHO1002_Res<SHO1002_ResBody>extends AbstractBaseResponse<SHO1002_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }

}
