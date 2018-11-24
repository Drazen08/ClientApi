package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserBank;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.USRBankMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.USR1021_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1021_ReqBody;
import com.huiji.api.msg.response.USR1021_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1021_ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingxiang on 2016/8/4.
 */
@RestController
public class USR1021 extends AbstractBaseController<USR1021_Req, USR1021_ReqBody, USR1021_Res, USR1021_ResBody> {
    @Autowired
    private USRBankMapper usrBankMapper;
    /*@Autowired
    private UserSessionMapper usersessionMapper;*/

    @RequestMapping(URLPREFIX + "/USR1021/*/")

    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest){
        return super.v(requestMsg, httpServletRequest);
    }


    @Override
    public boolean checkRequestBodyParam(USR1021_Req usr1021_req) {
        return true;
    }

    @Override
    public USR1021_Res getRes() {
        return new USR1021_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<USR1021_ReqBody> request, String uid) throws Exception {
        String getsid = request.getSid();
        GlobalLog.Biz.debug("getSid11：" + getsid);

        GlobalLog.Biz.debug("userid+++++++++：" + uid);
        try {
            USR1021_ResBody usr1021_resBody = new USR1021_ResBody();

            List<USR1021_ResBody.ItemsBean> bankList=new ArrayList<USR1021_ResBody.ItemsBean>();
            List<UserBank> list = usrBankMapper.getUserBanks(uid);
            for(UserBank userBank :list){
                USR1021_ResBody.ItemsBean itemsBean=new USR1021_ResBody.ItemsBean();
                itemsBean.setBankid(userBank.getId());
                itemsBean.setBanktype(userBank.getBanktype());
                itemsBean.setCardId(userBank.getCardid());
                bankList.add(itemsBean);
            }
            usr1021_resBody.setItems(bankList);
            usr1021_resBody.setResult("0");
            usr1021_resBody.setResultDesc("success");
            response.setBodyObject(usr1021_resBody);
            response.setResult(ResultCode.SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }


    }

    @Override
    public Class<USR1021_Req> getReqType() {
        return USR1021_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
