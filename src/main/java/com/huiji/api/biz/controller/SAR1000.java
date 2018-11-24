package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.Goods;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.GoodsMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.SAR1000_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.SAR1000_ReqBody;
import com.huiji.api.msg.response.SAR1000_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.SAR1000_ResBody;
import com.huiji.api.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingxiang on 2016/8/4.
 */
@RestController
public class SAR1000  extends AbstractBaseController<SAR1000_Req,SAR1000_ReqBody,SAR1000_Res,SAR1000_ResBody> {
    @Autowired
    private GoodsMapper goodsMapper;
    /*@Resource
    private UserSessionMapper userSessionMapper;*/

    @RequestMapping(URLPREFIX + "/SAR1000/*")


    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }


    @Override
    public boolean checkRequestBodyParam(SAR1000_Req sar1000_req) {
        return true;
    }

    @Override
    public SAR1000_Res getRes() {
        return new SAR1000_Res();
    }



    @Override
    public void execute(IResponse response, IRequest<SAR1000_ReqBody> request, String uid) throws Exception {
        SAR1000_ReqBody sar1000_reqBody=null;

        try {

            sar1000_reqBody=request.getBodyObject();
            GlobalLog.Biz.debug("sar1000_reqBody.getContent():"+sar1000_reqBody.getContent());
            GlobalLog.Biz.debug("sar1000_reqBody.getType():"+sar1000_reqBody.getType());
            int type=sar1000_reqBody.getType();
            String hehe=null;
            SAR1000_ResBody sar1000_resBody=new SAR1000_ResBody();
            int page=request.getBodyObject().getCurrentPage();
            int pages=(page-1)*10;
            int show=page*10;
            String searchContent=request.getBodyObject().getContent();
            searchContent= "%"+searchContent+"%";//StringUtil.splitString(searchContent);//
            System.out.println(searchContent);
            //1:全部  2:人气  3:销量
            if(type==1){
                hehe="id";
            }else if(type==2){
                hehe="scrs";
            }else if(type==3){
                hehe="num";
            }
            List<Goods> li =goodsMapper.sarchgoods(searchContent,hehe,pages,show);
            List<SAR1000_ResBody.ItemsBean> list=new ArrayList<SAR1000_ResBody.ItemsBean>();
            SAR1000_ResBody.ItemsBean itemsBean=null;
            for(Goods goods:li){
                itemsBean=new SAR1000_ResBody.ItemsBean();
                itemsBean.setGoodId(goods.getId());
                itemsBean.setGoodName(goods.getGoodsname());
                itemsBean.setGoodUrl(goods.getImages().split(";")[0]);
                itemsBean.setGoodPrice(goods.getPingtaiprice());
                itemsBean.setSalNum(goods.getNum());
                list.add(itemsBean);
            }
            sar1000_resBody.setItems(list);
            response.setBodyObject(sar1000_resBody);
            response.setResult(ResultCode.SUCCESS);

        }catch (Exception e){
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }



    }

    @Override
    public Class<SAR1000_Req> getReqType() {
        return SAR1000_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
