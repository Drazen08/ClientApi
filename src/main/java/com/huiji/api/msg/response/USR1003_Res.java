package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
public class USR1003_Res<USR1003_ResBody> extends AbstractBaseResponse<USR1003_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
