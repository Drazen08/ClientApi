package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Administrator on 2016/10/27.
 */
public class ORD1014_Res <ORD1014_ResBody> extends AbstractBaseResponse<ORD1014_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
