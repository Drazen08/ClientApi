package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
public class DIC1000_Res<DIC1000_ResBody> extends AbstractBaseResponse<DIC1000_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
