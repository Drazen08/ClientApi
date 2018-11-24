package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.msg.request.GOO1000_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.Goo1000_ReqBody;
import com.huiji.api.msg.response.GOO1000_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.GOO1000_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/5 0005.
 */
@RestController
public class GOO1000 extends AbstractBaseController<GOO1000_Req,Goo1000_ReqBody,GOO1000_Res,GOO1000_ResBody> {

    @Resource
    private UserSessionMapper userSessionMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private ShopMapper shopMapper;
    @Resource
    private GoodEvaluateMapper goodEvaluateMapper;
    @Resource
    private GoodPropertyMappper goodPropertyMappper;
    @Resource
    private GoodSubPropertyMapper goodSubPropertyMapper;
    @Resource
    private SubGoodsMapper subGoodsMapper;
    @Resource
    private SelectPorpertyMapper selectPorpertyMapper;
    @Resource
    private SelectSubPropertyMapper selectSubPropertyMapper;

    public GOO1000() {
    }

    @RequestMapping(URLPREFIX + "/GOO1000/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }


    @Override
    public boolean checkRequestBodyParam(GOO1000_Req GOO1000_req) {
        return true;
    }

    @Override
    public GOO1000_Res getRes() {
        return new GOO1000_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<Goo1000_ReqBody> request, String uid) throws Exception {
        try {
           /* UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            Goods goods= goodsMapper.getGoodByGoodId(request.getBodyObject().getGoodId());
            /*
             private int shopId;
    private int goodId;
    private String shopurl;
    private String shopName;
    private int shopnum;
    private int scrs;
    private int sendType;

             */
            GOO1000_ResBody  goo1000_resBody=new GOO1000_ResBody();
            goo1000_resBody.setGoodId(goods.getId());
            goo1000_resBody.setShopId(goods.getShopid());
            Shop shop=shopMapper.getShopById(goods.getShopid());
            goo1000_resBody.setShopurl(shop.getShop_logo());
            goo1000_resBody.setShopName(shop.getName());
            goo1000_resBody.setShopnum(goodsMapper.getShopGoodsNum(shop.getId()));
            goo1000_resBody.setScrs(shop.getListener_num());//收藏就是关注
            goo1000_resBody.setSendType(goods.getPostpower());
            /*
            private String goodName;
    private Long goodPrice;
    private Long discountPrice;
    private int salesNum;
    private Long postCost;
    private String shopAddress;
    private String urlGoods;
    private String bigImages;
    private List<GoodsStarBean> goodsStar;
    private List<GoodSpecBean> goodSpec;
    private List<PriceBean> price;
             */
            goo1000_resBody.setGoodName(goods.getGoodsname());
            goo1000_resBody.setGoodPrice(goods.getPrice());
            goo1000_resBody.setDiscountPrice(goods.getPingtaiprice());
            goo1000_resBody.setSalesNum(goods.getNum());
            goo1000_resBody.setPostCost(goods.getPostcost());
            goo1000_resBody.setShopAddress(shop.getCity()+shop.getArea());
            goo1000_resBody.setUrlGoods(goods.getGoodsurl());
            goo1000_resBody.setBigImages(goods.getImages());
            //商品评价
            List<GoodEvaluate> goodEvaluates=goodEvaluateMapper.getGoodEvaluatesByGoodId(goods.getId());
            List<GOO1000_ResBody.GoodsStarBean> goodsStarBeans=new ArrayList<GOO1000_ResBody.GoodsStarBean>();
            GOO1000_ResBody.GoodsStarBean goodsStarBean=null;
            for(GoodEvaluate goodEvaluate:goodEvaluates){
                goodsStarBean=new GOO1000_ResBody.GoodsStarBean();
                goodsStarBean.setEvaluateId(goodEvaluate.getId());
                goodsStarBean.setEvaluateStar(goodEvaluate.getGood_star());
                goodsStarBean.setEvaluateContent(goodEvaluate.getGood_content());
                goodsStarBeans.add(goodsStarBean);
            }
            goo1000_resBody.setGoodsStar(goodsStarBeans);
            //规格h
           List<SelectPorperty> goodPropertys=selectPorpertyMapper.getGoodPropertysByGoodId(String.valueOf(request.getBodyObject().getGoodId()));
            List<GOO1000_ResBody.GoodSpecBean> goodSpecBeans=new ArrayList<GOO1000_ResBody.GoodSpecBean>();
            GOO1000_ResBody.GoodSpecBean goodSpecBean=null;
            List<SelectSubProperty> goodSubPropertys=null;
            List<GOO1000_ResBody.GoodSpecBean.ItemBean> itemBeans=null;
            GOO1000_ResBody.GoodSpecBean.ItemBean itemBean=null;
            for(SelectPorperty goodProperty:goodPropertys){
                goodSpecBean=new GOO1000_ResBody.GoodSpecBean();
                goodSpecBean.setId(goodProperty.getPro_en_desc());
                goodSpecBean.setDesc(goodProperty.getPro_ch_desc());
                goodSubPropertys= selectSubPropertyMapper.getGoodSubPropertysByProprytyId(String.valueOf(goodProperty.getId()));
                itemBeans=new ArrayList<GOO1000_ResBody.GoodSpecBean.ItemBean>();
                for(SelectSubProperty goodSubProperty:goodSubPropertys){
                    itemBean=new GOO1000_ResBody.GoodSpecBean.ItemBean();
                    itemBean.setId(goodSubProperty.getPro_id());
                    itemBean.setDesc(goodSubProperty.getSub_pro_desc());
                    itemBeans.add(itemBean);
                }

                goodSpecBean.setItem(itemBeans);
                goodSpecBeans.add(goodSpecBean);
            }
            goo1000_resBody.setGoodSpec(goodSpecBeans);
            //每个规格不同的价格就是每个子商品的id price 等
            List<SubGoods> subGoods= subGoodsMapper.getSubGoodsByGoodId(String.valueOf(goods.getId()));
            List<GOO1000_ResBody.PriceBean>  priceBeans=new ArrayList<GOO1000_ResBody.PriceBean>();
            GOO1000_ResBody.PriceBean priceBean=null;
            for(SubGoods subGoods1:subGoods){
                priceBean=new GOO1000_ResBody.PriceBean();
                priceBean.setId(subGoods1.getId());
                priceBean.setKey(subGoods1.getGoods_spec());
                priceBean.setValue(subGoods1.getPrice());
                priceBean.setGoodPro(subGoods1.getGoods_spec_desc().replace("#", " "));
                priceBean.setMarketPrice(subGoods1.getMarket_Price());
                priceBeans.add(priceBean);
            }



            goo1000_resBody.setPrice(priceBeans);
            response.setBodyObject(goo1000_resBody);
            response.setResult(ResultCode.SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<GOO1000_Req> getReqType() {
        return GOO1000_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
