package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.GoodProperty;
import com.huiji.api.db.entity.GoodSubProperty;
import com.huiji.api.db.entity.Order;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.*;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.ORD1000_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1000_ReqBody;
import com.huiji.api.msg.response.ORD1000_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1000_ResBody;

import com.huiji.api.util.OrderDescUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by Jingxiang on 2016/8/6.
 */
@RestController
public class ORD1000 extends AbstractBaseController<ORD1000_Req,ORD1000_ReqBody,ORD1000_Res,ORD1000_ResBody> {
//    @Autowired
//    private UserSessionMapper userSessionMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Resource
    private GoodEvaluateMapper goodEvaluateMapper;
    @Resource
    private GoodPropertyMappper goodPropertyMappper;
    @Resource
    private GoodSubPropertyMapper goodSubPropertyMapper;
    @Resource
    private SubGoodsMapper subGoodsMapper;
    @RequestMapping(URLPREFIX + "/ORD1000/*")

    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(ORD1000_Req ord1000_req) {
        return true;
    }

    @Override
    public ORD1000_Res getRes() {
        return new ORD1000_Res();
    }


    @Override
    public void execute(IResponse response, IRequest<ORD1000_ReqBody> request, String uid) throws Exception {
        try {
            String getsid = request.getSid();
            ORD1000_ReqBody ord1000_reqBody = request.getBodyObject();
            ORD1000_ResBody ord1000_resBody = new ORD1000_ResBody();
            // "type": "类型:1全部2待支付3待发货4待收货5待评价6退款"
            int type = ord1000_reqBody.getType();
            int page = ord1000_reqBody.getPageNow();
            int pages = (page - 1) * 10;
            int show = page * 10;
            String send_type=null;
            String tuitype=null;
            String pay_type=null;
            String typpe=null;
            if(type==1){
                typpe="("+"10,20,30,40,90"+")";
                tuitype="("+"0,10,20,30,40,45,50,60,90"+")";
                pay_type="("+"0,10,20,30,90"+")";
                send_type="("+"0,5,10,20"+")";
            }else if(type==2){
                typpe="("+"10"+")";
                tuitype="("+"0"+")";
                pay_type="("+"90,0"+")";
                send_type="("+"0"+")";
            }else if(type==3){
                typpe="("+"10"+")";
                tuitype="("+"0"+")";
                pay_type="("+"10,30"+")";
                send_type="("+"0,5"+")";
            }else if(type==4){
                typpe="("+"10"+")";
                tuitype="("+"0"+")";
                pay_type="("+"10"+")";
                send_type="("+"10"+")";
            }else if(type==5){
                typpe="("+"20,30"+")";
                tuitype="("+"10,20,30,40,45,50,60,90"+")";
                pay_type="("+"10"+")";
                send_type="("+"20"+")";
            }
            System.out.println("type:"+type+"\n\rtype:"+typpe+"\n\rpage:"+page+"\n\rshow:"+show+"\n\ruid:"+uid);
            List<ORD1000_ResBody.ItemsBean> itemsBeans = new ArrayList<ORD1000_ResBody.ItemsBean>();
            List<Order> orders = orderMapper.searchOrdList(uid,typpe,tuitype,pay_type,send_type,pages, show);
            for (Order order : orders) {
                //商铺名称
                String shopname = orderMapper.shopname(order.getShop_id());
                //商品规格
                String goodspec=orderMapper.goodDesc(order.getGoods_id());
                String goodspec1=order.getGoods_pro(); //goodspec.replace("#", " 、");
                //商品描述
                String goodname=orderMapper.goodsname(order.getGoods_pid());
                ORD1000_ResBody.ItemsBean itemsBean = new ORD1000_ResBody.ItemsBean();
                int a=order.getPay_type();
                int b=order.getSend_type();
                int c=order.getTuitype();
                int d=order.getType();

                int f= order.getPid()==null?1:2;
                int satae=(int)OrderDescUtil.generateStatus(a,b,c,d,f).get("state");
                String desc=(String)OrderDescUtil.generateStatus(a,b,c,d,f).get("desc");

                if(order.getPid()==null){//是主副订单的判断
                    itemsBean.setFlag("true");//jp

                    //判断是否是普通的订单还是带有意向订单的主订单（因为两者的pid都为null）
                    int num=orderMapper.getNum(uid,String.valueOf(order.getOrder_id()));
                    itemsBean.setPuFlag(num==0?"true":"false");
                    itemsBean.setpState("");
                }else{//如果是子订单
                    //查出主订单的状态
                    Order order1=orderMapper.getOrderByOrderId(order.getPid());
                    Map<String,Object> map=OrderDescUtil.generateStatus(order1.getPay_type(),order1.getSend_type(),order1.getTuitype(),order1.getType(),1);
                    int state=(int)map.get("state");
                    if(state!=-1){
                        itemsBean.setpState(String.valueOf(state));
                    }
//                    boolean getSubOrderPay(order1)
                    itemsBean.setFlag("false");
                    itemsBean.setPuFlag("false");
                }
                /*
                private String pstate;
                private String goodId;
                private String shopId;
                private String puFlag;
                 */
                itemsBean.setGoodId(String.valueOf(order.getGoods_id()));
                itemsBean.setShopId(String.valueOf(order.getShop_id()));
                itemsBean.setPid(order.getPid());
                itemsBean.setTime(String.valueOf(order.getCreate_time()));
                itemsBean.setLogo(order.getGoods_url());
                itemsBean.setGoodprice(order.getPrice());//订单总价
                itemsBean.setCostprice(order.getCostprice());//商品的市场价
                itemsBean.setPingtaiPrice(order.getGoodprice());//商品的平台价
                itemsBean.setPostPrice(order.getPostprice());//邮费
                itemsBean.setNum(order.getNum());
                itemsBean.setState(satae);
                itemsBean.setStateDesc(desc);
                itemsBean.setShopName(shopname);
                itemsBean.setDesc(goodname);
                itemsBean.setGoodsSpec(goodspec1);
                itemsBean.setOrderId(order.getOrder_id());


                itemsBeans.add(itemsBean);


            }
            ord1000_resBody.setPageNow(page);
            ord1000_resBody.setItems(itemsBeans);
            response.setBodyObject(ord1000_resBody);
            response.setResult(ResultCode.SUCCESS);

        }catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;

        }
    }

    @Override
    public Class<ORD1000_Req> getReqType() {
        return ORD1000_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
