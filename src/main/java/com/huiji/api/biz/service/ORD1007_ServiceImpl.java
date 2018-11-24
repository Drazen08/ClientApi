package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.ORD1007_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1007_ReqBody;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1007_ResBody;
import com.huiji.api.util.ConvertAddressUtil;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.OrderCodeUtil;
import com.huiji.api.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ORD1007_ServiceImpl implements ORD1007_Service {
    @Resource
    private OrderTemplateMapper orderTemplateMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private ShopMapper shopMapper;
    @Resource
    private SellerAddressMapper sellerAddressMapper;
    @Resource
    private SubGoodsMapper subGoodsMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserAddressMapper userAddressMapper;
    @Resource
    private OrderAddressMapper orderAddressMapper;
    @Resource
    private OutTradeNoMapper outTradeNoMapper;
    @Resource
    private OrderPayLockMapper orderPayLockMapper;


    public ORD1007_ResBody executeService(IResponse response,IRequest<ORD1007_ReqBody> request,String uid,int adminOrderExpiredTime,int intentionalOrderExpiredTime) throws Exception{
        try {
            ORD1007_ResBody ord1007_resBody = new ORD1007_ResBody();
            Date date = new Date();
            String createDate = DateUtil.dateToString(date);
            String provisionalId = request.getBodyObject().getTemid();//临时表id
            Integer userAddressId = request.getBodyObject().getAddressId();//地址id
            Long balancePay = request.getBodyObject().getBalance();//余额支付多少钱
            Long realPay=request.getBodyObject().getPrice();//实际支付多少钱
            Long PostPrice=request.getBodyObject().getPostPrice();//邮费多少
            Long orderPrice=request.getBodyObject().getPaySale();//订单总价
            Integer payId=request.getBodyObject().getBuyTypeId();
            String userNote=request.getBodyObject().getNote();
            Integer userBuyNum=request.getBodyObject().getNum();
            Integer sendId=request.getBodyObject().getSendTypeId();
            String goodUrl=request.getBodyObject().getGoodUrl();
            String orderId= OrderCodeUtil.getOrderNo();//生成定单号
            String date1=DateUtil.dateToString2(new Date());
            String strDay=date1;
            String strMonth=date1.substring(4, 6);
            String strYear=date1.substring(0, 4);
            if(userAddressId==0||userAddressId==null){
                ord1007_resBody.setResult("-2");
                ord1007_resBody.setResultDesc("收货人地址不可为空");
                return ord1007_resBody;
            }
            //生成确定商品的主订单
            OrderTemplate orderTemplateSure = orderTemplateMapper.getSureGood(provisionalId,1);//临时表的确定商品

            Goods goods = goodsMapper.getGoodByGoodId(orderTemplateSure.getGood_id());
            if (goods == null) {
                ord1007_resBody.setResult("-1");
                ord1007_resBody.setResultDesc("此类商品已下架");
                return ord1007_resBody;
            }
            Order order=new Order();
            order.setOrder_id(orderId);
            order.setUid(uid);
            order.setType(10);//订单的总状态为1 用户已确认
            order.setSend_type(0);//订单的发货状态 为0  商家未发货
            order.setPay_type(0);//订单的付款状态  为0  用户未付款
            order.setTuitype(0);//订单的退货状态  为0  用户未曾退货
            order.setDelete_type(0);//订单的删除状态 为O 订单未曾删除过
            order.setType_desc("订单已确认，但未曾付款");
//            order.setUser_address_id(userAddressId);
            UserAddress userAddress=userAddressMapper.getUserAddressById(userAddressId);
            ConvertAddressUtil.convertAddress(orderId, userAddress, orderAddressMapper);
            Shop shop = shopMapper.getShopById(goods.getShopid());
//            SellerAddress sellerAddress= sellerAddressMapper.getSellerDufaultAddress(shop.getSeller_id());
            order.setSeller_address(shop.getAddress());
            order.setShop_id(shop.getId());
            order.setGoods_id(orderTemplateSure.getSub_good_id());
            order.setSeller_id(shop.getSeller_id());
            order.setGoods_url(goodUrl);
            order.setGoods_pid(orderTemplateSure.getGood_id());
            order.setPrice(orderPrice);
            order.setPostprice(PostPrice);
            order.setEndprice(0);
            order.setBalance(0);
            SubGoods subGoods = subGoodsMapper.getSubGoodById(orderTemplateSure.getSub_good_id());
            //System.out.println(subGoods.toString());
            if (subGoods == null) {
                ord1007_resBody.setResult("-2");
                ord1007_resBody.setResultDesc(orderTemplateSure.getGood_pro()+"此规格的确认购买商品已下架");
                return ord1007_resBody;
            }
            order.setGoodprice(orderTemplateSure.getCurrent_price());
            order.setCostprice(orderTemplateSure.getMarketPrice());
            order.setGoods_pro(orderTemplateSure.getGood_pro());
            order.setLeavewords(userNote);
            order.setNum(userBuyNum);
            order.setPid(null);
            order.setSendid(sendId);
            order.setPayid(payId);
            order.setCreate_time(createDate);
            order.setPay_time(null);
            order.setClosing_time(null);
            order.setPay_time(null);
            order.setPayback_time(null);
            order.setPay_expired_time(DateUtil.dateToString(new Date(date.getTime() + adminOrderExpiredTime * 60 * 1000)));
            order.setSend_time(null);
            order.setGetdell_time(null);
            order.setStr_day(strDay);
            order.setStr_month(strMonth);
            order.setStr_year(strYear);
            orderMapper.saveOrder(order);
            int primaryKey=order.getId();
            //String order_id, String out_trade_no, String sub_order_id, Integer type,
            // Date create_time, String str_day, String str_month, String str_year
            outTradeNoMapper.saveOutTradeNo(
                    new OutTradeNo(orderId, UUIDUtil.getUUID(),orderId,1,new Date(),strDay,strMonth,strYear)
            );
            //String order_id, Integer type, Date create_time
            orderPayLockMapper.saveOrderPayLock(
                    new OrderPayLock(orderId,0,new Date())
            );
            System.out.println("primaryKey:"+primaryKey);
            //意向购买的商品
            StringBuffer sb=new StringBuffer();
            String outTradeNo=UUIDUtil.getUUID();
            List<OrderTemplate> orderTemplateCoulds = orderTemplateMapper.getCouldGoods(provisionalId,1);
            Order order1=null;
            if(orderTemplateCoulds.size()!=0){
                for(OrderTemplate orderTemplate:orderTemplateCoulds){
                    String orderId1= OrderCodeUtil.getOrderNo();//生成定单号
                    order1=new Order();
                    order1.setOrder_id(orderId1);
                    order1.setUid(uid);
                    order1.setType(10);//订单的总状态为1 用户已确认
                    order1.setSend_type(0);//订单的发货状态 为0  商家未发货
                    order1.setPay_type(0);//订单的付款状态  为0  用户未付款
                    order1.setTuitype(0);//订单的退货状态  为0  用户未曾退货
                    order1.setDelete_type(0);//订单的删除状态 为O 订单未曾删除过
                    order1.setType_desc("订单已确认，但未曾付款");
    //                    order1.setUser_address_id(userAddressId);
                    ConvertAddressUtil.convertAddress(orderId1,userAddress,orderAddressMapper);
                    Shop shop1 = shopMapper.getShopById(goods.getShopid());
    //                    SellerAddress sellerAddress1= sellerAddressMapper.getSellerDufaultAddress(shop.getSeller_id());
                    order1.setSeller_address(shop.getAddress());
                    order1.setShop_id(shop1.getId());
                    order1.setGoods_id(orderTemplate.getSub_good_id());
                    order1.setGoods_url(goodUrl);
                    order1.setGoods_pid(orderTemplate.getGood_id());
                    order1.setPostprice(0);
                    order1.setEndprice(0);
                    order1.setBalance(0);
                    order1.setSeller_id(shop.getSeller_id());
                    SubGoods subGoods1 = subGoodsMapper.getSubGoodById(orderTemplate.getSub_good_id());
                    if (subGoods1 == null) {
                        SubGoods subGoods0= subGoodsMapper.getSubGoodById0(orderTemplate.getSub_good_id());
                        sb.append(orderTemplate.getGood_pro()+"规格的产品已下架;");
                        continue;
                    }
                    order1.setGoodprice(orderTemplate.getCurrent_price());
                    order1.setGoods_pro(orderTemplate.getGood_pro());
                    order1.setPrice(orderTemplate.getCurrent_price());
                    order1.setCostprice(orderTemplate.getMarketPrice());
                    order1.setLeavewords(userNote);
                    order1.setNum(1);
                    order1.setPid(orderId);
                    order1.setSendid(null);
                    order1.setPayid(null);
                    order1.setCreate_time(createDate);
                    order1.setPay_time(null);
                    order1.setClosing_time(null);
                    order1.setPayback_time(null);
                    order1.setPay_time(null);
                    order1.setPay_expired_time(DateUtil.dateToString(new Date(date.getTime() + intentionalOrderExpiredTime * 60 * 60 * 1000)));
                    order1.setSend_time(null);
                    order1.setGetdell_time(null);
                    order1.setStr_day(strDay);
                    order1.setStr_month(strMonth);
                    order1.setStr_year(strYear);
                    orderMapper.saveOrder(order1);
                    outTradeNoMapper.saveOutTradeNo(
                            new OutTradeNo(orderId, outTradeNo, orderId1, 2, new Date(), strDay, strMonth, strYear)
                    );
                    orderPayLockMapper.saveOrderPayLock(
                            new OrderPayLock(orderId1, 0, new Date())
                    );
                }
            }
//            orderTemplateMapper.updateState2(provisionalId);
            ord1007_resBody.setOrderId(orderId);
            ord1007_resBody.setResult("0");
            ord1007_resBody.setResultDesc(sb.length()==0?"订单确认成功":sb.toString());
            return ord1007_resBody;
        } catch (ParseException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
