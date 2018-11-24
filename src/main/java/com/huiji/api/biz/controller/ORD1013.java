package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.Order;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.OrderMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.msg.request.ORD1013_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1013_ReqBody;
import com.huiji.api.msg.response.ORD1013_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1013_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/9/26.
 */
@RestController
public class ORD1013 extends AbstractBaseController<ORD1013_Req,ORD1013_ReqBody,ORD1013_Res,ORD1013_ResBody> {
   /* @Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private OrderMapper orderMapper;

    @RequestMapping(URLPREFIX + "/ORD1013/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(ORD1013_Req ord1013_req) {
        return true;
    }

    @Override
    public ORD1013_Res getRes() {
        return new ORD1013_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1013_ReqBody> request, String uid) throws Exception {
        try {
            /*UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            String orderId= request.getBodyObject().getOrderId();
            //修改订单的发货状态为5  （提醒发货状态）
            orderMapper.updateSendType(orderId);
            ORD1013_ResBody ord1013_resBody=new ORD1013_ResBody();
            ord1013_resBody.setResult("0");
            ord1013_resBody.setResultDesc("订单提醒发货完毕");
            response.setBodyObject(ord1013_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
            throw e;
        }

    }

    @Override
    public Class<ORD1013_Req> getReqType() {
        return ORD1013_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
