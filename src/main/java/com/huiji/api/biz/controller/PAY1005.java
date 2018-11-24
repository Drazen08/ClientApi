package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.base.PAY1005_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.msg.request.PAY1005_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.PAY1005_ReqBody;
import com.huiji.api.msg.response.PAY1005_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.PAY1005_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
@RestController
public class PAY1005 extends AbstractBaseController<PAY1005_Req,PAY1005_ReqBody,PAY1005_Res,PAY1005_ResBody> {
    @Resource
    private PAY1005_Service pay1005_service;
    @RequestMapping(URLPREFIX + "/PAY1005/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(PAY1005_Req pay1005_req) {
        return true;
    }

    @Override
    public PAY1005_Res getRes() {
        return new PAY1005_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<PAY1005_ReqBody> request, String uid) throws Exception {
        try {
            pay1005_service.executeService(response, request,uid);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }

    }

    @Override
    public Class<PAY1005_Req> getReqType() {
        return PAY1005_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
