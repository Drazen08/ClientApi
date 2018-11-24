package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class SYS1000_Res<SYS1000_ResBody> extends AbstractBaseResponse<SYS1000_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
