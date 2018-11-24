package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserAddress;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.UserAddressMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1013_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1013_ReqBody;
import com.huiji.api.msg.response.USR1013_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1013_ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孙旌翔 on 2016/7/17.
 */
@RestController
public class USR1013 extends AbstractBaseController<USR1013_Req,USR1013_ReqBody,USR1013_Res,USR1013_ResBody>{
    @RequestMapping(URLPREFIX+"/USR1013/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);

    }
    @Override
    public boolean checkRequestBodyParam(USR1013_Req usr1013_req) {

        try {
            USR1013_ReqBody usr1013_reqBody = usr1013_req.getBodyObject();
            if (usr1013_reqBody.getPhone() == null || "".equals(usr1013_reqBody.getPhone())) {
                return false;
            } else if (usr1013_reqBody.getName()==null || "".equals(usr1013_reqBody.getName())) {
                return false;
            }else if(usr1013_reqBody.getZipCode()==null||"".equals(usr1013_reqBody.getZipCode())){
                return false;
            }else if(usr1013_reqBody.getAddress()==null||"".equals(usr1013_reqBody.getZipCode())){
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public USR1013_Res getRes() {
        return new USR1013_Res();
    }


    @Autowired
    private UserAddressMapper useraddressMapper;
    /*@Autowired
    private UserSessionMapper usersessionMapper;*/
    @Override
    public void execute(IResponse response, IRequest<USR1013_ReqBody> request, String uid) throws Exception {
        String getSid11=request.getSid();
        GlobalLog.Biz.debug("getSid11："+getSid11);
        USR1013_ReqBody usr1013_reqBody=null;
        String getsid=request.getSid();
        GlobalLog.Biz.debug("getSid11：" + getsid);




        GlobalLog.Biz.debug("userid+++++++++：" + uid);

        try {
            usr1013_reqBody = request.getBodyObject();
            USR1013_ResBody usr1013_resBody=new USR1013_ResBody();
            /*UserSession userSession=usersessionMapper.searchUserSessionBySid(request.getSid());
            if(userSession==null){
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/



           /*int result= tb_user_addressMapper.insertAddress(tb_user_address.getName(),tb_user_address.getPhone(),tb_user_address.getUid(),
                    tb_user_address.getProvince(),tb_user_address.getCity(),tb_user_address.getArea(),tb_user_address.getStreet(),
                    tb_user_address.getZipCode(),tb_user_address.getAddress());*/

            int result=useraddressMapper.insertAddress(usr1013_reqBody.getName(),
                    usr1013_reqBody.getPhone(), uid,
                    usr1013_reqBody.getProvince(), usr1013_reqBody.getCity(),
                    usr1013_reqBody.getArea(), usr1013_reqBody.getStreet(),
                    usr1013_reqBody.getZipCode(), usr1013_reqBody.getAddress());

            if(result==1){ usr1013_resBody.setResultDesc("success");
                usr1013_resBody.setResult("0");
                response.setBodyObject(usr1013_resBody);
                response.setResult(ResultCode.SUCCESS);
            }
            else{
                usr1013_resBody.setResultDesc("fail");
                usr1013_resBody.setResult("1");
                response.setBodyObject(usr1013_resBody);
                response.setResult(ResultCode.SUCCESS);
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
    public Class<USR1013_Req> getReqType() {
        return USR1013_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
