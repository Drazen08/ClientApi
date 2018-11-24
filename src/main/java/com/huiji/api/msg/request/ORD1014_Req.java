package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ORD1014_ReqBody;

/**
 * Created by Administrator on 2016/10/27.
 */
public class ORD1014_Req extends AbstractBaseRequest<ORD1014_ReqBody> {
    @Override
    public Class<ORD1014_ReqBody> getReqObjectType() {
        return ORD1014_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
