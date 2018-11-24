package com.huiji.api.biz.service.base;

import com.huiji.api.db.entity.UserSession;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.SHO1004_ReqBody;
import com.huiji.api.msg.response.base.IResponse;

/**
 * Created by Administrator on 2016/9/26.
 */
public interface SHO1004_Service  {

    public void executeService(IResponse response, IRequest<SHO1004_ReqBody> request,String uid) throws Exception;
}
