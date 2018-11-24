package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.PAY1002_ReqBody;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
public class PAY1002_Req extends AbstractBaseRequest<PAY1002_ReqBody> {
    @Override
    public Class<PAY1002_ReqBody> getReqObjectType() {
        return PAY1002_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
