package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Administrator on 2016/10/31.
 */
public class ORD1015_Res <ORD1015_ResBody> extends AbstractBaseResponse<ORD1015_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
