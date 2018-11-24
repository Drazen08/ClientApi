package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.TaskSms;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.TaskSmsMapper;
import com.huiji.api.db.mapper.UserMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1003_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1002_ReqBody;
import com.huiji.api.msg.request.body.USR1003_ReqBody;
import com.huiji.api.msg.response.USR1003_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1002_ResBody;
import com.huiji.api.msg.response.body.USR1003_ResBody;
import com.huiji.api.util.ActiveCodeUtil;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.UUIDUtil;
import com.huiji.api.util.ValidateUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
@RestController
public class USR1003  extends AbstractBaseController<USR1003_Req,USR1003_ReqBody,USR1003_Res,USR1003_ResBody> {
    @Resource
    private TaskSmsMapper taskSmsMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserSessionMapper userSessionMapper;
    private static String msg = "【汇际网】验证码:";
    @RequestMapping(URLPREFIX + "/USR1003/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(USR1003_Req usr1003_req) {
        try {
            String phone=usr1003_req.getBodyObject().getPhone();
            boolean flag = true;
            if (phone != null && !"".equals(phone)) {
                //验证手机号
                flag = ValidateUtil.ValidatePhone(phone);
            }
            if ("".equals(phone) || phone == null || !flag ) {

                return  false;
            }


        } catch (ParseException e) {
            e.printStackTrace();
            return  false;
        }
        return true;
    }

    @Override
    public USR1003_Res getRes() {
        return new USR1003_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<USR1003_ReqBody> request, String uid) throws Exception {
        try {
            USR1002_ResBody usr1002_resBody = new USR1002_ResBody();
//            int phontResult=userMapper.searchPhone(request.getBodyObject().getPhone());
//
//            if(phontResult==0){
//                usr1002_resBody.setResult("-1");
//                usr1002_resBody.setResultDesc("该手机号未被注册过，请核实手机号");
//                response.setBodyObject(usr1002_resBody);
//                response.setResult(ResultCode.SUCCESS);
//                return;
//            }

            String phone=request.getBodyObject().getPhone();
//            String uidDB = userMapper.searchUid(phone);
//            UserSession userSession=userSessionMapper.searchUserSessionBySid(request.getSid());
           /* if(userSession==null){
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            int activeCode = ActiveCodeUtil.productActiveCode();
            Date date = new Date();
            String createDate = DateUtil.dateToString(date);
            date.setTime(date.getTime() + 5 * 60 * 1000);
            String expiredDate = DateUtil.dateToString(date);
            String date1 = DateUtil.dateToString2(date);
            String strDay = date1;
            String strMonth = date1.substring(4, 6);
            String strYear = date1.substring(0, 4);
            //保证唯一性
            int type=2;
            int  resultCount=taskSmsMapper.updateExpiredTime(type,phone);
            GlobalLog.DB.info("USR1003 操作:type=2 在有效时间内将相同手机号：" + phone + "发送的短息的有效时间改为过期" +
                    "只保留最后一次为有效时间内要发送的短信。此操作在短信有效时间内数据库tb_task_sms已更新" + resultCount + "次");
            while(taskSmsMapper.searchSameActiveCode(activeCode,type)!=0){
                activeCode = ActiveCodeUtil.productActiveCode();
            }

            TaskSms taskSms = new TaskSms();
//            taskSms.setUid("");
            taskSms.setPhone(phone);
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
            GlobalLog.DB.debug("USR1003 操作:type=2 向数据库tb_task_sms插入数据：" + taskSms.toString() + "/n" + "返回结果：" + result);
            //db log
            //

            if (result != 1) {
                usr1002_resBody.setResult("-2");
                usr1002_resBody.setResultDesc("数据存储失败");
            }
            if (result == 1) {
                usr1002_resBody.setResult("0");
                usr1002_resBody.setResultDesc("数据存储完毕");
            }

            response.setBodyObject(usr1002_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        } finally {
        }
    }

    @Override
    public Class<USR1003_Req> getReqType() {
        return USR1003_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }

}
