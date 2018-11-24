package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/8/4 0004.
 */
public class SAR1001_Res <SAR1001_ResBody> extends AbstractBaseResponse<SAR1001_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
