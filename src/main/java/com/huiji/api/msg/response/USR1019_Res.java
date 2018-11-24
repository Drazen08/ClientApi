package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/8/4 0004.
 */
public class USR1019_Res <USR1019_ResBody> extends AbstractBaseResponse< USR1019_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
