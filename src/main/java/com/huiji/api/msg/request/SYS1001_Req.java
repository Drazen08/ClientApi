package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.SYS1001_ReqBody;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class SYS1001_Req extends AbstractBaseRequest<SYS1001_ReqBody> {
    @Override
    public Class<SYS1001_ReqBody> getReqObjectType() {
        return SYS1001_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
