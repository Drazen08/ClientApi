package com.huiji.api.biz.service.base;

import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1016_ReqBody;
import com.huiji.api.msg.response.base.IResponse;

/**
 * Created by Administrator on 2016/10/31.
 */
public interface ORD1016_Service  {
    public void executeService (IResponse response, IRequest<ORD1016_ReqBody> request, String uid) throws Exception;
}
