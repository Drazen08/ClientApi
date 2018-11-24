package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.Shop;
import com.huiji.api.db.entity.UserFollowShop;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.*;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.SHO1001_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.SHO1001_ReqBody;
import com.huiji.api.msg.response.SHO1001_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.SHO1001_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Jingxiang on 2016/8/8.
 */
@RestController
public class SHO1001 extends AbstractBaseController<SHO1001_Req,SHO1001_ReqBody,SHO1001_Res,SHO1001_ResBody> {

    @Resource
    private ShopMapper shopMapper;
    @Resource
    private ShopClassMapper shopClassMapper;
    @Resource
    private UserSessionMapper userSessionMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserFollowShopMapper userFollowShopMapper;

    @RequestMapping(URLPREFIX+"/SHO1001/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
    GlobalLog.Biz.debug("requestMsg : " + requestMsg);
    return super.v(requestMsg, httpServletRequest);
}



    @Override
    public boolean checkRequestBodyParam(SHO1001_Req sho1001_req) {
        return true;
    }

    @Override
    public SHO1001_Res getRes() {
        return new SHO1001_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<SHO1001_ReqBody> request, String uid) throws Exception {
        try {
            UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());

            SHO1001_ReqBody SHO1001_reqBody=null;
            SHO1001_reqBody=request.getBodyObject();
            SHO1001_ResBody sho1001_resBody=new SHO1001_ResBody();
            Shop shop=shopMapper.getShopById(SHO1001_reqBody.getShopid());
            UserFollowShop a=null;
            if(userSession!=null) {
                a=userFollowShopMapper.userfollow(userSession.getUid(), String.valueOf(SHO1001_reqBody.getShopid()));
            }

            sho1001_resBody.setUrlLogo(shop.getShop_logo());
            //背景图
            sho1001_resBody.setBackgroundPic(shop.getBackground_url());
            sho1001_resBody.setConcernNum(shop.getListener_num());
            sho1001_resBody.setShopName(shop.getName());
            //是否关注 0不关注/ 1：关注
            if (a==null){
                sho1001_resBody.setConcernFlag("0");
            }else{
                sho1001_resBody.setConcernFlag("1");
            }
            response.setBodyObject(sho1001_resBody);
            response.setResult(ResultCode.SUCCESS);

        }catch (Exception e){
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }
    }


    @Override
    public Class<SHO1001_Req> getReqType() {
        return SHO1001_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}





