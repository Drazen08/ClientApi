package com.huiji.api.biz.service.base;

import com.huiji.api.db.entity.Order;
import com.huiji.api.msg.request.body.ORD1003_ReqBody;

/**
 * Created by Administrator on 2016/9/23.
 */
public interface ORD1003_Service {

     void executeService(long tuiPrice,Order order,ORD1003_ReqBody ord1003_reqBody)throws Exception;
}
