package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.Goo1000_ReqBody;

/**
 * Created by 孙文剑 on 2016/8/5 0005.
 */
public class GOO1000_Req extends AbstractBaseRequest<Goo1000_ReqBody> {
    @Override
    public Class<Goo1000_ReqBody> getReqObjectType() {
        return Goo1000_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
