package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1002_ReqBody;

/**
 * Created by 孙文剑 on 2016/7/16 0015.
 */
public class USR1002_Req extends AbstractBaseRequest<USR1002_ReqBody> {
    @Override
    public Class<USR1002_ReqBody> getReqObjectType() {
        return USR1002_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
