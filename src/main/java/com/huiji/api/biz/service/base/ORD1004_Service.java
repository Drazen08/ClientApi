package com.huiji.api.biz.service.base;

import com.huiji.api.db.entity.UserSession;
import com.huiji.api.msg.request.body.ORD1004_ReqBody;
import com.huiji.api.msg.response.body.ORD1004_ResBody;

/**
 * Created by Administrator on 2016/9/23.
 */
public interface ORD1004_Service  {

    public void executeService(String uid,ORD1004_ReqBody ord1004_reqBody) throws Exception;
}
