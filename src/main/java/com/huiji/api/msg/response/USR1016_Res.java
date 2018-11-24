package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 孙旌翔 on 2016/7/18.
 */
public class USR1016_Res<USR1016_ResBody> extends AbstractBaseResponse<USR1016_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
