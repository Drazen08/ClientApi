package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/4.
 */
public class SAR1000_Res<SAR1000_ResBody> extends AbstractBaseResponse<SAR1000_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }

}
