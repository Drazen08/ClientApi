package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.TaskSms;
import com.huiji.api.db.entity.UserBank;
import com.huiji.api.db.entity.UserEntity;
import com.huiji.api.db.mapper.TaskSmsMapper;
import com.huiji.api.db.mapper.USRBankMapper;
import com.huiji.api.db.mapper.UserMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1019_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1019_ReqBody;
import com.huiji.api.msg.response.USR1019_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1019_ResBody;
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
public class USR1019 extends AbstractBaseController<USR1019_Req,USR1019_ReqBody,USR1019_Res,USR1019_ResBody> {
    @Resource
    private UserSessionMapper userSessionMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private TaskSmsMapper taskSmsMapper;
    @Resource
    private USRBankMapper usrBankMapper;
    @RequestMapping(URLPREFIX + "/USR1019/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(USR1019_Req usr1019_req) {
        try {
            String bankName=usr1019_req.getBodyObject().getBankName();
            String cardId=usr1019_req.getBodyObject().getCardId();
            String name=usr1019_req.getBodyObject().getName();
            String activeCode=usr1019_req.getBodyObject().getActiveCode();
            if("".equals(bankName)||bankName==null)
                return false;
            if("".equals(cardId)||cardId==null)
                return false;
            if("".equals(name)||name==null)
                return false;
            if("".equals(activeCode)||activeCode==null)
                return false;

        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }


        return true;
    }

    @Override
    public USR1019_Res getRes() {
        return new USR1019_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<USR1019_ReqBody> request, String uid) throws Exception {
        try {
            UserEntity userEntity=userSessionMapper.searchUserBySid(request.getSid());
            if (userEntity == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }



            USR1019_ResBody usr1019_resBody=new USR1019_ResBody();
            String activeCode=request.getBodyObject().getActiveCode();
            String bankName=request.getBodyObject().getBankName();
            String cardId=request.getBodyObject().getCardId();
            String name=request.getBodyObject().getName();
            int type=6;
            TaskSms taskSms=taskSmsMapper.queryByPhone(userEntity.getPhone(), type);
            String ac= taskSms==null?"无获取。。。 * 。": String.valueOf(taskSms.getActiveCode());
            if(!activeCode.equals(ac)) {
                usr1019_resBody.setResult("-1");
                usr1019_resBody.setResultDesc("验证码输入错误");
                response.setBodyObject(usr1019_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }
            UserBank userBank=usrBankMapper.getUserBankByCardId(cardId);
            if(userBank!=null){
                usr1019_resBody.setResult("-2");
                usr1019_resBody.setResultDesc("此卡号已经绑定");
                response.setBodyObject(usr1019_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }
            String createTime= DateUtil.dateToString(new Date());
            String date=DateUtil.dateToString2(new Date());
            String strDay=date;
            String strMonth=date.substring(4,6);
            String strYear=date.substring(0,4);
            usrBankMapper.saveUserBank(new UserBank(userEntity.getUid(),cardId,bankName,name,userEntity.getPhone(),createTime,strDay,strMonth,strYear));
            usr1019_resBody.setResult("0");
            usr1019_resBody.setResultDesc("成功绑定银行卡");
            response.setBodyObject(usr1019_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }

    }

    @Override
    public Class<USR1019_Req> getReqType() {
        return USR1019_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
