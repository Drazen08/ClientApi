package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.ORD1009_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1009_ReqBody;
import com.huiji.api.msg.response.ORD1009_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1009_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/7 0007.
 */
@RestController
public class ORD1009 extends AbstractBaseController<ORD1009_Req, ORD1009_ReqBody, ORD1009_Res, ORD1009_ResBody> {
/*    @Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private UserAddressMapper userAddressMapper;
    @Resource
    private OrderTemplateMapper orderTemplateMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private ShopMapper shopMapper;
    @Resource
    private SubGoodsMapper subGoodsMapper;
    @Resource
    private PayMapper payMapper;
    @Resource
    private PostMapper postMapper;
    @Resource
    private UserAccountMapper userAccountMapper;

    @RequestMapping(URLPREFIX + "/ORD1009/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(ORD1009_Req ord1009_req) {
        return true;
    }

    @Override
    public ORD1009_Res getRes() {
        return new ORD1009_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1009_ReqBody> request, String uid) throws Exception {
        try {
          /*  UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            ORD1009_ResBody ord1009_resBody = new ORD1009_ResBody();
            //收货人的地址
            UserAddress userAddress = userAddressMapper.getUserDufaultAddress(uid);
            ORD1009_ResBody.AddressesBean addressesBean = new ORD1009_ResBody.AddressesBean();
            if (userAddress != null) {
                addressesBean.setAddressid(userAddress.getId());
                addressesBean.setAddress(userAddress.getProvince() + "" + userAddress.getCity() + "" + userAddress.getArea() + ""+userAddress.getStreet()+"" + userAddress.getAddress());
                addressesBean.setName(userAddress.getName());
                addressesBean.setPhone(userAddress.getPhone());
            }else{
                List<UserAddress> userAddressList = userAddressMapper.getUserAddress(uid);
                if(userAddressList.size()!=0) {
                    addressesBean.setAddressid(userAddressList.get(0).getId());
                    addressesBean.setAddress(userAddressList.get(0).getProvince() + "" + userAddressList.get(0).getCity() + "" + userAddressList.get(0).getArea() + "" + userAddressList.get(0).getStreet() + "" + userAddressList.get(0).getAddress());
                    addressesBean.setName(userAddressList.get(0).getName());
                    addressesBean.setPhone(userAddressList.get(0).getPhone());
                }else {
                    addressesBean.setAddress("");
                }
            }
            ord1009_resBody.setAddresses(addressesBean);
            //获取临时表中确定购买和[意向购买] 的商品
            //先获取商品的共性
            String provisionalId = request.getBodyObject().getProvisionalId();
            ORD1009_ResBody.ReturnTableBean returnTableBean = new ORD1009_ResBody.ReturnTableBean();
            OrderTemplate orderTemplateSure = orderTemplateMapper.getSureGood(provisionalId,0);
//            System.out.println(orderTemplateSure.getCreate_time().replace(".0",""));
            Goods goods = goodsMapper.getGoodByGoodId(orderTemplateSure.getGood_id());
            if (goods == null) {
                ord1009_resBody.setResult("-1");
                ord1009_resBody.setResultDesc(orderTemplateSure.getGood_pro()+"此类商品已下架");
                response.setBodyObject(ord1009_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }
            ORD1009_ResBody.ReturnTableBean.GoodPublicPropertyBean goodPublicPropertyBean = new ORD1009_ResBody.ReturnTableBean.GoodPublicPropertyBean();
            goodPublicPropertyBean.setGoodId(goods.getId());
            goodPublicPropertyBean.setGoodName(goods.getGoodsname());
            goodPublicPropertyBean.setImages(goods.getImages().split(";")[0]);
            goodPublicPropertyBean.setShopId(goods.getShopid());
            Shop shop = shopMapper.getShopById(goods.getShopid());
            goodPublicPropertyBean.setShopName(shop.getName());
            returnTableBean.setGoodPublicProperty(goodPublicPropertyBean);
            //获取确定商品的价格等
            ORD1009_ResBody.ReturnTableBean.MakeSureBean makeSureBean = new ORD1009_ResBody.ReturnTableBean.MakeSureBean();
            makeSureBean.setShopId(orderTemplateSure.getShop_id());
            makeSureBean.setGoodsId(orderTemplateSure.getGood_id());
            makeSureBean.setSubid(orderTemplateSure.getSub_good_id());
            makeSureBean.setBuyNum(orderTemplateSure.getBuy_num());
            SubGoods subGoods = subGoodsMapper.getSubGoodById(orderTemplateSure.getSub_good_id());
            if (subGoods == null) {
                ord1009_resBody.setResult("-2");
                ord1009_resBody.setResultDesc(orderTemplateSure.getGood_pro()+"此规格的确认购买商品已下架");
                response.setBodyObject(ord1009_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }
            makeSureBean.setPrice(orderTemplateSure.getCurrent_price());
            makeSureBean.setMarketPrice(orderTemplateSure.getMarketPrice());
            makeSureBean.setSpec(orderTemplateSure.getGood_pro());
            returnTableBean.setMakeSure(makeSureBean);
            //意向购买的商品
            List<OrderTemplate> orderTemplateCoulds = orderTemplateMapper.getCouldGoods(provisionalId,0);
            if(orderTemplateCoulds.size()==0){
                returnTableBean.setCouldBuy(new ArrayList<ORD1009_ResBody.ReturnTableBean.CouldBuyBean>());
            }else {
                List<ORD1009_ResBody.ReturnTableBean.CouldBuyBean> couldBuyBeans = new ArrayList<ORD1009_ResBody.ReturnTableBean.CouldBuyBean>();
                for (OrderTemplate orderTemplate : orderTemplateCoulds) {
                    ORD1009_ResBody.ReturnTableBean.CouldBuyBean couldBuyBean = new ORD1009_ResBody.ReturnTableBean.CouldBuyBean();
                    couldBuyBean.setId(orderTemplate.getId());
                    couldBuyBean.setSubid(orderTemplate.getSub_good_id());
                    couldBuyBean.setShopId(orderTemplate.getShop_id());
                    couldBuyBean.setBuyNum(orderTemplate.getBuy_num());
                    couldBuyBean.setGoodsId(orderTemplate.getGood_id());
                    couldBuyBean.setGoodName(goods.getGoodsname());
                    couldBuyBean.setImage(goods.getImages().split(";")[0]);
                    SubGoods subCouldGoods = subGoodsMapper.getSubGoodById(orderTemplate.getSub_good_id());
                    if (subCouldGoods == null) {
                        couldBuyBean.setSpec(orderTemplate.getGood_pro()+"此规格商品已下架");
                    } else {
                        couldBuyBean.setSpec(orderTemplate.getGood_pro());
                        couldBuyBean.setPrice(orderTemplate.getCurrent_price());
                        couldBuyBean.setMarketPrice(orderTemplate.getMarketPrice());
                    }
                    couldBuyBeans.add(couldBuyBean);
                }
                returnTableBean.setCouldBuy(couldBuyBeans);
            }
            ord1009_resBody.setReturnTable(returnTableBean);
            //pay
            List<Pay> pays=payMapper.getPays();
            ord1009_resBody.setPay(pays);
            //post
            String bound="";
            if(goods.getPostpower()==1) {
                bound="1=1";
            }else if(goods.getPostpower()==2){
                bound="id=2";
            }else if(goods.getPostpower()==3){
                bound="id=1";
            }
            List<Post> posts = postMapper.getPosts(bound);
            ord1009_resBody.setPost(posts);
            //balance
            List<UserAccount> userAccounts=userAccountMapper.getBalance1(uid);
            Long money=0L;
            if(userAccounts.size()!=0) {
                for (UserAccount userAccount : userAccounts) {
                    money += userAccount.getBalance();
                }
            }
            ord1009_resBody.setBalance(money);
            ord1009_resBody.setPostPrice(orderTemplateSure.getPostPrice());
            ord1009_resBody.setTemid(provisionalId);
            orderTemplateMapper.updateState(provisionalId);
            response.setBodyObject(ord1009_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<ORD1009_Req> getReqType() {
        return ORD1009_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
