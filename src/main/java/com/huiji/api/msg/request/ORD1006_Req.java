package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ORD1006_ReqBody;

/**
 * Created by Jingxiang on 2016/8/11.
 */
public class ORD1006_Req extends AbstractBaseRequest<ORD1006_ReqBody> {
    @Override
    public Class<ORD1006_ReqBody> getReqObjectType() {
        return ORD1006_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
