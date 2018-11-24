package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.CancelReasonsMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.msg.request.ORD1012_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1012_ReqBody;
import com.huiji.api.msg.response.ORD1012_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1012_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
@RestController
public class ORD1012 extends AbstractBaseController<ORD1012_Req,ORD1012_ReqBody,ORD1012_Res,ORD1012_ResBody> {
    /*@Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private CancelReasonsMapper cancelReasonsMapper;
    @RequestMapping(URLPREFIX + "/ORD1012/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(ORD1012_Req ord1012_req) {
        return true;
    }

    @Override
    public ORD1012_Res getRes() {
        return new ORD1012_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1012_ReqBody> request, String uid) throws Exception {
        try {
            /*UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            ORD1012_ResBody ord1012_resBody= new ORD1012_ResBody();
            ord1012_resBody.setItem(cancelReasonsMapper.getCancelReasons());
            response.setBodyObject(ord1012_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
            throw e;
        }
    }

    @Override
    public Class<ORD1012_Req> getReqType() {
        return ORD1012_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
