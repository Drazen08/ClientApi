package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1022_ReqBody;

/**
 * Created by Jingxiang on 2016/8/12.
 */
public class USR1022_Req extends AbstractBaseRequest<USR1022_ReqBody> {
    @Override
    public Class<USR1022_ReqBody> getReqObjectType() {
        return USR1022_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
