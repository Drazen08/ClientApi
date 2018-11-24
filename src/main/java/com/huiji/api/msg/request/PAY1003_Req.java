package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.PAY1003_ReqBody;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
public class PAY1003_Req extends AbstractBaseRequest<PAY1003_ReqBody> {
    @Override
    public Class<PAY1003_ReqBody> getReqObjectType() {
        return PAY1003_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
