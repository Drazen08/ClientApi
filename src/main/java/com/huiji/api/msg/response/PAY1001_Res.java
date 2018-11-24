package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
public class PAY1001_Res <PAY1001_ResBody> extends AbstractBaseResponse<PAY1001_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
