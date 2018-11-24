package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;
import com.huiji.api.msg.response.base.BaseResponse;

/**
 * Created by yasenagat on 16/7/13 Time 下午10:33.
 */
public class USR1000_Res<USR1000_ResBody> extends AbstractBaseResponse<USR1000_ResBody> {

    @Override
    public String getMode() {
        return mode2();
    }
}
