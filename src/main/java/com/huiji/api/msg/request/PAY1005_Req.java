package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.PAY1005_ReqBody;

/**
 * Created by Administrator on 2016/10/13.
 */
public class PAY1005_Req extends AbstractBaseRequest<PAY1005_ReqBody> {
    @Override
    public Class<PAY1005_ReqBody> getReqObjectType() {
        return PAY1005_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
