package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.ORD1007_ServiceImpl;
import com.huiji.api.biz.service.base.ORD1007_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.ORD1007_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1007_ReqBody;
import com.huiji.api.msg.response.ORD1007_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1007_ResBody;
import com.huiji.api.msg.response.body.ORD1009_ResBody;
import com.huiji.api.msg.response.body.USR1019_ResBody;
import com.huiji.api.util.ConvertAddressUtil;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.OrderCodeUtil;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by 孙文剑 on 2016/8/8 0008.
 */
@RestController
public class ORD1007 extends AbstractBaseController<ORD1007_Req, ORD1007_ReqBody, ORD1007_Res, ORD1007_ResBody> {
    @Value("${adminOrderExpiredTime}")
    private int adminOrderExpiredTime;
    @Value("${intentionalOrderExpiredTime}")
    private int intentionalOrderExpiredTime;
    @Resource
    private ORD1007_Service ord1007_Service;
//    @Resource
//    private UserSessionMapper userSessionMapper;


    @RequestMapping(URLPREFIX + "/ORD1007/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(ORD1007_Req ord1007_req) {
        return true;
    }

    @Override
    public ORD1007_Res getRes() {
        return new ORD1007_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1007_ReqBody> request, String uid) throws Exception {
        try {
//            UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
//            if (userSession == null) {
//                response.setResult(ResultCode.SESSION_TIMEOUT);
//                return;
//            }
            response.setBodyObject(ord1007_Service.executeService( response, request,uid, adminOrderExpiredTime,intentionalOrderExpiredTime));
            response.setResult(ResultCode.SUCCESS);
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
            throw e;
        }


    }

    @Override
    public Class<ORD1007_Req> getReqType() {
        return ORD1007_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }


}
