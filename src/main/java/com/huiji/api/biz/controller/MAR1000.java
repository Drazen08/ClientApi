package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.HotShop;
import com.huiji.api.db.entity.Market;
import com.huiji.api.db.mapper.HotShopMapper;
import com.huiji.api.db.mapper.MarketMapper;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.MAR1000_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.MAR1000_ReqBody;
import com.huiji.api.msg.response.MAR1000_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.MAR1000_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingxiang on 2016/8/10.主题市场查询
 */
@RestController
public class MAR1000 extends AbstractBaseController<MAR1000_Req,MAR1000_ReqBody,MAR1000_Res,MAR1000_ResBody> {
    @Resource
    private MarketMapper marketMapper;

    @RequestMapping(URLPREFIX+"/MAR1000/*")

    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }


    @Override
    public boolean checkRequestBodyParam(MAR1000_Req mar1000_req) {
        return true;
    }

    @Override
    public MAR1000_Res getRes() {
        return new MAR1000_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<MAR1000_ReqBody> request, String uid) throws Exception {
        try {
            MAR1000_ReqBody mar1000_reqBody=request.getBodyObject();

            MAR1000_ResBody mar1000_resBody=new MAR1000_ResBody();
            List<Market> li=marketMapper.getmarkets(mar1000_reqBody.getCityId());
            List<MAR1000_ResBody.ItemsBean> list =new ArrayList<MAR1000_ResBody.ItemsBean>();

            /*
            "shopLogo": "url",
            "marketId": "编号",
            "marketName": "店铺名称",
            "marketDesc":"主题描述",
            "affiliatedPic":"附属图片（家电清凉节)"*/
            MAR1000_ResBody.ItemsBean itemsBean=null;
            for(Market market:li){
                itemsBean=new MAR1000_ResBody.ItemsBean();
                itemsBean.setMarketId(market.getId());
                itemsBean.setMarketName(market.getMarket_name());
                itemsBean.setMarketDesc(market.getMarket_desc());
                itemsBean.setMarketAdv(market.getMarket_adv());
                itemsBean.setAffiliatedPic(market.getAffiliated_pic());
                list.add(itemsBean);
            }
            mar1000_resBody.setItems(list);
            response.setBodyObject(mar1000_resBody);
            response.setResult(ResultCode.SUCCESS);

        }catch (Exception e){
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }
    }

    @Override
    public Class<MAR1000_Req> getReqType() {
        return MAR1000_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
