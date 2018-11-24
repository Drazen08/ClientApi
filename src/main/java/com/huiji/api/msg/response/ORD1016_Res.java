package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Administrator on 2016/10/31.
 */
public class ORD1016_Res <ORD1016_ResBody> extends AbstractBaseResponse<ORD1016_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
