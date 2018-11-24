package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.SHO1000_ReqBody;

/**
 * Created by Jingxiang on 2016/8/8.
 */
public class SHO1000_Req extends AbstractBaseRequest<SHO1000_ReqBody> {
    @Override
    public Class<SHO1000_ReqBody> getReqObjectType() {
        return SHO1000_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
