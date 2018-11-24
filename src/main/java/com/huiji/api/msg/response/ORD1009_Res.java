package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/8/7 0007.
 */
public class ORD1009_Res <ORD1009_ResBody> extends AbstractBaseResponse<ORD1009_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
