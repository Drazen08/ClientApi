package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.base.PAY1001_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.PAY1001_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.PAY1001_ReqBody;
import com.huiji.api.msg.response.PAY1001_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.PAY1001_ResBody;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.OrderCodeUtil;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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

public class PAY1001 extends AbstractBaseController<PAY1001_Req, PAY1001_ReqBody, PAY1001_Res, PAY1001_ResBody> {
   /* @Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private PAY1001_Service pay1001_service;

    @RequestMapping(URLPREFIX + "/PAY1001/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(PAY1001_Req pay1001_req) {
        return true;
    }

    @Override
    public PAY1001_Res getRes() {
        return new PAY1001_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<PAY1001_ReqBody> request, String uid) throws Exception {

        try {
            /*UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            pay1001_service.executeService(response, request, uid);

        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
            throw e;
        }


    }



    @Override
    public Class<PAY1001_Req> getReqType() {
        return PAY1001_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
