package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.Shop;
import com.huiji.api.db.entity.ShopClass;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.ShopClassMapper;
import com.huiji.api.db.mapper.ShopMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.SAR1001_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.SAR1001_ReqBody;
import com.huiji.api.msg.response.SAR1001_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.SAR1001_ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/4 0004.
 */
@RestController
public class SAR1001 extends AbstractBaseController<SAR1001_Req,SAR1001_ReqBody,SAR1001_Res,SAR1001_ResBody> {
   /* @Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private ShopMapper  shopMapper;
    @Resource
    private ShopClassMapper shopClassMapper;
    @RequestMapping(URLPREFIX + "/SAR1001/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(SAR1001_Req sar1001_req) {
        return true;
    }

    @Override
    public SAR1001_Res getRes() {
        return new SAR1001_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<SAR1001_ReqBody> request, String uid) throws Exception {
      try {
            int currentPage=request.getBodyObject().getCurrentPage();
            String searchContent=request.getBodyObject().getContent();
            searchContent=searchContent ==null?"":searchContent;
            searchContent="%"+searchContent+"%";
            System.out.println(searchContent);
            int searchType=request.getBodyObject().getType();//1:全部  2:人气  3:销量
            int ignore=(currentPage-1)*10;
            int show=currentPage*10;
            SAR1001_ResBody sar1001_resBody=new SAR1001_ResBody();
            String orderBy="";
            if(searchType==1||"".equals(searchContent)){
//                sar1001_resBody.setItems(result(shopMapper.getShopInfo(ignore, show, searchContent)));
//                sar1001_resBody.setCurrentPage(currentPage);
                orderBy="shop_star desc,num desc";
            }
            if(searchType==2){
//                sar1001_resBody.setItems(result(shopMapper.getShopInfoStar(ignore, show, searchContent)));
//                sar1001_resBody.setCurrentPage(currentPage);
                orderBy="shop_star desc";
            }
            if(searchType==3){
//                sar1001_resBody.setItems(result(shopMapper.getShopInfoNum(ignore, show, searchContent)));
//                sar1001_resBody.setCurrentPage(currentPage);
                orderBy="num desc";
            }
            sar1001_resBody.setItems(result(shopMapper.getShopInfoAll(ignore, show, orderBy,searchContent)));
            sar1001_resBody.setCurrentPage(currentPage);
            response.setBodyObject(sar1001_resBody);
            response.setResult(ResultCode.SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<SAR1001_Req> getReqType() {
        return SAR1001_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }

    public List<SAR1001_ResBody.ItemsBean> result( List<Shop> shopList){
        List<SAR1001_ResBody.ItemsBean> list=new ArrayList<SAR1001_ResBody.ItemsBean>();
        for(Shop shop:shopList){
            SAR1001_ResBody.ItemsBean itemsBean =new SAR1001_ResBody.ItemsBean();
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
