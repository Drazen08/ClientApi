package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Administrator on 2016/9/26.
 */
public class ORD1013_Res <ORD1013_ResBody> extends AbstractBaseResponse<ORD1013_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
