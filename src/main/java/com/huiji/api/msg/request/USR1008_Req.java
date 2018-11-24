package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1008_ReqBody;

/**
 * Created by Administrator on 2016/7/17.
 */
public class USR1008_Req extends AbstractBaseRequest<USR1008_ReqBody> {
    @Override
    public Class<USR1008_ReqBody> getReqObjectType() {
        return USR1008_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
