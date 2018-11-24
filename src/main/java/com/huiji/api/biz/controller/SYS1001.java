package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.ClientVersionInfo;
import com.huiji.api.db.mapper.ClientVersionInfoMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.SYS1001_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.SYS1001_ReqBody;
import com.huiji.api.msg.response.SYS1001_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.SYS1001_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
@RestController
public class SYS1001 extends AbstractBaseController<SYS1001_Req,SYS1001_ReqBody,SYS1001_Res,SYS1001_ResBody> {
    @Resource
    private ClientVersionInfoMapper clientVersionInfoMapper;
    @RequestMapping(URLPREFIX + "/SYS1001/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(SYS1001_Req sys1001_req) {
        try {
            if(sys1001_req.getBodyObject().getProductId()==null||"".equals(sys1001_req.getBodyObject().getProductId())){
                return false;
            }
            if(sys1001_req.getBodyObject().getProductVersion()==null||"".equals(sys1001_req.getBodyObject().getProductVersion())){
                return false;
            }
            if(sys1001_req.getBodyObject().getChannelId()==null||"".equals(sys1001_req.getBodyObject().getChannelId())){
                return false;
            }

        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public SYS1001_Res getRes() {
        return new  SYS1001_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<SYS1001_ReqBody> request, String uid) throws Exception {
        try {
            Map map= new HashMap<String,String>();
            map.put("product_id",request.getBodyObject().getProductId());
            map.put("product_version",request.getBodyObject().getProductVersion());
            map.put("channel_id",request.getBodyObject().getChannelId());
            ClientVersionInfo clientVersionInf=clientVersionInfoMapper.searchVersionInfo(map);
            //GlobalLog.Biz.debug("aftertoken : " + clientVersionInf);
            if(clientVersionInf!=null) {
                SYS1001_ResBody.UpdateBean UpdateBean = new SYS1001_ResBody.UpdateBean();
                UpdateBean.setVersion(clientVersionInf.getProduct_version());
                UpdateBean.setFlag(clientVersionInf.getUpdate_flag());
                UpdateBean.setDesc(clientVersionInf.getUpdate_desc());
                UpdateBean.setSize(clientVersionInf.getPack_size());
                UpdateBean.setUrl(clientVersionInf.getUpdate_url());

                SYS1001_ResBody sys1001_resBody = new SYS1001_ResBody();
                sys1001_resBody.setUpdate(UpdateBean);
                sys1001_resBody.setResult("0");
                sys1001_resBody.setResultDesc("Success");

                response.setBodyObject(sys1001_resBody);
                response.setResult(ResultCode.SUCCESS);
            }else{
                response.setResult(ResultCode.SERVER_ERROR);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }

    }

    @Override
    public Class<SYS1001_Req> getReqType() {
        return SYS1001_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
