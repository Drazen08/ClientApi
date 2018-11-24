package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.GoodClass;
import com.huiji.api.db.mapper.GoodClassMapper;
import com.huiji.api.msg.request.DIC1002_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.DIC1002_ReqBody;
import com.huiji.api.msg.response.DIC1002_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.DIC1002_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingxiang on 2016/8/13.首页快捷导航
 */
@RestController
public class DIC1002 extends AbstractBaseController<DIC1002_Req,DIC1002_ReqBody,DIC1002_Res,DIC1002_ResBody> {
    @Resource
    private GoodClassMapper goodClassMapper;




    @RequestMapping(URLPREFIX+"/DIC1002/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(DIC1002_Req dic1002_req) {
        return true;
    }

    @Override
    public DIC1002_Res getRes() {
        return new DIC1002_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<DIC1002_ReqBody> request, String uid) throws Exception {
        try {
            DIC1002_ReqBody dic1002_reqBody=request.getBodyObject();
            DIC1002_ResBody dic1002_resBody=new DIC1002_ResBody();
            List<GoodClass>li=goodClassMapper.dic1002();
            List<DIC1002_ResBody.ItemsBean> list=new ArrayList<DIC1002_ResBody.ItemsBean>();
            for(GoodClass goodClass:li){
                DIC1002_ResBody.ItemsBean itemsBean=new DIC1002_ResBody.ItemsBean();
                itemsBean.setId(goodClass.getId());
                itemsBean.setName(goodClass.getClass_name());
                list.add(itemsBean);
            }
            dic1002_resBody.setItems(list);
            dic1002_resBody.setResult("0");
            dic1002_resBody.setResultDesc("操作成功");
            response.setBodyObject(dic1002_resBody);
            response.setResult(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<DIC1002_Req> getReqType() {
        return DIC1002_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
