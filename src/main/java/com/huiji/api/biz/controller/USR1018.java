package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.UserMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.USR1018_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1018_ReqBody;
import com.huiji.api.msg.response.USR1018_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1018_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孙文剑 on 2016/7/27 0027.
 */
@RestController
public class USR1018 extends AbstractBaseController<USR1018_Req,USR1018_ReqBody,USR1018_Res,USR1018_ResBody> {
    /*@Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private UserMapper userMapper;
    @RequestMapping(value = URLPREFIX + "/USR1018/*", method = RequestMethod.POST)
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(USR1018_Req usr1018_req) {
        try {
            if(usr1018_req.getBodyObject().getNickName()==null){
                return  false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return  false;
        }
        return true;
    }

    @Override
    public USR1018_Res getRes() {
        return new USR1018_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<USR1018_ReqBody> request, String uid) throws Exception {
        try {
           /* UserSession userSession =userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            USR1018_ResBody usr1018_reqBody=new USR1018_ResBody();
            String nickName=request.getBodyObject().getNickName();
            if("".equals(nickName)){
                usr1018_reqBody.setResult("-2");
                usr1018_reqBody.setResultDesc("您输入的昵称为空");
                response.setResult(ResultCode.SUCCESS);
                response.setBodyObject(usr1018_reqBody);
                return;
            }
            int result=userMapper.updateNickName(nickName,uid);
            if(result==0){
                usr1018_reqBody.setResult("-1");
                usr1018_reqBody.setResultDesc("本次操作失效");
            }else {
                usr1018_reqBody.setResult("0");
                usr1018_reqBody.setResultDesc("本次操作成功");
            }
            response.setResult(ResultCode.SUCCESS);
            response.setBodyObject(usr1018_reqBody);
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }

    }

    @Override
    public Class<USR1018_Req> getReqType() {
        return USR1018_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
