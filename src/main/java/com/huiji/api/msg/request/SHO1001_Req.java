package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.SHO1001_ReqBody;

/**
 * Created by Jingxiang on 2016/8/8.
 */
public class SHO1001_Req extends AbstractBaseRequest<SHO1001_ReqBody> {
    @Override
    public Class<SHO1001_ReqBody> getReqObjectType() {
        return SHO1001_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
