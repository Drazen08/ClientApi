package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1019_ReqBody;

/**
 * Created by 孙文剑 on 2016/8/4 0004.
 */
public class USR1019_Req extends AbstractBaseRequest<USR1019_ReqBody> {
    @Override
    public Class<USR1019_ReqBody> getReqObjectType() {
        return USR1019_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
