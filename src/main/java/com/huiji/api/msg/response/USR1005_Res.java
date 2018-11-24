package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class USR1005_Res<USR1005_ResBody> extends AbstractBaseResponse<USR1005_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
