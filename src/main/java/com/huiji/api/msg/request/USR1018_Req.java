package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1018_ReqBody;

/**
 * Created by 孙文剑 on 2016/7/27 0027.
 */
public class USR1018_Req extends AbstractBaseRequest<USR1018_ReqBody> {
    @Override
    public Class<USR1018_ReqBody> getReqObjectType() {
        return USR1018_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
