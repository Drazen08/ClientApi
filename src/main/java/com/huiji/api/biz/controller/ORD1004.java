package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.base.ORD1004_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.ORD1004_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1004_ReqBody;
import com.huiji.api.msg.response.ORD1004_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1004_ResBody;
import com.huiji.api.util.DateUtil;
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
 * Created by Jingxiang on 2016/8/11. 取消订单
 */
@RestController
public class ORD1004 extends AbstractBaseController<ORD1004_Req,ORD1004_ReqBody,ORD1004_Res,ORD1004_ResBody> {
   /* @Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private ORD1004_Service ord1004_service;
    @RequestMapping(URLPREFIX+"/ORD1004/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest){
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(ORD1004_Req ord1004_req) {
        return true;
    }

    @Override
    public ORD1004_Res getRes() {
        return new ORD1004_Res();
    }

    //用户订单是在用户未付款时取消订单，即订单主状态跳转至关闭状态
    @Override
    public void execute(IResponse response, IRequest<ORD1004_ReqBody> request, String uid) throws Exception {
        try{
            ORD1004_ReqBody ord1004_reqBody=null;
            ord1004_reqBody=request.getBodyObject();
            ORD1004_ResBody ord1004_resBody=new ORD1004_ResBody();
           /* UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            ord1004_service.executeService(uid,ord1004_reqBody);
            ord1004_resBody.setResult("0");
            ord1004_resBody.setResultDesc("操作成功");
            response.setBodyObject(ord1004_resBody);
            response.setResult(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }

    }

    @Override
    public Class<ORD1004_Req> getReqType() {
        return ORD1004_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
