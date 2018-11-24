package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/7/23 0023.
 */
public class USR1017_Res<USR1017_ResBody> extends AbstractBaseResponse<USR1017_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
