package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class MAR1000_Res<MAR1000_ResBody> extends AbstractBaseResponse<MAR1000_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
