package com.huiji.api.biz.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.entity.UserToken;
import com.huiji.api.db.mapper.UserMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.db.mapper.UserTokenMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1005_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1005_ReqBody;
import com.huiji.api.msg.response.USR1005_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1005_ResBody;
import com.huiji.api.util.StringUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孙文剑 on 2016/7/17 0017.
 */
@RestController
public class USR1005 extends AbstractBaseController<USR1005_Req,USR1005_ReqBody,USR1005_Res,USR1005_ResBody> {
  /*  @Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserTokenMapper userTokenMapper;
    @RequestMapping(URLPREFIX + "/USR1005/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
//        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(USR1005_Req usr1005_req) {
        try {
            String token=usr1005_req.getBodyObject().getToken();
            String pw=usr1005_req.getBodyObject().getPassword();
            if((token==null||"".equals(token)||(pw==null||"".equals(pw)))){
                return false;
            }
             /*DB Statement :select u.token from tb_user_session s join tb_user_token u on s.uid=u.uid where s.sid='1234';
            GlobalLog.Biz.debug("sid : " + usr1005_req.getSid());

            String tokenDB=userSessionMapper.searchTokenBySid(usr1005_req.getSid());
            GlobalLog.Biz.debug("tokenDB : " + tokenDB);
            if(!tokenDB.equals(token))
                return false;
            */
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public USR1005_Res getRes() {
        return new USR1005_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<USR1005_ReqBody> request, String uid) throws Exception {
        try {
            USR1005_ResBody usr1005_resBody=new USR1005_ResBody();
            String token=request.getBodyObject().getToken();
            UserToken userToken=userTokenMapper.SearchSameToken(token);
            if(userToken==null){
                usr1005_resBody.setResult("-1");
                usr1005_resBody.setResultDesc("请求已超时，请重新获取验证码");
                response.setBodyObject(usr1005_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }

            int result=userMapper.updateUserPw(StringUtil.MD5EncodeToHex(request.getBodyObject().getPassword()), userToken.getUid());
            userTokenMapper.updateTokenType(token);
            if(result==1){
                usr1005_resBody.setResult("0");
                usr1005_resBody.setResultDesc("设置登陆密码成功");
                response.setBodyObject(usr1005_resBody);
                response.setResult(ResultCode.SUCCESS);
            }else{
                response.setResult(ResultCode.SERVER_ERROR);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<USR1005_Req> getReqType() {
        return USR1005_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
