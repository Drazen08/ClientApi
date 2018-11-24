package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserAddress;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.UserAddressMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1012_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1012_ReqBody;
import com.huiji.api.msg.response.USR1012_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1012_ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孙旌翔 on 2016/7/16.查询用户收货地址
 */
@RestController
public class USR1012 extends AbstractBaseController<USR1012_Req,USR1012_ReqBody,USR1012_Res,USR1012_ResBody> {

    @RequestMapping(URLPREFIX + "/USR1012/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest){
        return super.v(requestMsg, httpServletRequest);
    }




    @Override
    public boolean checkRequestBodyParam(USR1012_Req usr1012_req) {
        return true;
    }

    @Override
    public USR1012_Res getRes() {
        return new USR1012_Res();
    }

    @Autowired
    private UserAddressMapper useraddressMapper;
//    @Autowired
//    private UserSessionMapper usersessionMapper;
    @Override
    public void execute(IResponse response, IRequest<USR1012_ReqBody> request, String uid) throws Exception {
        String getsid=request.getSid();
        GlobalLog.Biz.debug("getSid11：" + getsid);

        GlobalLog.Biz.debug("userid+++++++++：" + uid);

        try {

            USR1012_ResBody usr1012_resBody = new USR1012_ResBody();

//            UserSession userSession=usersessionMapper.searchUserSessionBySid(request.getSid());
//            if(userSession==null){
//                response.setResult(ResultCode.SESSION_TIMEOUT);
//                return;
//            }
            List<UserAddress> list=useraddressMapper.getuserAddress(uid);
            usr1012_resBody.setAddresses(list);
            usr1012_resBody.setResult("0");
            usr1012_resBody.setResultDesc("成功");
            response.setBodyObject(usr1012_resBody);
            response.setResult(ResultCode.SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }

    }

    @Override
    public Class<USR1012_Req> getReqType() {
        return USR1012_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
