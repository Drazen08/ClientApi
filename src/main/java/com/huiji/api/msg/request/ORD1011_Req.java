package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ORD1011_ReqBody;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
public class ORD1011_Req extends AbstractBaseRequest<ORD1011_ReqBody> {
    @Override
    public Class<ORD1011_ReqBody> getReqObjectType() {
        return ORD1011_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
