package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.GOO1001_ReqBody;

/**
 * Created by Jingxiang on 2016/8/9.
 */
public class GOO1001_Req extends AbstractBaseRequest<GOO1001_ReqBody> {
    @Override
    public Class<GOO1001_ReqBody> getReqObjectType() {
        return GOO1001_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
