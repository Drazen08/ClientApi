package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1005_ReqBody;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class USR1005_Req extends AbstractBaseRequest<USR1005_ReqBody> {
    @Override
    public Class<USR1005_ReqBody> getReqObjectType() {
        return USR1005_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
