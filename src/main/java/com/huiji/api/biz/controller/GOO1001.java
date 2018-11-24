package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.GoodEvaluate;
import com.huiji.api.db.mapper.GoodEvaluateMapper;
import com.huiji.api.db.mapper.GoodsMapper;
import com.huiji.api.db.mapper.OrderMapper;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.GOO1001_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.GOO1001_ReqBody;
import com.huiji.api.msg.response.GOO1001_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.GOO1001_ResBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingxiang on 2016/8/9. 查看所有评价
 */
@RestController
public class GOO1001 extends AbstractBaseController<GOO1001_Req,GOO1001_ReqBody,GOO1001_Res,GOO1001_ResBody> {
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private GoodEvaluateMapper goodEvaluateMapper;
    @RequestMapping(URLPREFIX+"/GOO1001/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(GOO1001_Req goo1001_req) {
        return true;
    }

    @Override
    public GOO1001_Res getRes() {
        return new GOO1001_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<GOO1001_ReqBody> request, String uid) throws Exception {
    /*  "order_id":"",
        "good_star":"",
        "good_content":"评价详情",  */

        try{
            GOO1001_ReqBody goo1001_reqBody=request.getBodyObject();
            GOO1001_ResBody goo1001_resBody =new GOO1001_ResBody();
            int type = goo1001_reqBody.getType();
            int page = goo1001_reqBody.getPagenow();
            int pages = (page - 1) * 10;
            int show = page * 10;
            int good_mix=0;
            int good_max=0;
            //1 全部 2 好评， 3中评，4差评"
            //4,5星为好评，2-3星为中评 0-1星为差评
            if(type==1){
                good_mix=1;
                good_max=5;
            }else if(type==2){
                good_mix=4;
                good_max=5;
            }else if(type==3) {
                good_mix=2;
                good_max=3;
            }else if(type==4){
                good_mix=0;
                good_max=1;
            }
            List<GoodEvaluate> li=goodEvaluateMapper.getGoodEvaluates(goo1001_reqBody.getGoodid(),good_mix,good_max,pages,show);
            List<GOO1001_ResBody.ItemsBean>list =new ArrayList<GOO1001_ResBody.ItemsBean>();
            for(GoodEvaluate goodEvaluate:li){
                GOO1001_ResBody.ItemsBean itemsBean=new GOO1001_ResBody.ItemsBean();
                itemsBean.setOrder_id(goodEvaluate.getOrder_id());
                itemsBean.setGood_star(goodEvaluate.getGood_star());
                itemsBean.setGood_content(goodEvaluate.getGood_content());
                list.add(itemsBean);

            }
            goo1001_resBody.setItems(list);
            response.setBodyObject(goo1001_resBody);
            response.setResult(ResultCode.SUCCESS);

        }
        catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;

        }

    }

    @Override
    public Class<GOO1001_Req> getReqType() {
        return GOO1001_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
