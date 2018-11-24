package com.huiji.api.biz.service.base;

import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.PAY1005_ReqBody;
import com.huiji.api.msg.response.base.IResponse;

/**
 * Created by Administrator on 2016/10/13.
 */
public interface PAY1005_Service {
    public void executeService(IResponse response, IRequest<PAY1005_ReqBody> request,String uid)throws Exception;
}
