package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.DIC1003_ReqBody;

/**
 * Created by Jingxiang on 2016/8/14.
 */
public class DIC1003_Req extends AbstractBaseRequest<DIC1003_ReqBody> {
    @Override
    public Class<DIC1003_ReqBody> getReqObjectType() {
        return DIC1003_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
