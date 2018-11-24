package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.SHO1002_ReqBody;

/**
 * Created by Jingxiang on 2016/8/9.
 */
public class SHO1002_Req extends AbstractBaseRequest<SHO1002_ReqBody> {
    @Override
    public Class<SHO1002_ReqBody> getReqObjectType() {
        return SHO1002_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
