package com.huiji.api.biz.service.base;


import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1008_ReqBody;
import com.huiji.api.msg.response.body.ORD1008_ResBody;

/**
 * Created by Administrator on 2016/9/23.
 */
public interface ORD1008_Service  {
    public ORD1008_ResBody executeService(IRequest<ORD1008_ReqBody> request) throws Exception;

}
