package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserAccount;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.UserAccountMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.msg.request.PAY1004_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.PAY1004_ReqBody;
import com.huiji.api.msg.response.PAY1004_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.PAY1004_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
@RestController
public class PAY1004  extends AbstractBaseController<PAY1004_Req,PAY1004_ReqBody,PAY1004_Res,PAY1004_ResBody> {
   /* @Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private UserAccountMapper userAccountMapper;

    @RequestMapping(URLPREFIX + "/PAY1004/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(PAY1004_Req pay1004_req) {
        return true;
    }

    @Override
    public PAY1004_Res getRes() {
        return new PAY1004_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<PAY1004_ReqBody> request, String uid) throws Exception {
        try {
            /*UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            PAY1004_ResBody pay1004_resBody=new PAY1004_ResBody();
            //balance
            List<UserAccount> userAccounts=userAccountMapper.getBalance1(uid);
            Long money=0L;
            if(userAccounts.size()!=0) {
                for (UserAccount userAccount : userAccounts) {
                    money += userAccount.getBalance();
                }
            }
            pay1004_resBody.setBalance(money);
            pay1004_resBody.setResult("0");
            pay1004_resBody.setResultDesc("成功");
            response.setBodyObject(pay1004_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }

    }

    @Override
    public Class<PAY1004_Req> getReqType() {
        return PAY1004_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
