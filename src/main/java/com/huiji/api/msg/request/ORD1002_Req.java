package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ORD1002_ReqBody;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class ORD1002_Req extends AbstractBaseRequest<ORD1002_ReqBody> {
    @Override
    public Class<ORD1002_ReqBody> getReqObjectType() {
        return ORD1002_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
