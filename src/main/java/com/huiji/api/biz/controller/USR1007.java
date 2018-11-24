package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.TaskSms;
import com.huiji.api.db.entity.UserEntity;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.TaskSmsMapper;
import com.huiji.api.db.mapper.UserMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1007_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1007_ReqBody;
import com.huiji.api.msg.response.USR1007_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1007_ResBody;
import com.huiji.api.exception.ParseException;
import com.huiji.api.util.StringUtil;
import com.huiji.api.util.UUIDUtil;
import com.huiji.api.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 王潇雨 on 2016/7/17
 */
@RestController
public class USR1007 extends AbstractBaseController<USR1007_Req, USR1007_ReqBody, USR1007_Res, USR1007_ResBody> {
    @RequestMapping(URLPREFIX + "/USR1007/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);


    }
    @Override
    public boolean checkRequestBodyParam(USR1007_Req usr1007_req) {
        try {
            USR1007_ReqBody usr1007_reqBody = usr1007_req.getBodyObject();
            String phone=usr1007_reqBody.getPhone();
            boolean flag = true;
            if (phone != null && !"".equals(phone)) {
                //验证手机号
                flag = ValidateUtil.ValidatePhone(phone);
            }
            else if ("".equals(phone) || phone == null || flag == false) {

                return  false;
            } else if (usr1007_reqBody.getActiveCode() == null || "".equals(usr1007_reqBody.getPhone())) {
                return false;
            } else if (usr1007_reqBody.getPayPassword() == null || "".equals(usr1007_reqBody.getActiveCode())) {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public USR1007_Res getRes() {
        return new USR1007_Res();
    }
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TaskSmsMapper taskSmsMapper;
   /* @Autowired
    private UserSessionMapper userSessionMapper;*/
    @Override
    public void execute(IResponse response, IRequest<USR1007_ReqBody> request, String uid) throws ParseException {
        System.out.println("123456");
        USR1007_ReqBody usr1007_reqBody = null;
        try {
            usr1007_reqBody = request.getBodyObject();
            /*UserSession userSession=userSessionMapper.searchUserSessionBySid(request.getSid());
            if(userSession==null){
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/

            GlobalLog.Biz.debug("uuid:"+uid);
            GlobalLog.Biz.debug("usr1000_reqBody.getActiveCode() : " + usr1007_reqBody.getActiveCode());
            USR1007_ResBody usr1007_resBody = new USR1007_ResBody();
            UserEntity userEntity=userMapper.queryByUid(uid);
            if(userEntity!=null) {
                if (!usr1007_reqBody.getPhone().equals(userEntity.getPhone())) {
                    usr1007_resBody.setResult("-4");
                    usr1007_resBody.setResultDesc("您输入的手机号与当前用户不符");
                    response.setBodyObject(usr1007_resBody);
                    response.setResult(ResultCode.SUCCESS);
                    return;
                }
            }
            //dbd
            int type=3;
            TaskSms taskSms=taskSmsMapper.queryByPhone(usr1007_reqBody.getPhone(), type);
            String ac= taskSms==null?"无获取。。。 * 。": String.valueOf(taskSms.getActiveCode());
//            GlobalLog.Biz.debug("phone() : " + phone);
            //create response body
                if (usr1007_reqBody.getActiveCode().equals(ac)) {
                    int result=userMapper.updatePaypwd(StringUtil.MD5EncodeToHex(usr1007_reqBody.getPayPassword()), uid);

                    if (result==1) {
                        usr1007_resBody.setResult("0");
                        usr1007_resBody.setResultDesc("修改成功");
                        response.setBodyObject(usr1007_resBody);
                        response.setResult(ResultCode.SUCCESS);
                    }else {
                        usr1007_resBody.setResult("-2");
                        usr1007_resBody.setResultDesc("修改失败");
                        response.setBodyObject(usr1007_resBody);
                        response.setResult(ResultCode.SUCCESS);
                    }
                } else {

                    usr1007_resBody.setResult("-3");
                    usr1007_resBody.setResultDesc("验证码错误");
                    response.setBodyObject(usr1007_resBody);
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
    public Class<USR1007_Req> getReqType() {
        return USR1007_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
