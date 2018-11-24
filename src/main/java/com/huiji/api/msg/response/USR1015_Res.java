package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;
import com.huiji.api.msg.response.body.USR1015_ResBody;

/**
 * Created by 孙旌翔 on 2016/7/18.
 */
public class USR1015_Res<USR1015_ResBody> extends AbstractBaseResponse<USR1015_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
