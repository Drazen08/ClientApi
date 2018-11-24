package com.huiji.api.biz.service.base;

import com.huiji.api.db.entity.UserSession;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1007_ReqBody;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1007_ResBody;

/**
 * Created by Administrator on 2016/9/23.
 */
public interface ORD1007_Service  {

    public ORD1007_ResBody executeService(IResponse response,IRequest<ORD1007_ReqBody> request,String userSession,int adminOrderExpiredTime,int intentionalOrderExpiredTime) throws Exception;
}
