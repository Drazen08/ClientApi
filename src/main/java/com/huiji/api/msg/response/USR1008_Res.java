package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Administrator on 2016/7/17.
 */
public class USR1008_Res<USR1008_ResBody> extends AbstractBaseResponse<USR1008_ResBody>{
    @Override
    public String getMode() {
        return mode1();
    }
}
