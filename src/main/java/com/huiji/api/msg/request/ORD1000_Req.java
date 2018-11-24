package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ORD1000_ReqBody;

/**
 * Created by Jingxiang on 2016/8/6.
 */
public class ORD1000_Req extends AbstractBaseRequest<ORD1000_ReqBody> {
    @Override
    public Class<ORD1000_ReqBody> getReqObjectType() {
        return ORD1000_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
