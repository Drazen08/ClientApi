package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.base.ORD1016_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.ORD1016_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1016_ReqBody;
import com.huiji.api.msg.response.ORD1016_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1016_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/10/31.
 */
@RestController
public class ORD1016 extends AbstractBaseController<ORD1016_Req,ORD1016_ReqBody,ORD1016_Res,ORD1016_ResBody> {
    @Resource
    private ORD1016_Service ord1016_service;
    @RequestMapping(URLPREFIX + "/ORD1016/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(ORD1016_Req ord1016_req) {
        try {
            String logisticsName=ord1016_req.getBodyObject().getLogisticsName();
            String logisticsNumber=ord1016_req.getBodyObject().getLogisticsNumber();
            if(logisticsName==null||"".equals(logisticsName)||logisticsNumber==null||"".equals(logisticsNumber)){
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ORD1016_Res getRes() {
        return new ORD1016_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1016_ReqBody> request, String uid) throws Exception {
        try {
            ord1016_service.executeService(response,  request, uid);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<ORD1016_Req> getReqType() {
        return ORD1016_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
