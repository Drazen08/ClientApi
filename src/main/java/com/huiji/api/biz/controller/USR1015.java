package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserAddress;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.UserAddressMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1015_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1015_ReqBody;
import com.huiji.api.msg.response.USR1015_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1015_ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孙旌翔 on 2016/7/18.
 */
@RestController
public class USR1015 extends AbstractBaseController<USR1015_Req,USR1015_ReqBody,USR1015_Res,USR1015_ResBody> {
    @RequestMapping(URLPREFIX + "/USR1015/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(USR1015_Req usr1015_req) {
        try {
            USR1015_ReqBody usr1015_reqBody = usr1015_req.getBodyObject();
            if (usr1015_reqBody.getId()==0) {
                return false;

            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public USR1015_Res getRes() {
        return new USR1015_Res();
    }


    @Autowired
    private UserAddressMapper useraddressMapper;
//    @Autowired
//    private UserSessionMapper userSessionMapper;
    @Override
    public void execute(IResponse response, IRequest<USR1015_ReqBody> request, String uid) throws Exception {

             //删除用户收货地址
            //一个用户可以拥有多个收货地址
             //区分的是id
        try {
            String getSid11=request.getSid();
            GlobalLog.Biz.debug("getSid11："+getSid11);

            USR1015_ReqBody usr1015_reqBody = request.getBodyObject();
            USR1015_ResBody usr1015_resBody=new USR1015_ResBody();
           /* UserSession userSession=userSessionMapper.searchUserSessionBySid(request.getSid());
            if(userSession==null){
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
           /* UserAddress tb_user_address=new UserAddress();*/
            int result=useraddressMapper.deleteAddress(usr1015_reqBody.getId());
            /*int result=tb_user_addressMapper.deleteAddress(usr1015_reqBody.getId());*/



            if(result==1){ usr1015_resBody.setResultDesc("删除成功");
                usr1015_resBody.setResult("0");
                response.setBodyObject(usr1015_resBody);
                response.setResult(ResultCode.SUCCESS);
            }
            else{
                usr1015_resBody.setResultDesc("删除失败");
                usr1015_resBody.setResult("1");
                response.setBodyObject(usr1015_resBody);
                response.setResult(ResultCode.PARSE_ERROR);
            }

        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);

        }catch (Exception e){
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<USR1015_Req> getReqType() {
        return USR1015_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
