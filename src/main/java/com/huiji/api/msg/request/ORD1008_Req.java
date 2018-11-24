package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ORD1008_ReqBody;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public class ORD1008_Req extends AbstractBaseRequest<ORD1008_ReqBody> {
    @Override
    public Class<ORD1008_ReqBody> getReqObjectType() {
        return ORD1008_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
