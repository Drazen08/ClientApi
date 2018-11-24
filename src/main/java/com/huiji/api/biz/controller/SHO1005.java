package com.huiji.api.biz.controller;

/**
 * Created by Jingxiang on 2016/10/9.
 */

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.Shop;
import com.huiji.api.db.entity.ShopClass;
import com.huiji.api.db.mapper.ShopClassMapper;
import com.huiji.api.db.mapper.ShopMapper;
import com.huiji.api.msg.request.SHO1005_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.SHO1005_ReqBody;
import com.huiji.api.msg.response.SHO1005_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.SHO1005_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SHO1005   extends AbstractBaseController<SHO1005_Req,SHO1005_ReqBody,SHO1005_Res,SHO1005_ResBody> {

    @Resource
    private ShopMapper shopMapper;
    @Resource
    private ShopClassMapper shopClassMapper;
    
    @RequestMapping(URLPREFIX+"/SHO1005/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    
    @Override
    public boolean checkRequestBodyParam(SHO1005_Req sho1005_req) {
        return true;
    }

    @Override
    public SHO1005_Res getRes() {
        return new SHO1005_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<SHO1005_ReqBody> request, String uid) throws Exception {
        try {
            int currentPage=request.getBodyObject().getPageNow();
            int searchType=request.getBodyObject().getType();//1:全部  2:人气  3:销量
            int classId=request.getBodyObject().getClassId();
            int ignore=(currentPage-1)*10;
            int show=currentPage*10;
            SHO1005_ResBody SHO1005_resBody=new SHO1005_ResBody();
            String orderBy="";
            if(searchType==1){
                orderBy="listener_num";
            }else if(searchType==2){
                orderBy="listener_num";
            }else if(searchType==3){
                orderBy="num";
            }

            SHO1005_resBody.setItems(result(shopMapper.ShouyeDianji(classId,orderBy,ignore,show)));
            SHO1005_resBody.setCurrentPage(currentPage);
            response.setBodyObject(SHO1005_resBody);
            response.setResult(ResultCode.SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<SHO1005_Req> getReqType() {
        return SHO1005_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }

    public List<SHO1005_ResBody.ItemsBean> result( List<Shop> shopList){
        List<SHO1005_ResBody.ItemsBean> list=new ArrayList<SHO1005_ResBody.ItemsBean>();
        for(Shop shop:shopList){
            SHO1005_ResBody.ItemsBean itemsBean =new SHO1005_ResBody.ItemsBean();
            itemsBean.setShopId(shop.getId());
            itemsBean.setShopName(shop.getName());
            itemsBean.setShopFeatures(shop.getShop_info());
            itemsBean.setLogoUrl(shop.getShop_logo());
            itemsBean.setShopCommentStar(shop.getShop_star());
            itemsBean.setShopAdress(shop.getCity()+shop.getArea()+shop.getAddress());
            ShopClass shopClass=shopClassMapper.getShopClassByClassId(shop.getClass_id3()) ;
            itemsBean.setSaleType(shopClass.getClass_name());
            itemsBean.setSaleNum(shop.getNum());
            itemsBean.setAdvUrls(shop.getCuxiao_url());
            list.add(itemsBean);
        }

        return list;
    }



}
