package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.TaskSms;
import com.huiji.api.db.entity.UserEntity;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.TaskSmsMapper;
import com.huiji.api.db.mapper.UserMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1010_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1000_ReqBody;
import com.huiji.api.msg.request.body.USR1010_ReqBody;
import com.huiji.api.msg.response.USR1010_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1000_ResBody;
import com.huiji.api.msg.response.body.USR1010_ResBody;
import com.huiji.api.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 王潇雨 on 2016/7/18.
 */
@RestController
public class USR1010 extends AbstractBaseController<USR1010_Req,USR1010_ReqBody,USR1010_Res,USR1010_ResBody>{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TaskSmsMapper taskSmsMapper;
/*    @Autowired
    private UserSessionMapper userSessionMapper;*/
    @RequestMapping(URLPREFIX + "/USR1010/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(USR1010_Req usr1010_req) {
//        usr1010_req.getSid()
        try {
            if("".equals(usr1010_req.getBodyObject().getPhone())||usr1010_req.getBodyObject().getPhone()==null){
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public USR1010_Res getRes() {
        return new USR1010_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<USR1010_ReqBody> request, String uid) throws Exception {
        USR1010_ReqBody usr1010_reqBody = null;
        int type=4;
        try {
            USR1010_ResBody usr1010_resBody = new USR1010_ResBody();
            String sid=request.getSid();
            usr1010_reqBody = request.getBodyObject();
            /*UserSession userSession=userSessionMapper.searchUserSessionBySid(sid);
            if(userSession==null){
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
           if( userMapper.queryByPhone(usr1010_reqBody.getPhone())!=null){
               usr1010_resBody.setResult("-4");
               usr1010_resBody.setResultDesc("要更改的手机号已存在，请重新设置新的手机号");
               response.setBodyObject(usr1010_resBody);
               response.setResult(ResultCode.SUCCESS);
               return;
           }

            GlobalLog.Biz.debug("usr1010_reqBody.getActiveCode() : " + usr1010_reqBody.getActiveCode());
            //db
            TaskSms taskSms=taskSmsMapper.queryByPhone(usr1010_reqBody.getPhone(), type);
//            GlobalLog.Biz.debug("ActiveCode() : " + phone);
            //create response body
            String ac= taskSms==null?"无获取。。。 * 。": String.valueOf(taskSms.getActiveCode());
            if (usr1010_reqBody.getActiveCode().equals(ac)) {
                int result = userMapper.updatePhone(usr1010_reqBody.getPhone(),usr1010_reqBody.getPhone(),uid);
                if (result == 1) {
                    usr1010_resBody.setResult("0");
                    usr1010_resBody.setResultDesc("修改成功");
                    response.setBodyObject(usr1010_resBody);
                    response.setResult(ResultCode.SUCCESS);
                } else {
                    usr1010_resBody.setResult("-2");
                    usr1010_resBody.setResultDesc("修改失败");
                    response.setBodyObject(usr1010_resBody);
                    response.setResult(ResultCode.SUCCESS);
                }

            } else {
                usr1010_resBody.setResult("-3");
                usr1010_resBody.setResultDesc("验证码错误");
                response.setBodyObject(usr1010_resBody);
                response.setResult(ResultCode.SUCCESS);
            }

        } catch (ParseException e) {
//            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        } catch (Exception e) {
            response.setResult(ResultCode.SERVER_ERROR);
            throw e;
        }
    }

    @Override
    public Class<USR1010_Req> getReqType() {
        return USR1010_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
