package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
public class PAY1004_Res <PAY1004_ResBody> extends AbstractBaseResponse<PAY1004_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
