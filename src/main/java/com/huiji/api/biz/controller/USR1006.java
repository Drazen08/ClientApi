package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserEntity;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.UserMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1006_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1006_ReqBody;
import com.huiji.api.msg.response.USR1006_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1005_ResBody;
import com.huiji.api.msg.response.body.USR1006_ResBody;
import com.huiji.api.util.StringUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
@RestController
public class USR1006 extends AbstractBaseController<USR1006_Req,USR1006_ReqBody,USR1006_Res,USR1006_ResBody> {
    @Resource
    private UserSessionMapper userSessionMapper;
    @Resource
    private UserMapper userMapper;
    @RequestMapping(URLPREFIX + "/USR1006/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }



    @Override
    public boolean checkRequestBodyParam(USR1006_Req usr1006_req) {

        try {
            USR1006_ReqBody usr1006_reqBody=usr1006_req.getBodyObject();
            //1:获取旧密码 和 新密码  分别判断 是否为空 如果有一样为空
            String oldPassword=usr1006_reqBody.getOldPassword();
            String newPassword=usr1006_reqBody.getNewPassword();
            if((oldPassword==null||"".equals(oldPassword))||(newPassword==null||"".equals(newPassword))){
                return false;
            }
            //2:获取UID  根据UID 得到相应的 mima
            //2.1:  select pwd from tb_user where uid =#{uid}
            //2.2:  String searchOldPasswordByUID(@Param String uid)
            //String oldPasswordDB=searchOldPasswordByUID(uid);
            //3:如果 从数据库中得到的密码与原密码不相等
            //if(!oldPasswordDB.equals(oldPassword))
//                return  false;
        } catch (ParseException e) {
            e.printStackTrace();
            return  false;
        }
        return true;
    }

    @Override
    public USR1006_Res getRes() {
        return new USR1006_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<USR1006_ReqBody> request, String uid) throws Exception {
        //update tb_user set pwd=#{newPwd} where uid = #{uid}
        // int updatePw (@Param String newPwd,@Param String uid)
        try {
            USR1006_ResBody usr1006_resBody=new USR1006_ResBody();
            String oldPassword=request.getBodyObject().getOldPassword();
            UserEntity user=userSessionMapper.searchUserBySid(request.getSid());
            if(user==null){
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }
            if(!StringUtil.MD5EncodeToHex(oldPassword).equals(user.getPwd())){
                usr1006_resBody.setResult("-1");
                usr1006_resBody.setResultDesc("请输入正确的原密码");
                response.setBodyObject(usr1006_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }
            GlobalLog.Biz.debug(request.getSid());
            UserSession userSession= userSessionMapper.searchUserSessionBySid(request.getSid());
            if(userSession==null){
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }
            int result=userMapper.updateUserPw(StringUtil.MD5EncodeToHex(request.getBodyObject().getNewPassword()), userSession.getUid());
            if(result==1){
                usr1006_resBody.setResult("0");
                usr1006_resBody.setResultDesc("完成密码修改");
                response.setBodyObject(usr1006_resBody);
                response.setResult(ResultCode.SUCCESS);

            }else{
                usr1006_resBody.setResult("0");
                usr1006_resBody.setResultDesc("密码修改失败");
                response.setBodyObject(usr1006_resBody);
                response.setResult(ResultCode.SERVER_ERROR);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<USR1006_Req> getReqType() {
        return USR1006_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
