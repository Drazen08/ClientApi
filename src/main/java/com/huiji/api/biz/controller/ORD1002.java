package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.base.ORD1002_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.OrderMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.ORD1002_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1002_ReqBody;
import com.huiji.api.msg.response.ORD1002_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1002_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jingxiang on 2016/8/10.用户订单-删除
 */
@RestController
public class ORD1002  extends AbstractBaseController<ORD1002_Req,ORD1002_ReqBody,ORD1002_Res,ORD1002_ResBody> {

    @Resource
    private ORD1002_Service ord1002_service;

   /* @Resource
    private UserSessionMapper userSessionMapper;*/
    @RequestMapping(URLPREFIX+"/ORD1002/*")


    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }



    @Override
    public boolean checkRequestBodyParam(ORD1002_Req ord1002_req) {
        return true;
    }

    @Override
    public ORD1002_Res getRes() {
        return new ORD1002_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1002_ReqBody> request, String uid) throws Exception {
        try{
            ord1002_service.executeService(response, request);
        }catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }


    }

    @Override
    public Class<ORD1002_Req> getReqType() {
        return ORD1002_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
