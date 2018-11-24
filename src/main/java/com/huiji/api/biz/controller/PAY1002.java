package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.base.PAY1002_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.PAY1002_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.PAY1002_ReqBody;
import com.huiji.api.msg.response.PAY1002_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.PAY1001_ResBody;
import com.huiji.api.msg.response.body.PAY1002_ResBody;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.GetIpUtil;
import com.huiji.api.util.OrderCodeUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
@RestController
public class PAY1002 extends AbstractBaseController<PAY1002_Req,PAY1002_ReqBody,PAY1002_Res,PAY1002_ResBody> {
//    @Resource
//    private UserSessionMapper userSessionMapper;
    @Resource
    private PAY1002_Service pay1002_service;
    private String clientIPAddr="";

    @RequestMapping(URLPREFIX + "/PAY1002/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest){
//        clientIPAddr= GetIpUtil.getIpAddr1(httpServletRequest);
        clientIPAddr= GetIpUtil.getIpAddr2(httpServletRequest);
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(PAY1002_Req pay1002_req) {
        return true;
    }

    @Override
    public PAY1002_Res getRes() {
        return new PAY1002_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<PAY1002_ReqBody> request, String uid) throws Exception {
        try {
//            UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
//            if (userSession == null) {
//                response.setResult(ResultCode.SESSION_TIMEOUT);
//                return;
//            }
            pay1002_service.executeService( response,request, uid,clientIPAddr);

        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
            throw e;
        }
    }


    @Override
    public Class<PAY1002_Req> getReqType() {
        return PAY1002_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
