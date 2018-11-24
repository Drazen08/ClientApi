package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.Goods;
import com.huiji.api.db.entity.Shop;
import com.huiji.api.db.entity.ShopEvalute;
import com.huiji.api.db.mapper.GoodsMapper;
import com.huiji.api.db.mapper.ShopClassMapper;
import com.huiji.api.db.mapper.ShopEvaluteMapper;
import com.huiji.api.db.mapper.ShopMapper;
import com.huiji.api.msg.request.DIC1003_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.DIC1003_ReqBody;
import com.huiji.api.msg.response.DIC1003_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.DIC1003_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingxiang on 2016/8/14.点击进入导航
 */
@RestController
public class DIC1003  extends AbstractBaseController<DIC1003_Req,DIC1003_ReqBody,DIC1003_Res,DIC1003_ResBody> {
    @Resource
    private ShopMapper shopMapper;
    @Resource
    private ShopEvaluteMapper shopEvaluteMapper;
    @Resource
    private ShopClassMapper shopClassMapper;

    @RequestMapping(URLPREFIX+"/DIC1003/*")

   @Override
   protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
       return super.v(requestMsg, httpServletRequest);
   }
    @Override
    public boolean checkRequestBodyParam(DIC1003_Req dic1003_req) {
        return true;
    }

    @Override
    public DIC1003_Res getRes() {
        return new DIC1003_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<DIC1003_ReqBody> request, String uid) throws Exception {
        try {
            DIC1003_ReqBody dic1003_reqBody=request.getBodyObject();
            DIC1003_ResBody dic1003_resBody=new DIC1003_ResBody();
            int page=dic1003_reqBody.getPagenow();
            int pages=(page-1)*10;
            int show=page*10;
            int type=dic1003_reqBody.getType();
            String orderby=null;
            //"type":"1人气/2销量",
            if(type==0){
                orderby="listener_num";
            }else if(type==1){
                orderby="listener_num";
            }else if(type==2){
                orderby="num";
            }


            List<Shop> li=shopMapper.ShouyeDianji(dic1003_reqBody.getNavId(),orderby,pages,show);
            List<DIC1003_ResBody.ItemsBean> list=new ArrayList<DIC1003_ResBody.ItemsBean>();
            for (Shop shop:li){
                String thirdclass=shopClassMapper.getshopClass(shop.getClass_id3());
                Integer shopStar=shopEvaluteMapper.shopStar(shop.getId());
                DIC1003_ResBody.ItemsBean itemsBean=new DIC1003_ResBody.ItemsBean();
                itemsBean.setShopScore(shopStar);
                itemsBean.setShopclass(thirdclass);
                itemsBean.setShopId(shop.getId());
                itemsBean.setShopName(shop.getName());
                itemsBean.setShopLogo(shop.getShop_logo());
                itemsBean.setShopUrl(shop.getCuxiao_url());
                itemsBean.setSellNum(shop.getNum());
                list.add(itemsBean);
            }
            dic1003_resBody.setClassName(shopClassMapper.getshopClass(dic1003_reqBody.getNavId()));
            dic1003_resBody.setItems(list);
            dic1003_resBody.setResult("0");
            dic1003_resBody.setResultDesc("操作成功");
            response.setBodyObject(dic1003_resBody);
            response.setResult(ResultCode.SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }






    }

    @Override
    public Class<DIC1003_Req> getReqType() {
        return DIC1003_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
