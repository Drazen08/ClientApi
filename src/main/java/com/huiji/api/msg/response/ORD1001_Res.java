package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/8/13 0013.
 */
public class ORD1001_Res <ORD1001_ResBody> extends AbstractBaseResponse<ORD1001_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
