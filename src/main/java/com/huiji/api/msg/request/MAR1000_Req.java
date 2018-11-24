package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.MAR1000_ReqBody;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class MAR1000_Req extends AbstractBaseRequest<MAR1000_ReqBody> {
    @Override
    public Class<MAR1000_ReqBody> getReqObjectType() {
        return MAR1000_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
