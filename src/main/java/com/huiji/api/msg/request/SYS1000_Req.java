package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.SYS1000_ReqBody;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class SYS1000_Req extends AbstractBaseRequest<SYS1000_ReqBody> {
    @Override
    public Class<SYS1000_ReqBody> getReqObjectType() {
        return SYS1000_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
