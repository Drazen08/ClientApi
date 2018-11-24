package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/7/27 0027.
 */
public class USR1018_Res<USR1018_ResBody> extends AbstractBaseResponse<USR1018_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
