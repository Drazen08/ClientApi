package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/7/16 0015.
 */
public class USR1002_Res<USR1002_ResBody>  extends AbstractBaseResponse<USR1002_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
