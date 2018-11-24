package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.ORD1008_Service;
import com.huiji.api.db.entity.OrderTemplate;
import com.huiji.api.db.mapper.OrderTemplateMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1008_ReqBody;
import com.huiji.api.msg.response.body.ORD1008_ResBody;
import com.huiji.api.util.DateUtil;
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
public class ORD1008_ServiceImpl implements ORD1008_Service {

    @Resource
    private OrderTemplateMapper orderTemplateMapper;

    public ORD1008_ResBody executeService(IRequest<ORD1008_ReqBody> request) throws Exception{
        try {
            ORD1008_ResBody ord1008_resBody=new ORD1008_ResBody();
            //que ding gou mai de shang pin
            String date= DateUtil.dateToString(new Date(System.currentTimeMillis()));
            String templateId= UUIDUtil.getUUID();
            Long postPrice=request.getBodyObject().getPostPrice();
            int shopId=request.getBodyObject().getMakeSure().getShopId();
            int goodId=request.getBodyObject().getMakeSure().getGoodsId();
            int subGoodId=request.getBodyObject().getMakeSure().getSubid();
            int byNum=request.getBodyObject().getMakeSure().getBuyNum();
            Long currentPrice=request.getBodyObject().getMakeSure().getCurrentPrice();
            Long marketPrice=request.getBodyObject().getMakeSure().getMarketPrice();
            String AgoodPro=request.getBodyObject().getMakeSure().getGoodPro();
            OrderTemplate orderTemplate=new OrderTemplate(templateId,shopId,goodId,subGoodId,AgoodPro,byNum,currentPrice,marketPrice,postPrice,null,null,0,date);
            orderTemplateMapper.saveOrderTemplate(orderTemplate);
            int pid=orderTemplate.getId();
            //意向购买的商品
            if(request.getBodyObject().getCouldBuy().size()!=0){
                List<ORD1008_ReqBody.CouldBuyBean> CouldBuyBeans=request.getBodyObject().getCouldBuy();
                for(ORD1008_ReqBody.CouldBuyBean couldBuyBean:CouldBuyBeans){
                    int couldGoodId=couldBuyBean.getGoodsId();//商品的id
                    int couldSubGoodId=couldBuyBean.getSubid();
                    int couldByNum=couldBuyBean.getBuyNum();
                    Long couldCurrentPrice=couldBuyBean.getPrice();
                    String YgoodPro=couldBuyBean.getGoodPro();
                    long YmarketPrice=couldBuyBean.getMarketPrice();
                    orderTemplateMapper.saveOrderTemplate(new OrderTemplate(templateId,shopId,couldGoodId,couldSubGoodId,YgoodPro,couldByNum,couldCurrentPrice,YmarketPrice,0l,pid,null,0,date));
                }
            }
            ord1008_resBody.setProvisionalId(templateId);
            ord1008_resBody.setResult("0");
            ord1008_resBody.setResultDesc("Success");
            return ord1008_resBody;
        } catch (ParseException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
