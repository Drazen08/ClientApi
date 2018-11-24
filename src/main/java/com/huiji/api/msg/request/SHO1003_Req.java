package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.SHO1003_ReqBody;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class SHO1003_Req extends AbstractBaseRequest<SHO1003_ReqBody> {
    @Override
    public Class<SHO1003_ReqBody> getReqObjectType() {
        return SHO1003_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
