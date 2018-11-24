package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.base.ORD1008_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.OrderTemplate;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.OrderTemplateMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.ORD1008_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1008_ReqBody;
import com.huiji.api.msg.response.ORD1008_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1008_ResBody;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.UUIDUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
@RestController
public class ORD1008 extends AbstractBaseController<ORD1008_Req,ORD1008_ReqBody,ORD1008_Res,ORD1008_ResBody> {
/*
    @Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private ORD1008_Service ord1008_service;

    @RequestMapping(URLPREFIX + "/ORD1008/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(ORD1008_Req ord1008_req) {
        return true;
    }

    @Override
    public ORD1008_Res getRes() {
        return new ORD1008_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1008_ReqBody> request, String uid) throws Exception {
        try {
           /* UserSession userSession=userSessionMapper.searchUserSessionBySid(request.getSid());
            if(userSession==null){
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
        /*
        (String template_id, Integer shop_id, Integer good_id, Integer sub_good_id, Integer buy_num, Long current_price, Integer pid, Long yu_price, Integer state, String create_time)
         */

            response.setBodyObject(ord1008_service.executeService(request));
            response.setResult(ResultCode.SUCCESS);
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
            throw e;
        }

    }

    @Override
    public Class<ORD1008_Req> getReqType() {
        return ORD1008_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
