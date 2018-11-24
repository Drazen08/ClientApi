package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.SHO1005_ReqBody;

/**
 * Created by Jingxiang on 2016/10/9.
 */
public class SHO1005_Req extends AbstractBaseRequest<SHO1005_ReqBody> {
    @Override
    public Class<SHO1005_ReqBody> getReqObjectType() {
        return SHO1005_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
