package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.ClientVersionInfo;
import com.huiji.api.db.mapper.ClientVersionInfoMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.SYS1000_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.SYS1000_ReqBody;
import com.huiji.api.msg.response.SYS1000_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.SYS1000_ResBody;
import com.huiji.api.msg.response.body.SYS1001_ResBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
@RestController
public class SYS1000 extends AbstractBaseController<SYS1000_Req,SYS1000_ReqBody,SYS1000_Res,SYS1000_ResBody> {
    @Value("${imgUrl}")
    private String imageUrl;
    @Value("${action}")
    private String action;
    @Resource
    private ClientVersionInfoMapper clientVersionInfoMapper;
    @RequestMapping(URLPREFIX + "/SYS1000/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(SYS1000_Req sys1000_req) {
        try {
            if(sys1000_req.getBodyObject().getProductId()==null||"".equals(sys1000_req.getBodyObject().getProductId())){
                return false;
            }
            if(sys1000_req.getBodyObject().getProductVersion()==null||"".equals(sys1000_req.getBodyObject().getProductVersion())){
                return false;
            }
            if(sys1000_req.getBodyObject().getChannelId()==null||"".equals(sys1000_req.getBodyObject().getChannelId())){
                return false;
            }

        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public SYS1000_Res getRes() {
        return new SYS1000_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<SYS1000_ReqBody> request, String uid) throws Exception {
        try {
            Map map= new HashMap<String,String>();
            map.put("product_id",request.getBodyObject().getProductId());
            map.put("product_version",request.getBodyObject().getProductVersion());
            map.put("channel_id",request.getBodyObject().getChannelId());
            ClientVersionInfo clientVersionInf=clientVersionInfoMapper.searchVersionInfo(map);
            //GlobalLog.Biz.debug("aftertoken : " + clientVersionInf);
            if(clientVersionInf!=null) {
                SYS1000_ResBody.UpdateBean UpdateBean = new SYS1000_ResBody.UpdateBean();
                UpdateBean.setVersion(clientVersionInf.getProduct_version());
                UpdateBean.setFlag(clientVersionInf.getUpdate_flag());
                UpdateBean.setDesc(clientVersionInf.getUpdate_desc());
                UpdateBean.setSize(clientVersionInf.getPack_size());
                UpdateBean.setUrl(clientVersionInf.getUpdate_url());
                String[] imageUrls=imageUrl.split(";");
                String[] actions=action.split(";");
                List<SYS1000_ResBody.AdvBean> advBeans=new ArrayList<SYS1000_ResBody.AdvBean>();
                for(int i=0;i<imageUrls.length;i++){
                    SYS1000_ResBody.AdvBean advBean=new SYS1000_ResBody.AdvBean();
                    advBean.setImageUrl(imageUrls[i]);
                    advBean.setAction(actions[i]);
                    advBeans.add(advBean);
                }
                SYS1000_ResBody sys1000_resBody = new SYS1000_ResBody();
                sys1000_resBody.setUpdate(UpdateBean);
                sys1000_resBody.setSplash(clientVersionInf.getSplash_url());
                sys1000_resBody.setAdv(advBeans);
                sys1000_resBody.setResult("0");
                sys1000_resBody.setResultDesc("Success");

                response.setBodyObject(sys1000_resBody);
                response.setResult(ResultCode.SUCCESS);
            }else{
                response.setResult(ResultCode.PARAM_ERROR);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<SYS1000_Req> getReqType() {
        return SYS1000_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
