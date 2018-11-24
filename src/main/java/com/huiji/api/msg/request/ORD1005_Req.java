package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ORD1005_ReqBody;

/**
 * Created by Jingxiang on 2016/8/11.
 */
public class ORD1005_Req extends AbstractBaseRequest<ORD1005_ReqBody> {
    @Override
    public Class<ORD1005_ReqBody> getReqObjectType() {
        return ORD1005_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
