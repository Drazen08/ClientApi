package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.base.USR1001_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserEntity;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.TaskSmsMapper;
import com.huiji.api.db.mapper.UserMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.USR1001_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1001_ReqBody;
import com.huiji.api.msg.response.USR1001_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1001_ResBody;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.StringUtil;
import com.huiji.api.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 孙旌翔 on 2016/7/16.用户登录
 */
@RestController
public class USR1001 extends AbstractBaseController<USR1001_Req, USR1001_ReqBody, USR1001_Res, USR1001_ResBody> {
    private String productid = "";
    @Autowired
    private USR1001_Service usr1001_service;

    @RequestMapping(URLPREFIX + "/USR1001/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        productid = httpServletRequest.getRequestURI().split("/")[2];
        return super.v(requestMsg, httpServletRequest);

    }


    @Override
    public boolean checkRequestBodyParam(USR1001_Req usr1001_req) {

        try {
            USR1001_ReqBody usr1001_reqBody = usr1001_req.getBodyObject();
            if (usr1001_reqBody.getPhone() == null || "".equals(usr1001_reqBody.getPhone())) {
                return false;
            } else if (usr1001_reqBody.getPassword() == null || "".equals(usr1001_reqBody.getPassword())) {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


    @Override
    public USR1001_Res getRes() {
        return new USR1001_Res();
    }


    @Override
    public void execute(IResponse response, IRequest<USR1001_ReqBody> request, String uid) throws Exception {
        try {
            usr1001_service.executeService(response, request, productid);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }
    }

    @Override
    public Class<USR1001_Req> getReqType() {
        return USR1001_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
