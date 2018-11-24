package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.base.USR1000_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.TaskSms;
import com.huiji.api.db.entity.UserEntity;
import com.huiji.api.db.mapper.TaskSmsMapper;
import com.huiji.api.db.mapper.UserAccountMapper;
import com.huiji.api.db.mapper.UserMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1000_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1000_ReqBody;
import com.huiji.api.msg.response.USR1000_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1000_ResBody;
import com.huiji.api.util.ActiveCodeUtil;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.StringUtil;
import com.huiji.api.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by yasenagat on 16/7/13 Time 下午10:19.
 */
@RestController
public class USR1000 extends AbstractBaseController<USR1000_Req, USR1000_ReqBody, USR1000_Res, USR1000_ResBody> {
    private String productid="";
    @Resource
    private USR1000_Service usr1000_service;

    @RequestMapping(URLPREFIX + "/USR1000/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        productid=httpServletRequest.getRequestURI().split("/")[2];
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(USR1000_Req usr1000_req) {
        try {
            USR1000_ReqBody usr1000_reqBody = usr1000_req.getBodyObject();
            if (usr1000_reqBody.getActiveCode() == null || "".equals(usr1000_reqBody.getActiveCode())) {
                return false;
            } else if (usr1000_reqBody.getPhone() == null || "".equals(usr1000_reqBody.getPhone())) {
                return false;
            } else if (usr1000_reqBody.getPassword() == null || "".equals(usr1000_reqBody.getPassword())) {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public USR1000_Res getRes() {
        return new USR1000_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<USR1000_ReqBody> request, String uid) throws Exception {

        try {
            usr1000_service.executeService( response, request,productid);
        }  catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
            throw e;
        }

    }

    @Override
    public Class<USR1000_Req> getReqType() {
        return USR1000_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }


}
