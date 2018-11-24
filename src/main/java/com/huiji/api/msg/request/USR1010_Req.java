package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1010_ReqBody;

/**
 * Created by Administrator on 2016/7/17.
 */
public class USR1010_Req extends AbstractBaseRequest<USR1010_ReqBody> {
    @Override
    public Class<USR1010_ReqBody> getReqObjectType() {
        return USR1010_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
