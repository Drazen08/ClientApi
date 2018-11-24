package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙旌翔 on 2016/7/16.
 */
public class USR1012_Res<USR1012_ResBody> extends AbstractBaseResponse<USR1012_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
