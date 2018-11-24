package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.TaskSms;
import com.huiji.api.db.entity.UserEntity;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.entity.UserToken;
import com.huiji.api.db.mapper.TaskSmsMapper;
import com.huiji.api.db.mapper.UserMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.db.mapper.UserTokenMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1004_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1004_ReqBody;
import com.huiji.api.msg.response.USR1004_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1004_ResBody;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.TokenProcessor;
import com.huiji.api.util.TokenUtil;
import com.huiji.api.util.ValidateUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 孙文剑 on 2016/7/17 0017.
 */
@RestController
public class USR1004 extends AbstractBaseController<USR1004_Req,USR1004_ReqBody,USR1004_Res,USR1004_ResBody> {
    @Resource
    private TaskSmsMapper taskSmsMapper;
    /*@Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private UserTokenMapper userTokenMapper;
    @Resource
    private UserMapper userMapper;
    @RequestMapping(URLPREFIX + "/USR1004/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(USR1004_Req usr1004_req) {
        try {
            USR1004_ReqBody usr1004_reqBody=usr1004_req.getBodyObject();
            String phone=usr1004_reqBody.getPhone();
            String activeCode=usr1004_reqBody.getActiveCode();
            boolean flag = true;
            if (phone != null && !"".equals(phone)) {
                //验证手机号
                flag = ValidateUtil.ValidatePhone(phone);
            }
            if ("".equals(phone) || phone == null || flag == false) {

                return  false;
            }
            //一个手机号可对应多个验证码   但  唯一的验证码能够对应唯一的 phone（把1002再做一下）
            if(activeCode==null||"".equals(activeCode))
                return false;
            //这个地方应该是寻找状态为发送成功的信息才能有意义*******

        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public USR1004_Res getRes() {
        return new USR1004_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<USR1004_ReqBody> request, String uid) throws Exception {
        //  *** 判断session有没有超时******  把其作为一个公共方法才行
        try {
            USR1004_ResBody usr1004_resBody=new USR1004_ResBody();
            String activeCode=request.getBodyObject().getActiveCode();
            String phone=request.getBodyObject().getPhone();
            int type=2;
            TaskSms taskSms=taskSmsMapper.queryByPhone(phone, type);
            String ac= taskSms==null?"无获取。。。 * 。": String.valueOf(taskSms.getActiveCode());
            if(!activeCode.equals(ac)){
                usr1004_resBody.setResult("-1");
                usr1004_resBody.setResultDesc("手机号与验证码不符或当前验证码已失效");
                response.setBodyObject(usr1004_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }

            //GlobalLog.Biz.debug("uidDB : " + uidDB);
//        TokenProcessor tokenProcessor=TokenProcessor.getInstance();
//        String token=tokenProcessor.generateTokeCode();
//        GlobalLog.Biz.debug("token : " + token);
            UserEntity user=userMapper.queryByPhone(phone);
            if(user==null){
                usr1004_resBody.setResult("-2");
                usr1004_resBody.setResultDesc("手机号并未注册请确认");
                response.setBodyObject(usr1004_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }
            userTokenMapper.updateTokenExpired_time(user.getUid());

            TokenUtil tokenUtil=new TokenUtil();
            String token=tokenUtil.nowNumber();
            while(userTokenMapper.SearchSameTokenCode(token)!=0){
                token=tokenUtil.nowNumber();
               // GlobalLog.Biz.debug("aftertoken : " + token);
            }

            Date date = new Date();

            date.setTime(date.getTime() + 5 * 60 * 1000);
            String expiredDate = DateUtil.dateToString(date);
            UserToken userToken=new UserToken(user.getUid(),token,expiredDate,1);
            int result=userTokenMapper.save(userToken);
            if(result==1){
                usr1004_resBody.setToken(token);
                usr1004_resBody.setResult("0");
                usr1004_resBody.setResultDesc("完成token返回");
                response.setBodyObject(usr1004_resBody);
                response.setResult(ResultCode.SUCCESS);
            }else{
                response.setResult(ResultCode.SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<USR1004_Req> getReqType() {
        return USR1004_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
