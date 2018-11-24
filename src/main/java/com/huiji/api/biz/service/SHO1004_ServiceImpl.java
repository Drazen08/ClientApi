package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.SHO1004_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserFollowShop;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.ShopMapper;
import com.huiji.api.db.mapper.UserFollowShopMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.SHO1004_ReqBody;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.SHO1004_ResBody;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/9/26.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SHO1004_ServiceImpl implements SHO1004_Service {
    @Resource
    private UserFollowShopMapper userFollowShopMapper;
    @Resource
    private ShopMapper shopMapper;

    public void executeService(IResponse response, IRequest<SHO1004_ReqBody> request,String uid) throws Exception{
        try {
            SHO1004_ReqBody sho1004_reqBody=null;
            sho1004_reqBody=request.getBodyObject();
            SHO1004_ResBody sho1004_resBody=new SHO1004_ResBody();
            int type=sho1004_reqBody.getType();
            UserFollowShop a=userFollowShopMapper.userfollow(uid, sho1004_reqBody.getShopId());
            UserFollowShop b=userFollowShopMapper.userfollow1(uid, sho1004_reqBody.getShopId());
            // type 1关注/0 不关注
            String listener=null;
            if(a==null){

                if(type==1&&b==null){
                    userFollowShopMapper.followshop(uid,sho1004_reqBody.getShopId());
                    listener="listener_num+1";
                    userFollowShopMapper.changeFollow(listener,sho1004_reqBody.getShopId());
                    sho1004_resBody.setResult("0");
                    sho1004_resBody.setResultDesc("操作成功");
                    response.setBodyObject(sho1004_resBody);
                    response.setResult(ResultCode.SUCCESS);
                }

                if (type==1&&b!=null){
                    userFollowShopMapper.notFollow(1, uid, sho1004_reqBody.getShopId());
                    listener="listener_num+1";
                    userFollowShopMapper.changeFollow(listener,sho1004_reqBody.getShopId());
                    sho1004_resBody.setResult("0");
                    sho1004_resBody.setResultDesc("操作成功");
                    response.setBodyObject(sho1004_resBody);
                    response.setResult(ResultCode.SUCCESS);
                }

            }else{
               if(type==1){
                    userFollowShopMapper.notFollow(1, uid, sho1004_reqBody.getShopId());
                    listener="listener_num+1";
                    userFollowShopMapper.changeFollow(listener, sho1004_reqBody.getShopId());
                    sho1004_resBody.setResult("0");
                    sho1004_resBody.setResultDesc("操作成功");
                    response.setBodyObject(sho1004_resBody);
                    response.setResult(ResultCode.SUCCESS);
                }
                if(type==0) {
                    userFollowShopMapper.notFollow(0, uid, sho1004_reqBody.getShopId());
                    listener="listener_num-1";
                    userFollowShopMapper.changeFollow(listener, sho1004_reqBody.getShopId());
                    sho1004_resBody.setResult("0");
                    sho1004_resBody.setResultDesc("操作成功");
                    response.setBodyObject(sho1004_resBody);
                    response.setResult(ResultCode.SUCCESS);

                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw e;
        }

    }

}
