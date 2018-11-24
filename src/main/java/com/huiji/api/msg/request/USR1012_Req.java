package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1012_ReqBody;
import com.huiji.api.msg.response.body.USR1012_ResBody;

/**
 * Created by 孙旌翔 on 2016/7/16.
 */
public class USR1012_Req extends AbstractBaseRequest<USR1012_ReqBody> {
    @Override
    public Class<USR1012_ReqBody> getReqObjectType() {
        return USR1012_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
