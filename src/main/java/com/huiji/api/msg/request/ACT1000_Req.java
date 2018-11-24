package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.ACT1000_ReqBody;

/**
 * Created by Jingxiang on 2016/8/5.
 */
public class ACT1000_Req extends AbstractBaseRequest<ACT1000_ReqBody> {
    @Override
    public Class<ACT1000_ReqBody> getReqObjectType() {
        return ACT1000_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
