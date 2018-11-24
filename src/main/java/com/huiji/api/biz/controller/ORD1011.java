package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.ORD1011_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1011_ReqBody;
import com.huiji.api.msg.response.ORD1011_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1011_ResBody;
import com.huiji.api.util.OrderDescUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
@RestController
public class ORD1011 extends AbstractBaseController<ORD1011_Req, ORD1011_ReqBody, ORD1011_Res, ORD1011_ResBody> {
    /*    @Resource
        private UserSessionMapper userSessionMapper;*/
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private SubGoodsMapper subGoodsMapper;
    @Resource
    private OrderAddressMapper orderAddressMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private ShopMapper shopMapper;


    @RequestMapping(URLPREFIX + "/ORD1011/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(ORD1011_Req ord1011_req) {
        return true;
    }

    @Override
    public ORD1011_Res getRes() {
        return new ORD1011_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1011_ReqBody> request, String uid) throws Exception {
        try {
           /* UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            ORD1011_ResBody ord1011_resBody = new ORD1011_ResBody();
            String orderId = request.getBodyObject().getOrderid();
            Order order = orderMapper.getOrderByOrderId(orderId);
//            if(order.getType()==10&&order.getPay_type()==0){//如果被点击的订单处于用户已确定但用户未付款时 此订单的商品已下架
//                SubGoods subGoods= subGoodsMapper.getSubGoodById(order.getGoods_id());
//                if(subGoods==null){
//                    SubGoods subGoods0= subGoodsMapper.getSubGoodById0(order.getGoods_id());
//                    ord1011_resBody.setResult("-1");
//                    ord1011_resBody.setResultDesc((subGoods0.getGoods_spec_desc().replaceAll("#", "   ") + "确定购买的产品已下架"));
//                    orderMapper.updateStatusForDeleteType(orderId);
//                    response.setBodyObject(ord1011_resBody);
//                    response.setResult(ResultCode.SUCCESS);
//                    return;
//                }
//            }
//            //
//            if(order.getPid()!=null){//如果此订单不是主订单就找到相应的主订单
//                orderId=order.getPid();
//                order=orderMapper.getOrderByOrderId(orderId);
//            }
            //买家地址
            OrderAddress userAddress = orderAddressMapper.getOrderAddressByOrderId(orderId);
            ord1011_resBody.setAddress("" + userAddress.getProvince() + userAddress.getCity() + userAddress.getArea() + userAddress.getStreet() + userAddress.getAddress());
            ord1011_resBody.setPersion(userAddress.getName());
            ord1011_resBody.setPhone(userAddress.getPhone());
            ord1011_resBody.setShopId(String.valueOf(order.getShop_id()));
            ord1011_resBody.setNote(order.getLeavewords());
            ord1011_resBody.setPaySale(order.getEndprice());
            ord1011_resBody.setYue(order.getBalance());
            ord1011_resBody.setPostPrice(order.getPostprice());
            ord1011_resBody.setOrderPrice(order.getPrice());
            ord1011_resBody.setOrderId(order.getOrder_id());
            ord1011_resBody.setCreateTime(String.valueOf(order.getCreate_time().replace(".0", "")));
            ord1011_resBody.setPayTime(String.valueOf(order.getPay_time() == null ? "" : order.getPay_time().replace(".0", "")));
            ord1011_resBody.setSendTime(String.valueOf(order.getSend_time() == null ? "" : order.getSend_time().replace(".0", "")));
            ord1011_resBody.setGetdellTime(String.valueOf(order.getGetdell_time() == null ? "" : order.getGetdell_time().replace(".0", "")));
            Shop shop = shopMapper.getShopById(order.getShop_id());
            ord1011_resBody.setSellerPhone(shop.getPhone());
            ORD1011_ResBody.ReturnTableBean returnTableBean = new ORD1011_ResBody.ReturnTableBean();
            ORD1011_ResBody.ReturnTableBean.MakeSureOrderBean makeSureOrderBean = new ORD1011_ResBody.ReturnTableBean.MakeSureOrderBean();
            makeSureOrderBean.setOrderId(orderId);
            int type = order.getPid() == null ? 1 : 2;
            Map<String, Object> map = OrderDescUtil.generateStatus(order.getPay_type(), order.getSend_type(), order.getTuitype(), order.getType(), type);//a 支付  b 发货   c 退货   d 主状态
            int state = (int) map.get("state");
            String desc = (String) map.get("desc");
            if (state != -1) {
                makeSureOrderBean.setOrderType(state);
                makeSureOrderBean.setOrderTypeDesc(desc);
            }
            boolean aOrderFlag=state==60?true:false;
            makeSureOrderBean.setGoodsId(Integer.valueOf(order.getGoods_id()));
            makeSureOrderBean.setPrice(order.getGoodprice());
            makeSureOrderBean.setMarketPrice(order.getCostprice());
            makeSureOrderBean.setBuyNum(order.getNum());
            makeSureOrderBean.setGoodurl(order.getGoods_url());
            Goods good = goodsMapper.getGoodById(order.getGoods_pid());
            makeSureOrderBean.setGoodsName(good.getGoodsname());
//            SubGoods subGoods=subGoodsMapper.getSubGood(Integer.valueOf(order.getGoods_id()));
            makeSureOrderBean.setWillBuy(order.getGoods_pro());
            makeSureOrderBean.setShopName(shop.getName());
            returnTableBean.setAdminOrder(makeSureOrderBean);
            //附属订单的
            boolean yiOrdFlag = true;
            boolean yiPayFlag=true;
            List<ORD1011_ResBody.ReturnTableBean.CouldBuyBean> couldBuyBeanList = new ArrayList<ORD1011_ResBody.ReturnTableBean.CouldBuyBean>();
            List<Order> subOrders = orderMapper.getSubOrderByOrderId(order.getOrder_id());
            if (subOrders.size() != 0) {
                for (Order order1 : subOrders) {
                    ORD1011_ResBody.ReturnTableBean.CouldBuyBean couldBuyBean = new ORD1011_ResBody.ReturnTableBean.CouldBuyBean();
                    ORD1011_ResBody.ReturnTableBean.CouldBuyBean.OrderBean orderBean = new ORD1011_ResBody.ReturnTableBean.CouldBuyBean.OrderBean();
                    orderBean.setOrderId(order1.getOrder_id());
                    Map<String, Object> map1 = OrderDescUtil.generateStatus(order1.getPay_type(), order1.getSend_type(), order1.getTuitype(), order1.getType(), 2);//a 支付  b 发货   c 退货   d 主状态
                    int state1 = (int) map1.get("state");
                    String desc1 = (String) map1.get("desc");
                    if (state1 != -1) {
                        orderBean.setOrderType(state1);
                        orderBean.setOrderTypeDesc(desc1);
                    }

                    orderBean.setCreate_time(order1.getCreate_time().replace(".0", ""));
                    orderBean.setPay_time(order1.getPay_time() == null ? "" : order1.getPay_time().replace(".0", ""));
                    orderBean.setPayback_time(order1.getPayback_time() == null ? "" : order1.getPayback_time().replace(".0", ""));
                    orderBean.setSend_time(order1.getSend_time() == null ? "" : order1.getSend_time().replace(".0", ""));
                    orderBean.setGetdell_time(order1.getGetdell_time() == null ? "" : order1.getGetdell_time().replace(".0", ""));
                    orderBean.setPrice(String.valueOf(order1.getGoodprice()));
                    orderBean.setMarketPrice(String.valueOf(order1.getCostprice()));
                    orderBean.setBuyNum(String.valueOf(order1.getNum()));
                    orderBean.setGoodurl(order1.getGoods_url());
                    orderBean.setNote(order1.getLeavewords());
                    orderBean.setPaySale(order1.getEndprice());
                    orderBean.setYue(order1.getBalance());
                    orderBean.setPostPrice(order1.getPostprice());
                    orderBean.setOrderPrice(order1.getPrice());
                    orderBean.setSellerPhone(shop.getPhone());
                    couldBuyBean.setOrderBean(orderBean);
                    Goods good1 = goodsMapper.getGoodById(order1.getGoods_pid());
                    couldBuyBean.setGoodsName(good1.getGoodsname());
//                    SubGoods subGoods1 = subGoodsMapper.getSubGood(Integer.valueOf(order1.getGoods_id()));
                    couldBuyBean.setWillBuy(order1.getGoods_pro());
                    couldBuyBeanList.add(couldBuyBean);
                }
            } else {
                yiOrdFlag = false;
            }
            if (subOrders.size() != 0) {
                for (Order order1 : subOrders) {
                    Map<String, Object> map1 = OrderDescUtil.generateStatus(order1.getPay_type(), order1.getSend_type(), order1.getTuitype(), order1.getType(), 2);//a 支付  b 发货   c 退货   d 主状态
                    int state1 = (int) map1.get("state");
                    yiOrdFlag=(state1!=10?false:true);
                    if (!yiOrdFlag)
                        break;
                }
            }
            ord1011_resBody.setYiPayFlag(aOrderFlag&&yiOrdFlag?true:false);
            returnTableBean.setCouldBuy(couldBuyBeanList);
            ord1011_resBody.setReturnTable(returnTableBean);
            //主订单其他信息
        /*
        "note": "买家备注",
    "paySale":"shiji支付金额",
    "yue":"余额支付",
    "postPrice":"邮费",
    "orderPrice":"订单总价",
    "orderId":"",
    "createTime":"",
    "payTime":"",
    "sendTime":"",
    "getdellTime":"成交时间",
    "sellerPhone":"卖家电话"
         */

            response.setBodyObject(ord1011_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }


    }

    @Override
    public Class<ORD1011_Req> getReqType() {
        return ORD1011_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }

}
