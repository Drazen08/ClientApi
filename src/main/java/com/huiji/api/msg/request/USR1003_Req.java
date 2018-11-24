package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1003_ReqBody;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
public class USR1003_Req extends AbstractBaseRequest<USR1003_ReqBody> {
    @Override
    public Class<USR1003_ReqBody> getReqObjectType() {
        return USR1003_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
