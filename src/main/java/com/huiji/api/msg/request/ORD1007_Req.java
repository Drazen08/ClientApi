package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ORD1007_ReqBody;

/**
 * Created by 孙文剑 on 2016/8/8 0008.
 */
public class ORD1007_Req extends AbstractBaseRequest<ORD1007_ReqBody> {
    @Override
    public Class<ORD1007_ReqBody> getReqObjectType() {
        return ORD1007_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
