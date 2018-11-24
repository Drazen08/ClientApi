package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ORD1016_ReqBody;

/**
 * Created by Administrator on 2016/10/31.
 */
public class ORD1016_Req  extends AbstractBaseRequest<ORD1016_ReqBody> {
    @Override
    public Class<ORD1016_ReqBody> getReqObjectType() {
        return ORD1016_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
