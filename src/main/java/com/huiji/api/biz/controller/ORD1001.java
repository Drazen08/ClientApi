package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.base.ORD1001_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.ORD1001_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1001_ReqBody;
import com.huiji.api.msg.response.ORD1001_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1001_ResBody;
import com.huiji.api.util.StringUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孙文剑 on 2016/8/13 0013.
 */
@RestController
public class ORD1001  extends AbstractBaseController<ORD1001_Req,ORD1001_ReqBody,ORD1001_Res,ORD1001_ResBody> {
    @Resource
    private UserSessionMapper userSessionMapper;
    @Resource
    private ORD1001_Service g001001_service;

    @RequestMapping(URLPREFIX + "/ORD1001/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(ORD1001_Req ord1001_req) {
        try {
            if(ord1001_req.getBodyObject().getPayPassword()==null){
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ORD1001_Res getRes() {
        return new ORD1001_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1001_ReqBody> request, String uid) throws Exception {
        try {
           UserEntity user = userSessionMapper.searchUserBySid(request.getSid());
            /*
            if (user == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            ORD1001_ResBody ord1001_resBody=new ORD1001_ResBody();
            String orderId=request.getBodyObject().getOrderId();
            String payPassword=request.getBodyObject().getPayPassword();
            if("".equals(payPassword)){
                ord1001_resBody.setResult("-2");
                ord1001_resBody.setResultDesc("您输入的支付宝密码不能为空");
                response.setBodyObject(ord1001_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }
            if(!StringUtil.MD5EncodeToHex(payPassword).equals(user.getPaypwd())){
                ord1001_resBody.setResult("-1");
                ord1001_resBody.setResultDesc("您输入的支付宝密码不正确");
                response.setBodyObject(ord1001_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }

            g001001_service.executeService(orderId);
            ord1001_resBody.setResult("0");
            ord1001_resBody.setResultDesc("用户确认收货成功");

            response.setBodyObject(ord1001_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
            throw e;
        }
    }

    @Override
    public Class<ORD1001_Req> getReqType() {
        return ORD1001_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
