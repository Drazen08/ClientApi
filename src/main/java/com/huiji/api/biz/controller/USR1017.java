package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.UserAddressMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.USR1017_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1017_ReqBody;
import com.huiji.api.msg.response.USR1017_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1017_ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孙文剑 on 2016/7/23 0023.
 */
@RestController
public class USR1017 extends AbstractBaseController<USR1017_Req, USR1017_ReqBody, USR1017_Res, USR1017_ResBody> {
    @Resource
    private UserAddressMapper useraddressMapper;
   /* @Resource
    private UserSessionMapper userSessionMapper;*/

    @RequestMapping(value = URLPREFIX + "/USR1017/*", method = RequestMethod.POST)
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(USR1017_Req usr1017_req) {
        return true;
    }

    @Override
    public USR1017_Res getRes() {
        return new USR1017_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<USR1017_ReqBody> request, String uid) throws Exception {
        try {
            /*UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            useraddressMapper.updateTopToZero(uid);

//            (Boolean)request.getBodyObject().getTopFlag();
            System.out.println("地址的id号："+request.getBodyObject().getId());

            int result = useraddressMapper.updateAdminTopById(uid, request.getBodyObject().getId());
            USR1017_ResBody usr1017_resBody = new USR1017_ResBody();
            if(result>0) {
                usr1017_resBody.setResult("0");
                usr1017_resBody.setResultDesc("已设置为默认地址");
            }else {
                usr1017_resBody.setResult("-1");
                usr1017_resBody.setResultDesc("请查看改地址已存在");
            }
            response.setBodyObject(usr1017_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }

    }

    @Override
    public Class<USR1017_Req> getReqType() {
        return USR1017_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
