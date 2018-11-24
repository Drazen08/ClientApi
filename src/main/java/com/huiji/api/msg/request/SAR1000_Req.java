package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.SAR1000_ReqBody;

/**
 * Created by Jingxiang on 2016/8/4.
 */
public class SAR1000_Req extends AbstractBaseRequest<SAR1000_ReqBody> {

    @Override
    public Class<SAR1000_ReqBody> getReqObjectType() {
        return SAR1000_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
