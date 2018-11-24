package com.huiji.api.biz.service.base;

import com.huiji.api.db.entity.UserSession;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.PAY1001_ReqBody;
import com.huiji.api.msg.response.base.IResponse;

/**
 * Created by Administrator on 2016/9/23.
 */
public interface PAY1001_Service {
    public void executeService(IResponse response, IRequest<PAY1001_ReqBody> request,String uid)throws Exception;
}
