package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.USR1000_ReqBody;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yasenagat on 16/7/14 Time 上午10:13.
 */
public class USR1000_Req extends AbstractBaseRequest<USR1000_ReqBody> {

    @Override
    public Class<USR1000_ReqBody> getReqObjectType() {
        return USR1000_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.TWO.getValue();
    }
}
