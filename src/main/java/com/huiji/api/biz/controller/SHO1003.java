package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.Goods;
import com.huiji.api.db.mapper.GoodsMapper;
import com.huiji.api.msg.request.SHO1003_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.SHO1003_ReqBody;
import com.huiji.api.msg.request.body.SHO1003_ReqBody;
import com.huiji.api.msg.response.SHO1003_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.SHO1003_ResBody;
import com.huiji.api.msg.response.body.SHO1003_ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingxiang on 2016/8/10.
 */
@RestController
public class SHO1003 extends AbstractBaseController<SHO1003_Req,SHO1003_ReqBody,SHO1003_Res,SHO1003_ResBody> {


    @Autowired
    private GoodsMapper goodsMapper;

    @RequestMapping(URLPREFIX+"/SHO1003/*")



    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(SHO1003_Req SHO1003_req) {
        return true;
    }

    @Override
    public SHO1003_Res getRes() {
        return new SHO1003_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<SHO1003_ReqBody> request, String uid) throws Exception {
        SHO1003_ReqBody SHO1003_reqBody=null;

        try {
            SHO1003_reqBody=request.getBodyObject();
            SHO1003_ResBody sho1003_resBody=new SHO1003_ResBody();
            int page=request.getBodyObject().getPageNow();
            int pages=(page-1)*10;
            int show=page*10;
            String searchContent=request.getBodyObject().getSearchContent();
            searchContent="%"+searchContent+"%";
            //1:全部  2:人气  3:销量
            List<Goods> li =goodsMapper.shopsearch(searchContent,SHO1003_reqBody.getShopid(),pages,show);
            List<SHO1003_ResBody.ItemsBean> list=new ArrayList<SHO1003_ResBody.ItemsBean>();

            /* "goodId":"商品id",
                     "goodName":"商品名称",
                    "goodUrl":"url",
                    "goodPrice":"平台价格",
                    "salNum":"购买数量"
*/
            for(Goods goods:li){
                SHO1003_ResBody.ItemsBean itemsBean=new SHO1003_ResBody.ItemsBean();
                itemsBean.setGoodId(goods.getId());
                itemsBean.setGoodName(goods.getGoodsname());
                itemsBean.setGoodUrl(goods.getGoodsurl());
                itemsBean.setGoodPrice(goods.getPingtaiprice());
                itemsBean.setSalNum(goods.getNum());
                list.add(itemsBean);
            }
            sho1003_resBody.setPageNow(page);
            sho1003_resBody.setItems(list);
            response.setBodyObject(sho1003_resBody);
            response.setResult(ResultCode.SUCCESS);

        }catch (Exception e){
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }





    }

    @Override
    public Class<SHO1003_Req> getReqType() {
        return SHO1003_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
