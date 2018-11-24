package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1006_ReqBody;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class USR1006_Req extends AbstractBaseRequest<USR1006_ReqBody> {
    @Override
    public Class<USR1006_ReqBody> getReqObjectType() {
        return USR1006_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
