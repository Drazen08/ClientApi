package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.mapper.OrderTemplateMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.ORD1014_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1014_ReqBody;
import com.huiji.api.msg.response.ORD1014_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1014_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/10/27.
 */
@RestController
public class ORD1014 extends AbstractBaseController<ORD1014_Req,ORD1014_ReqBody,ORD1014_Res,ORD1014_ResBody> {
    @Resource
    private OrderTemplateMapper orderTemplateMapper;
    @RequestMapping(URLPREFIX + "/ORD1014/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(ORD1014_Req ord1014_req) {
        return true;
    }

    @Override
    public ORD1014_Res getRes() {
        return new ORD1014_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1014_ReqBody> request, String uid) throws Exception {
        try {
            int i=orderTemplateMapper.delTid(request.getBodyObject().getTemporaryId());
            ORD1014_ResBody ord1014_resBody=new ORD1014_ResBody();
            if(i==1) {
                ord1014_resBody.setResult("0");
                ord1014_resBody.setResultDesc("删除成功");
            }else {
                ord1014_resBody.setResult("-1");
                ord1014_resBody.setResultDesc("删除失败");
            }
            response.setBodyObject(ord1014_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<ORD1014_Req> getReqType() {
        return ORD1014_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
