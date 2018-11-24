package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
public class ORD1010_Res <ORD1010_ResBody> extends AbstractBaseResponse<ORD1010_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
