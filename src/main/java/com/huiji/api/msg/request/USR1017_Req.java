package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1017_ReqBody;

/**
 * Created by 孙文剑 on 2016/7/23 0023.
 */
public class USR1017_Req extends AbstractBaseRequest<USR1017_ReqBody> {
    @Override
    public Class<USR1017_ReqBody> getReqObjectType() {
        return USR1017_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
