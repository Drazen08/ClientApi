package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.Goods;
import com.huiji.api.db.mapper.GoodsMapper;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.SHO1002_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.SHO1002_ReqBody;
import com.huiji.api.msg.response.SHO1002_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.SHO1002_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingxiang on 2016/8/9.
 */
@RestController
public class SHO1002 extends AbstractBaseController<SHO1002_Req,SHO1002_ReqBody,SHO1002_Res,SHO1002_ResBody> {
    @Resource
    private GoodsMapper goodsMapper;


    @RequestMapping(URLPREFIX+"/SHO1002/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(SHO1002_Req sho1002_req) {
        return true;
    }

    @Override
    public SHO1002_Res getRes() {
        return new SHO1002_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<SHO1002_ReqBody> request, String uid) throws Exception {
    try{
        SHO1002_ReqBody sho1002_reqBody=null;
        sho1002_reqBody=request.getBodyObject();
        int type=sho1002_reqBody.getTypee();
        int page=sho1002_reqBody.getPagenow();
        int pages=(page-1)*10;
        int show=page*10;
        SHO1002_ResBody sho1002_resBody =new SHO1002_ResBody();
        String orderby="";
        //1全部、2新品 3人气
        if(type==1){
        orderby="scrs desc,num desc";
        }else if(type==2){
        orderby="create_time desc";
        }else if(type==3){
        orderby="scrs desc";
        }
        List<Goods> li=goodsMapper.shopproducts(sho1002_reqBody.getShopId(),orderby,pages,show);
        List<SHO1002_ResBody.ItemsBean> list=new ArrayList<SHO1002_ResBody.ItemsBean>();
            for(Goods goods:li){
                SHO1002_ResBody.ItemsBean itemsBean =new SHO1002_ResBody.ItemsBean();
                itemsBean.setGoodName(goods.getGoodsname());
                itemsBean.setGoodId(goods.getId());
                itemsBean.setGoodPrice(goods.getPingtaiprice());
                itemsBean.setGoodUrl(goods.getImages().split(";")[0]);
                itemsBean.setSalNum(goods.getNum());
               list.add(itemsBean);

            }
            sho1002_resBody.setItems(list);
            response.setBodyObject(sho1002_resBody);
            response.setResult(ResultCode.SUCCESS);



    }catch (Exception e){
        e.printStackTrace();
        response.setResult(ResultCode.PARSE_ERROR);
        throw e;
    }







    }

    @Override
    public Class<SHO1002_Req> getReqType() {
        return SHO1002_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
