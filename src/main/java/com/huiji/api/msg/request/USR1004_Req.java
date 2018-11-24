package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1004_ReqBody;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class USR1004_Req extends AbstractBaseRequest<USR1004_ReqBody> {
    @Override
    public Class<USR1004_ReqBody> getReqObjectType() {
        return USR1004_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
