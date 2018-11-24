package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1020_ReqBody;

/**
 * Created by 孙文剑 on 2016/8/4 0004.
 */
public class USR1020_Req extends AbstractBaseRequest<USR1020_ReqBody> {
    @Override
    public Class<USR1020_ReqBody> getReqObjectType() {
        return USR1020_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
