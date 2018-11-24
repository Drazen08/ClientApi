package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Administrator on 2016/7/17.
 */
public class USR1010_Res<USR1010_ResBody> extends AbstractBaseResponse<USR1010_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
