package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
public class PAY1003_Res <PAY1003_ResBody> extends AbstractBaseResponse<PAY1003_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
