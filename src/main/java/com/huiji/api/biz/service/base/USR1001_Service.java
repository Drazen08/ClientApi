package com.huiji.api.biz.service.base;

import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1001_ReqBody;
import com.huiji.api.msg.response.base.IResponse;

/**
 * Created by Administrator on 2016/9/23.
 */
public interface USR1001_Service  {
    public void executeService(IResponse response, IRequest<USR1001_ReqBody> request,String productid)throws Exception;
}
