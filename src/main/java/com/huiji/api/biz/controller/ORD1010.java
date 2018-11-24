package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.RejectedReasonsMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.msg.request.ORD1010_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1010_ReqBody;
import com.huiji.api.msg.response.ORD1010_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1010_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
@RestController
public class ORD1010 extends AbstractBaseController<ORD1010_Req,ORD1010_ReqBody,ORD1010_Res,ORD1010_ResBody> {
    /*@Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private RejectedReasonsMapper rejectedReasonsMapper;
    @RequestMapping(URLPREFIX + "/ORD1010/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(ORD1010_Req ord1010_req) {
        return true;
    }

    @Override
    public ORD1010_Res getRes() {
        return new ORD1010_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1010_ReqBody> request, String uid) throws Exception {
        try {
            /*UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            ORD1010_ResBody ord1010_resBody=new ORD1010_ResBody();
            ord1010_resBody.setItem(rejectedReasonsMapper.getRejectedReasons());
            ord1010_resBody.setResult("0");
            ord1010_resBody.setResultDesc("抽取成功");
            response.setBodyObject(ord1010_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<ORD1010_Req> getReqType() {
        return ORD1010_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
