package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.USR1000_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.TaskSms;
import com.huiji.api.db.mapper.TaskSmsMapper;
import com.huiji.api.db.mapper.UserAccountMapper;
import com.huiji.api.db.mapper.UserMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1000_ReqBody;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1000_ResBody;
import com.huiji.api.util.ActiveCodeUtil;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.StringUtil;
import com.huiji.api.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/23.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class USR1000_ServiceImpl implements USR1000_Service {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TaskSmsMapper taskSmsMapper;
    @Autowired
    private UserSessionMapper userSessionMapper;
    @Autowired
    private UserAccountMapper userAccountMapper;

    public void executeService(IResponse response, IRequest<USR1000_ReqBody> request,String productid)throws Exception{
        try {
            USR1000_ReqBody usr1000_reqBody = request.getBodyObject();
            GlobalLog.Biz.debug("usr1000_reqBody.getActiveCode() : " + usr1000_reqBody.getActiveCode());
            int res=userMapper.searchPhone(usr1000_reqBody.getPhone());
//            GlobalLog.Biz.debug("ActiveCode() : " +usr1000_reqBody.getPhone());
            TaskSms taskSms=taskSmsMapper.queryByPhone(usr1000_reqBody.getPhone(),1);
//            GlobalLog.Biz.debug("ActiveCode() : " + taskSms.toString());
            String ac= taskSms==null?"无获取。。。 * 。": String.valueOf(taskSms.getActiveCode());
            GlobalLog.Biz.debug("ActiveCode() : " + ac);
            String sid= ActiveCodeUtil.productActiveCode()+"";
            String expiredDate = DateUtil.dateToString(DateUtil.stringToDate("2099-10-01 12:00:00"));

            String date1 = DateUtil.dateToString2(new Date());
            String strDay = date1;
            String strMonth = date1.substring(4, 6);
            String strYear = date1.substring(0, 4);
            if (res==0) {
                if (usr1000_reqBody.getActiveCode().equals(ac)) {
                    String uuid= UUIDUtil.getUUID();
                    int result=userMapper.insertUser(uuid, usr1000_reqBody.getPhone(), usr1000_reqBody.getPhone(), StringUtil.MD5EncodeToHex(usr1000_reqBody.getPassword()),strDay,strMonth,strYear);
                    taskSmsMapper.updateUid(uuid, usr1000_reqBody.getPhone(), 1);
                    userSessionMapper.loginFirst(uuid, sid, productid, expiredDate,strDay,strMonth,strYear);
                    userAccountMapper.createUserAccount1000(uuid,strDay,strMonth,strYear);
                    userAccountMapper.createUserAccount2000(uuid,strDay,strMonth,strYear);
                    USR1000_ResBody usr1000_resBody = new USR1000_ResBody(sid,usr1000_reqBody.getPhone(),usr1000_reqBody.getPhone());
                    if (result==1){
                        usr1000_resBody.setResult("0");
                        usr1000_resBody.setResultDesc("注册成功");
                        response.setBodyObject(usr1000_resBody);
                        response.setResult(ResultCode.SUCCESS);
                    }else {
                        usr1000_resBody.setResult("-2");
                        usr1000_resBody.setResultDesc("注册失败");
                    }

                } else {
                    USR1000_ResBody usr1000_resBody = new USR1000_ResBody();
                    usr1000_resBody.setResult("-3");
                    usr1000_resBody.setResultDesc("验证码错误");
                    response.setBodyObject(usr1000_resBody);
                    response.setResult(ResultCode.SUCCESS);
                }
            } else {
                USR1000_ResBody usr1000_resBody = new USR1000_ResBody();
                usr1000_resBody.setResult("-3");
                usr1000_resBody.setResultDesc("用户已存在");
                response.setBodyObject(usr1000_resBody);
                response.setResult(ResultCode.SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
