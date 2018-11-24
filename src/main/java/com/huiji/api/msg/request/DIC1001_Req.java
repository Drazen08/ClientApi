package com.huiji.api.msg.request;

import com.huiji.api.common.Mode;
import com.huiji.api.msg.request.base.AbstractBaseRequest;
import com.huiji.api.msg.request.body.DIC1001_ReqBody;

/**
 * Created by 王潇雨 on 2016/7/19.
 */
public class DIC1001_Req extends AbstractBaseRequest<DIC1001_ReqBody> {
    @Override
    public Class<DIC1001_ReqBody> getReqObjectType() {
        return DIC1001_ReqBody.class;
    }

    @Override
    public String getAllowMode() {
        return Mode.ONE.getValue();
    }
}
