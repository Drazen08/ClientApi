package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ORD1004_ReqBody;

/**
 * Created by Jingxiang on 2016/8/11.
 */
public class ORD1004_Req extends AbstractBaseRequest<ORD1004_ReqBody> {
    @Override
    public Class<ORD1004_ReqBody> getReqObjectType() {
        return ORD1004_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
