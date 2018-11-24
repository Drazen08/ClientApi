package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1021_ReqBody;

/**
 * Created by Jingxiang on 2016/8/4.
 */
public class USR1021_Req extends AbstractBaseRequest<USR1021_ReqBody> {
    @Override
    public Class<USR1021_ReqBody> getReqObjectType() {
        return USR1021_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}