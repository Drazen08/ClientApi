package com.huiji.api.biz.service.base;

import com.huiji.api.db.entity.UserSession;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.PAY1002_ReqBody;
import com.huiji.api.msg.response.base.IResponse;

/**
 * Created by Administrator on 2016/9/24.
 */
public interface PAY1002_Service {
    public void executeService(IResponse response, IRequest<PAY1002_ReqBody> request,String uid,String clientIPAddr)throws Exception;
}
