package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.base.SHO1004_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserFollowShop;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.ShopMapper;
import com.huiji.api.db.mapper.UserFollowShopMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.msg.request.SHO1004_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.SHO1004_ReqBody;
import com.huiji.api.msg.response.SHO1004_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.SHO1004_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jingxiang on 2016/8/10.
 */
@RestController
public class SHO1004 extends AbstractBaseController<SHO1004_Req,SHO1004_ReqBody,SHO1004_Res,SHO1004_ResBody> {
   /* @Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private SHO1004_Service sho1004_service;

    @RequestMapping(URLPREFIX+"/SHO1004/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(SHO1004_Req sho1004_req) {
        return true;
    }

    @Override
    public SHO1004_Res getRes() {
        return new SHO1004_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<SHO1004_ReqBody> request, String uid) throws Exception {

        try {
          /*  UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            sho1004_service.executeService(response,  request, uid);
            }catch (Exception e){
                e.printStackTrace();
                response.setResult(ResultCode.PARSE_ERROR);
                throw e;
        }
    }

    @Override
    public Class<SHO1004_Req> getReqType() {
        return SHO1004_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
