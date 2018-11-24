package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public class ORD1008_Res <ORD1008_ResBody> extends AbstractBaseResponse<ORD1008_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
