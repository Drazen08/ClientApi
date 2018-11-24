package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.DIC1002_ReqBody;

/**
 * Created by Jingxiang on 2016/8/13.
 */
public class DIC1002_Req  extends AbstractBaseRequest<DIC1002_ReqBody> {

    @Override
    public Class<DIC1002_ReqBody> getReqObjectType() {
        return DIC1002_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
