package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.DicNavType;
import com.huiji.api.db.mapper.DicNavTypeMapper;
import com.huiji.api.msg.request.DIC1000_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.DIC1000_ReqBody;
import com.huiji.api.msg.response.DIC1000_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.DIC1000_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static com.huiji.api.msg.response.body.DIC1000_ResBody.*;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
@RestController
public class DIC1000 extends AbstractBaseController<DIC1000_Req,DIC1000_ReqBody,DIC1000_Res,DIC1000_ResBody> {
    @Resource
    private DicNavTypeMapper dicNavTypeMapper;
    @RequestMapping(URLPREFIX + "/DIC1000/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest)  {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(DIC1000_Req dic1000_req) {
        return true;
    }

    @Override
    public DIC1000_Res getRes() {
        return new DIC1000_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<DIC1000_ReqBody> request, String uid) throws Exception {
        try {
            DIC1000_ResBody dic1000_resBody=new DIC1000_ResBody();
            List<DicNavType> roots=dicNavTypeMapper.searchRoots();
            List<Item> root=new ArrayList<Item>();
            for(DicNavType dicNavType:roots){
    //            dic1000_resBody.set
                Item itemRoot=new Item();

                List<DicNavType> level1=dicNavTypeMapper.searchLevel1(dicNavType.getId());
                List<Item> levelList=new ArrayList<Item>();
                for(DicNavType dicNavTypeLevel:level1){
                    Item item=new Item();
                    item.setId(dicNavTypeLevel.getId());
                    item.setName(dicNavTypeLevel.getClass_name());
                    item.setItems(null);
                    levelList.add(item);
                }
                itemRoot.setId(dicNavType.getId());
                itemRoot.setName(dicNavType.getClass_name());
                itemRoot.setItems(levelList);
                root.add(itemRoot);


            }
            dic1000_resBody.setItems(root);
            dic1000_resBody.setResult("0");
            dic1000_resBody.setResultDesc("成功");

            response.setBodyObject(dic1000_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<DIC1000_Req> getReqType() {
        return DIC1000_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
