package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.TaskSms;
import com.huiji.api.db.entity.UserEntity;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.TaskSmsMapper;

import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1020_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1020_ReqBody;
import com.huiji.api.msg.response.USR1020_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1002_ResBody;
import com.huiji.api.msg.response.body.USR1020_ResBody;
import com.huiji.api.util.ActiveCodeUtil;
import com.huiji.api.util.DateUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 孙文剑 on 2016/8/4 0004.
 */
@RestController
public class USR1020 extends AbstractBaseController<USR1020_Req,USR1020_ReqBody,USR1020_Res,USR1020_ResBody> {
    @Resource
    private TaskSmsMapper taskSmsMapper;
    @Resource
    private UserSessionMapper userSessionMapper;
    private static String msg = "【汇际网】验证码:";
    @RequestMapping(URLPREFIX + "/USR1020/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(USR1020_Req usr1020_req) {
        return true;
    }

    @Override
    public USR1020_Res getRes() {
        return new USR1020_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<USR1020_ReqBody> request, String uid) {
        try {

            int activeCode = ActiveCodeUtil.productActiveCode();
            Date date = new Date();
            String createDate = DateUtil.dateToString(date);
            date.setTime(date.getTime() + 5 * 60 * 1000);
            String expiredDate = DateUtil.dateToString(date);
            String date1 = DateUtil.dateToString2(date);
            String strDay = date1;
            String strMonth = date1.substring(4, 6);
            String strYear = date1.substring(0, 4);
            //保证
            int type=6;
            UserEntity userEntity=userSessionMapper.searchUserBySid(request.getSid());
            if (userEntity == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }

            int resultCount=taskSmsMapper.updateExpiredTime(type, userEntity.getPhone());
            GlobalLog.DB.info("USR1020 操作:type=6 在有效时间内将相同手机号："+userEntity.getPhone()+"发送的短息的有效时间改为过期" +
                    "只保留最后一次为有效时间内要发送的短信。此操作在短信有效时间内数据库tb_task_sms已更新"+resultCount+"次");
            while(taskSmsMapper.searchSameActiveCode(activeCode,type)!=0){
                activeCode = ActiveCodeUtil.productActiveCode();
                // GlobalLog.Biz.debug("aftertoken : " + token);
            }

            TaskSms taskSms = new TaskSms();
            taskSms.setUid(userEntity.getUid());
            taskSms.setPhone(userEntity.getPhone());
            taskSms.setMsg(msg+activeCode+",5分钟内有效，请勿泄露。");
            taskSms.setActiveCode(activeCode);
            taskSms.setState(1000);
            taskSms.setCreateTime(new Date());
            taskSms.setExpiredTime(expiredDate);
            taskSms.setType(type);
            taskSms.setStr_day(strDay);
            taskSms.setStr_month(strMonth);
            taskSms.setStr_year(strYear);
            int result = taskSmsMapper.insert(taskSms);
            GlobalLog.DB.debug("USR1020 操作:type=6 向数据库tb_task_sms插入数据：" + taskSms.toString() + "/n" + "返回结果：" + result);
            //db log
            //
            USR1020_ResBody usr1020_resBody = new USR1020_ResBody();
            if (result != 1) {
                usr1020_resBody.setResult("-2");
                usr1020_resBody.setResultDesc("数据存储失败");
            }
            if (result == 1) {
                usr1020_resBody.setResult("0");
                usr1020_resBody.setResultDesc("数据存储完毕");
            }

            response.setBodyObject(usr1020_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        } finally {
        }
    }

    @Override
    public Class<USR1020_Req> getReqType() {
        return USR1020_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
