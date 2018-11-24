package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
public class ORD1012_Res <ORD1012_ResBody> extends AbstractBaseResponse<ORD1012_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
