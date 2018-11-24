package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ORD1001_ReqBody;

/**
 * Created by 孙文剑 on 2016/8/13 0013.
 */
public class ORD1001_Req extends AbstractBaseRequest<ORD1001_ReqBody> {
    @Override
    public Class<ORD1001_ReqBody> getReqObjectType() {
        return ORD1001_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
