package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/8/5 0005.
 */
public class GOO1000_Res <GOO1000_ResBody> extends AbstractBaseResponse<GOO1000_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
