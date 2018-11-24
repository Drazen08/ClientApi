package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Administrator on 2016/7/17.
 */
public class USR1011_Res<USR1011_ResBody> extends AbstractBaseResponse<USR1011_ResBody>{
    @Override
    public String getMode() {
        return mode1();
    }
}
