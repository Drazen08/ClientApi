package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.DIC1000_ReqBody;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
public class DIC1000_Req extends AbstractBaseRequest<DIC1000_ReqBody> {
    @Override
    public Class<DIC1000_ReqBody> getReqObjectType() {
        return DIC1000_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
