package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.HotShop;
import com.huiji.api.db.entity.Shop;
import com.huiji.api.db.mapper.HotShopMapper;
import com.huiji.api.db.mapper.ShopClassMapper;
import com.huiji.api.db.mapper.ShopMapper;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.SHO1000_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.SHO1000_ReqBody;
import com.huiji.api.msg.response.SHO1000_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.SHO1000_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingxiang on 2016/8/8.
 */
@RestController
public class SHO1000 extends AbstractBaseController<SHO1000_Req,SHO1000_ReqBody,SHO1000_Res,SHO1000_ResBody> {
    @Resource
    private HotShopMapper hotShopMapper;


    @RequestMapping(URLPREFIX + "/SHO1000/*")

    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(SHO1000_Req sho1000_req) {
        return true;
    }

    @Override
    public SHO1000_Res getRes() {
        return new SHO1000_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<SHO1000_ReqBody> request, String uid) throws Exception {
        try {
            SHO1000_ReqBody sho1000_reqBody=request.getBodyObject();
            SHO1000_ResBody sho1000_resBody=new SHO1000_ResBody();
            List<HotShop> li=hotShopMapper.gethotshop(sho1000_reqBody.getCityId());
            List<SHO1000_ResBody.ItemsBean> list =new ArrayList<SHO1000_ResBody.ItemsBean>();
            /*
            "shopLogo": "url",
            "marketId": "编号",
            "marketName": "店铺名称",
            "marketDesc":"主题描述",
            "affiliatedPic":"附属图片（家电清凉节)"*/
            SHO1000_ResBody.ItemsBean itemsBean=null;
            for(HotShop hotShop:li){
                itemsBean= new SHO1000_ResBody.ItemsBean();
                itemsBean.setMarketId(String.valueOf(hotShop.getId()));
                itemsBean.setMarketName(hotShop.getShop_name());
                itemsBean.setMarketDesc(hotShop.getShop_desc());
                itemsBean.setAffiliatedPic(hotShop.getAffiliated_pic());
                list.add(itemsBean);
            }
            sho1000_resBody.setItems(list);
            response.setBodyObject(sho1000_resBody);
            response.setResult(ResultCode.SUCCESS);

        }catch (Exception e){
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }
    }

    @Override
    public Class<SHO1000_Req> getReqType() {
        return SHO1000_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
