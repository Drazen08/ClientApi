package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1001_ReqBody;

/**
 * Created by 孙旌翔 on 2016/7/16.
 */
public class USR1001_Req extends AbstractBaseRequest<USR1001_ReqBody> {
    @Override
    public Class<USR1001_ReqBody> getReqObjectType() {
        return USR1001_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
