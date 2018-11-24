package com.huiji.api.biz.service.base;

import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1002_ReqBody;
import com.huiji.api.msg.response.base.IResponse;

/**
 * Created by Administrator on 2016/10/27.
 */
public interface ORD1002_Service  {
    public void executeService(IResponse response, IRequest<ORD1002_ReqBody> request) throws Exception;
}
