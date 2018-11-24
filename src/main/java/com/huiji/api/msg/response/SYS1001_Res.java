package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class SYS1001_Res<SYS1001_ResBody> extends AbstractBaseResponse<SYS1001_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
