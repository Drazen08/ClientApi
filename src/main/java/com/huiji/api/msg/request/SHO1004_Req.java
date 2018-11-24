package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.SHO1004_ReqBody;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class SHO1004_Req extends AbstractBaseRequest<SHO1004_ReqBody> {
    @Override
    public Class<SHO1004_ReqBody> getReqObjectType() {
        return SHO1004_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
