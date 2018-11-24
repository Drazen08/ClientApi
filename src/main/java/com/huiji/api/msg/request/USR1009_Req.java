package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1009_ReqBody;

/**
 * Created by Administrator on 2016/7/17.
 */
public class USR1009_Req extends AbstractBaseRequest<USR1009_ReqBody> {
    @Override
    public Class<USR1009_ReqBody> getReqObjectType() {
        return USR1009_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
