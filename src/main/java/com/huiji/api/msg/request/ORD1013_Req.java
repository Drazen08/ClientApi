package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ORD1013_ReqBody;

/**
 * Created by Administrator on 2016/9/26.
 */
public class ORD1013_Req extends AbstractBaseRequest<ORD1013_ReqBody> {
    @Override
    public Class<ORD1013_ReqBody> getReqObjectType() {
        return ORD1013_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
