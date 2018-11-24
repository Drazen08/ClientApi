package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.TaskSmsMapper;
import com.huiji.api.db.mapper.UserMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1011_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1011_ReqBody;
import com.huiji.api.msg.response.USR1011_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1011_ResBody;
import com.huiji.api.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 王潇雨 on 2016/7/18.
 */
@RestController
public class USR1011 extends AbstractBaseController<USR1011_Req,USR1011_ReqBody,USR1011_Res,USR1011_ResBody>{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TaskSmsMapper taskSmsMapper;
    /*@Autowired
    private UserSessionMapper userSessionMapper;*/
    @RequestMapping(URLPREFIX + "/USR1011/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(USR1011_Req usr1011_req) {
//        try {
//            String pw=usr1011_req.getBodyObject().getPayPassword();
//            if(pw!=null||!"".equals(pw)){
//                return false;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }

        return true;
    }

    @Override
    public USR1011_Res getRes() {
        return new USR1011_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<USR1011_ReqBody> request, String uid) throws Exception {
        USR1011_ReqBody usr1011_reqBody = null;
        try {
            String sid=request.getSid();
            usr1011_reqBody = request.getBodyObject();
           /* UserSession userSession=userSessionMapper.searchUserSessionBySid(sid);
            if(userSession==null){
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/


            GlobalLog.Biz.debug("usr1011_reqBody.getPayPassword() : " + usr1011_reqBody.getPayPassword());
            //db
            //create response body
                int result = userMapper.updatePaypwd(uid, StringUtil.MD5EncodeToHex(usr1011_reqBody.getPayPassword()));
                USR1011_ResBody usr1011_resBody = new USR1011_ResBody();
                if (result == 1) {
                    usr1011_resBody.setResult("0");
                    usr1011_resBody.setResultDesc("设置成功");
                    response.setBodyObject(usr1011_resBody);
                    response.setResult(ResultCode.SUCCESS);
                } else {
                    usr1011_resBody.setResult("-2");
                    usr1011_resBody.setResultDesc("设置失败");
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
    public Class<USR1011_Req> getReqType() {
        return USR1011_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
