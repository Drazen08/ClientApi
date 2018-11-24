package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1013_ReqBody;

/**
 * Created by 孙旌翔 on 2016/7/17.
 */
public class USR1013_Req extends AbstractBaseRequest<USR1013_ReqBody> {
    @Override
    public Class<USR1013_ReqBody> getReqObjectType() {
        return USR1013_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
