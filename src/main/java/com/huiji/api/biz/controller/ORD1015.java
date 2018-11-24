package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.mapper.LogisticsDetailMapper;
import com.huiji.api.msg.request.ORD1015_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1015_ReqBody;
import com.huiji.api.msg.response.ORD1015_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1015_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/10/31.
 */
@RestController
public class ORD1015 extends AbstractBaseController<ORD1015_Req, ORD1015_ReqBody, ORD1015_Res, ORD1015_ResBody> {
    @Resource
    private LogisticsDetailMapper logisticsDetailMapper;
    @RequestMapping(URLPREFIX + "/ORD1015/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(ORD1015_Req ord1015_req) {
        return true;
    }

    @Override
    public ORD1015_Res getRes() {
        return new ORD1015_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1015_ReqBody> request, String uid) throws Exception {
        try {
            ORD1015_ResBody ord1015_resBody=new ORD1015_ResBody();
            ord1015_resBody.setLogisticsDetails(logisticsDetailMapper.getLogistics());
            response.setBodyObject(ord1015_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<ORD1015_Req> getReqType() {
        return ORD1015_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
