package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;
/**
 * Created by Administrator on 2016/7/17.
 */
public class USR1009_Res<USR1009_ResBody> extends AbstractBaseResponse<USR1009_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }

}
