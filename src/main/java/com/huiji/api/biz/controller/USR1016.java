package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserAddress;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1016_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1016_ReqBody;
import com.huiji.api.msg.response.USR1016_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1016_ResBody;
import com.huiji.api.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 孙旌翔 on 2016/7/18.
 */
@RestController
public class USR1016 extends AbstractBaseController<USR1016_Req,USR1016_ReqBody,USR1016_Res,USR1016_ResBody> {
    private String productid="";

    @RequestMapping(URLPREFIX + "/USR1016/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        productid=httpServletRequest.getRequestURI().split("/")[2];
        System.out.println(productid);


        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(USR1016_Req USR1016_req) {
        return true;
    }

    @Override
    public USR1016_Res getRes() {
        return new USR1016_Res();
    }


    @Autowired
    private UserSessionMapper usersessionMapper;
    @Override
    public void execute(IResponse response, IRequest<USR1016_ReqBody> request, String uid) throws Exception {
        String getSid11=request.getSid();
        GlobalLog.Biz.debug("getSid11："+getSid11);


        try {
            Date date = new Date();
            date.setTime(date.getTime());
            String expiredDate = DateUtil.dateToString(date);

            USR1016_ResBody USR1016_resBody=new USR1016_ResBody();
           /* UserSession userSession=usersessionMapper.searchUserSessionBySid(request.getSid());
            if(userSession==null){
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/


              int result=usersessionMapper.logout(productid,expiredDate,getSid11);
            if(result==1){ USR1016_resBody.setResultDesc("success");
                USR1016_resBody.setResult("0");
                USR1016_resBody.setResultDesc("操作成功");
                response.setBodyObject(USR1016_resBody);
                response.setResult(ResultCode.SUCCESS);
            }
            else{
                USR1016_resBody.setResultDesc("操作失败");
                USR1016_resBody.setResult("1");
                response.setBodyObject(USR1016_resBody);
                response.setResult(ResultCode.PARSE_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<USR1016_Req> getReqType() {
        return USR1016_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
