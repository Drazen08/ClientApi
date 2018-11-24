package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
public class ORD1011_Res <ORD1011_ResBody> extends AbstractBaseResponse<ORD1011_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
