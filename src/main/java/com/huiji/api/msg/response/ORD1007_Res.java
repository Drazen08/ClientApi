package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/8/8 0008.
 */
public class ORD1007_Res <ORD1007_ResBody> extends AbstractBaseResponse<ORD1007_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
