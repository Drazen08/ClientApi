package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ORD1009_ReqBody;

/**
 * Created by 孙文剑 on 2016/8/7 0007.
 */
public class ORD1009_Req extends AbstractBaseRequest<ORD1009_ReqBody> {
    @Override
    public Class<ORD1009_ReqBody> getReqObjectType() {
        return ORD1009_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
