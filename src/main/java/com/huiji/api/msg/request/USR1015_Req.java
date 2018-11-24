package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1015_ReqBody;

/**
 * Created by 孙旌翔 on 2016/7/18.
 */
public class USR1015_Req  extends AbstractBaseRequest<USR1015_ReqBody> {
    @Override
    public Class<USR1015_ReqBody> getReqObjectType() {
        return USR1015_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
