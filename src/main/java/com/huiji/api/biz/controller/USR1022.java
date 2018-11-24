package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.MyTestTransactional;
import com.huiji.api.biz.service.base.USR1022_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.TaskUserBankMapper;
import com.huiji.api.db.mapper.USRBankMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.msg.request.USR1022_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1022_ReqBody;
import com.huiji.api.msg.response.USR1022_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1022_ResBody;
import com.huiji.api.util.ActiveCodeUtil;
import com.huiji.api.util.DateUtil;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Jingxiang on 2016/8/12.
 */
@RestController
public class USR1022 extends AbstractBaseController<USR1022_Req, USR1022_ReqBody, USR1022_Res, USR1022_ResBody> {
/*    @Resource
    private UserSessionMapper userSessionMapper;*/
   @Resource
   private USR1022_Service usr1022_service;


    @RequestMapping(URLPREFIX+"/USR1022/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        try {
            return super.v(requestMsg, httpServletRequest) ;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }



    @Override
    public boolean checkRequestBodyParam(USR1022_Req usr1022_req) {
        return true;
    }

    @Override
    public USR1022_Res getRes() {
        return new USR1022_Res();
    }
    /*#{uid},#{money},#{bank_id},#{card_num},#{status},#{bill_id},#{bankmaster}*/

    @Override
    public void execute(IResponse response, IRequest<USR1022_ReqBody> request, String uid)  throws Exception{
        try {
            /*UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            usr1022_service.executeService(response,request,uid);

        }catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }



    }

    @Override
    public Class<USR1022_Req> getReqType() {
        return USR1022_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
