package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserAddress;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.UserAddressMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1014_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1014_ReqBody;
import com.huiji.api.msg.response.USR1014_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1014_ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孙旌翔 on 2016/7/18.
 */
@RestController
public class USR1014 extends AbstractBaseController<USR1014_Req, USR1014_ReqBody, USR1014_Res, USR1014_ResBody> {

    @RequestMapping(URLPREFIX + "/USR1014/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }


    @Override
    public boolean checkRequestBodyParam(USR1014_Req usr1014_req) {

        try {
            USR1014_ReqBody usr1014_reqBody = usr1014_req.getBodyObject();
            if (usr1014_reqBody.getPhone() == null || "".equals(usr1014_reqBody.getPhone())) {
                return false;
            } else if (usr1014_reqBody.getName() == null || "".equals(usr1014_reqBody.getName())) {
                return false;
            } else if (usr1014_reqBody.getZipCode() == null || "".equals(usr1014_reqBody.getZipCode())) {
                return false;
            } else if (usr1014_reqBody.getAddress() == null || "".equals(usr1014_reqBody.getZipCode())) {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    @Override
    public USR1014_Res getRes() {
        return new USR1014_Res();
    }

   /* @Autowired
    private UserSessionMapper userSessionMapper;*/
    @Autowired
    private UserAddressMapper useraddressMapper;

    @Override
    public void execute(IResponse response, IRequest<USR1014_ReqBody> request, String uid) throws Exception {
        String getSid11 = request.getSid();
        GlobalLog.Biz.debug("getSid11：" + getSid11);
        USR1014_ReqBody usr1014_reqBody = null;


        try {
           /* UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            usr1014_reqBody = request.getBodyObject();
            USR1014_ResBody usr1014_resBody = new USR1014_ResBody();




           /*int result= tb_user_addressMapper.insertAddress(tb_user_address.getName(),tb_user_address.getPhone(),tb_user_address.getUid(),
                    tb_user_address.getProvince(),tb_user_address.getCity(),tb_user_address.getArea(),tb_user_address.getStreet(),
                    tb_user_address.getZipCode(),tb_user_address.getAddress());*/

            int result = useraddressMapper.updateAddress(
                    usr1014_reqBody.getId(),
                    usr1014_reqBody.getName(),
                    usr1014_reqBody.getPhone(),
                    usr1014_reqBody.getProvince(), usr1014_reqBody.getCity(),
                    usr1014_reqBody.getArea(), usr1014_reqBody.getStreet(),
                    usr1014_reqBody.getZipCode(), usr1014_reqBody.getAddress(),uid);

        /*(usr1014_reqBody.getName(),
                usr1014_reqBody.getPhone(), usr1014_reqBody.getUid(),
                usr1014_reqBody.getProvince(), usr1014_reqBody.getCity(),
                usr1014_reqBody.getArea(), usr1014_reqBody.getStreet(),
                usr1014_reqBody.getZipCode(), usr1014_reqBody.getAddress());*/

            if (result == 1) {
                usr1014_resBody.setResultDesc("success");
                usr1014_resBody.setResult("0");
                response.setBodyObject(usr1014_resBody);
                response.setResult(ResultCode.SUCCESS);
            } else {
                usr1014_resBody.setResultDesc("fail");
                usr1014_resBody.setResult("1");
                response.setBodyObject(usr1014_resBody);
                response.setResult(ResultCode.PARSE_ERROR);
            }

        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);

        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }


    @Override
    public Class<USR1014_Req> getReqType() {
        return USR1014_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
