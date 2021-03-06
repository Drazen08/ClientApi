package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.PAY1001_ReqBody;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
public class PAY1001_Req extends AbstractBaseRequest<PAY1001_ReqBody> {
    @Override
    public Class<PAY1001_ReqBody> getReqObjectType() {
        return PAY1001_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
