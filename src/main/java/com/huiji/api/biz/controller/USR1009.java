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
import com.huiji.api.msg.request.USR1009_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1008_ReqBody;
import com.huiji.api.msg.request.body.USR1009_ReqBody;
import com.huiji.api.msg.response.USR1009_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1008_ResBody;
import com.huiji.api.msg.response.body.USR1009_ResBody;
import com.huiji.api.util.ActiveCodeUtil;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 王潇雨 on 2016/7/18.
 */
@RestController
public class USR1009 extends AbstractBaseController<USR1009_Req,USR1009_ReqBody,USR1009_Res,USR1009_ResBody>{
    private static String msg = "【汇际网】验证码:";
    @Autowired
    private TaskSmsMapper taskSmsMapper;
    @Autowired
    private UserMapper userMapper;
   /* @Resource
    private UserSessionMapper userSessionMapper;*/
    @RequestMapping(URLPREFIX + "/USR1009/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(USR1009_Req usr1009_req) {
        try {
            String phone = usr1009_req.getBodyObject().getPhone();
            boolean flag = true;
            if (phone != null && !"".equals(phone)) {
                //验证手机号
                flag = ValidateUtil.ValidatePhone(phone);
            }
            if ("".equals(phone) || phone == null || flag == false) {

                return  false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public USR1009_Res getRes() {
        return new USR1009_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<USR1009_ReqBody> request, String uid) throws Exception {
        try {
           /* UserSession userSession=userSessionMapper.searchUserSessionBySid(request.getSid());
            if(userSession==null){
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
//            GlobalLog.Biz.debug("UID:" + uid);
            int activeCode = ActiveCodeUtil.productActiveCode();
            //保证唯一性
            USR1009_ReqBody usr1009_reqBody = request.getBodyObject();//.getPhone();
            int type=4;
            taskSmsMapper.updateExpiredTime(type,usr1009_reqBody.getPhone());
            while(taskSmsMapper.searchSameActiveCode(activeCode,type)!=0){
                activeCode = ActiveCodeUtil.productActiveCode();
                 GlobalLog.Biz.debug("aftertoken : " + activeCode);
            }
            Date date = new Date();
            String createDate = DateUtil.dateToString(date);
            date.setTime(date.getTime() + 5 * 60 * 1000);
            String expiredDate = DateUtil.dateToString(date);
            String date1 = DateUtil.dateToString2(date);
            String strDay = date1;
            String strMonth = date1.substring(4, 6);
            String strYear = date1.substring(0, 4);
            TaskSms taskSms = new TaskSms();
            taskSms.setUid(uid);
            taskSms.setPhone(usr1009_reqBody.getPhone());
            taskSms.setMsg(msg+activeCode+",5分钟内有效，请勿泄露。");
            taskSms.setActiveCode(activeCode);
            taskSms.setState(1000);
            taskSms.setCreateTime(new Date());
            taskSms.setExpiredTime(expiredDate);
            taskSms.setType(type);
            taskSms.setStr_day(strDay);
            taskSms.setStr_month(strMonth);
            taskSms.setStr_year(strYear);
            int reslut = taskSmsMapper.insert(taskSms);
            GlobalLog.DB.debug("向数据库传的参数：" + taskSms.toString() + "/n" + "返回结果：" + reslut);
            //db log
            //
            USR1009_ResBody usr1009_resBody = new USR1009_ResBody();
            if (reslut != 1) {
                usr1009_resBody.setResult("-2");
                usr1009_resBody.setResultDesc("数据存储失败");
            }
            if (reslut == 1) {
                usr1009_resBody.setResult("0");
                usr1009_resBody.setResultDesc("数据存储完毕");
            }

            response.setBodyObject(usr1009_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<USR1009_Req> getReqType() {
        return USR1009_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
