package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Administrator on 2016/10/13.
 */
public class PAY1005_Res <PAY1005_ResBody> extends AbstractBaseResponse<PAY1005_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
