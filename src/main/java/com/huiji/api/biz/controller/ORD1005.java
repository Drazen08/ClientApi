package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.Order;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.*;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.ORD1005_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1005_ReqBody;
import com.huiji.api.msg.response.ORD1005_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1005_ResBody;
import com.huiji.api.util.DateUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Jingxiang on 2016/8/11. 商品评价
 */
@RestController
public class ORD1005  extends AbstractBaseController<ORD1005_Req,ORD1005_ReqBody,ORD1005_Res,ORD1005_ResBody> {
    @Resource
    private OrderMapper orderMapper;
//    @Resource
//    private UserSessionMapper userSessionMapper;
    @Resource
    private GoodEvaluateMapper goodEvaluateMapper;
    @Resource
    private ShopEvaluteMapper shopEvaluteMapper;
    @Resource
    private ShopMapper shopMapper;
    @RequestMapping(URLPREFIX+"/ORD1005/*")

    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }


    @Override
    public boolean checkRequestBodyParam(ORD1005_Req ord1005_req) {
        return true;
    }

    @Override
    public ORD1005_Res getRes() {
        return new ORD1005_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1005_ReqBody> request, String uid) throws Exception {
        try {
            ORD1005_ReqBody ord1005_reqBody=request.getBodyObject();
            ORD1005_ResBody ord1005_resBody=new ORD1005_ResBody();
//            UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
//            if (userSession == null) {
//                response.setResult(ResultCode.SESSION_TIMEOUT);
//                return;
//            }
            String date1 = DateUtil.dateToString2(new Date());
            String strDay = date1;
            String strMonth = date1.substring(4, 6);
            String strYear = date1.substring(0, 4);
            Order order=orderMapper.getOrderByOrderId(ord1005_reqBody.getOrderId());
            int a=goodEvaluateMapper.goodsEve(ord1005_reqBody.getGoodsid(),ord1005_reqBody.getOrderId(),ord1005_reqBody.getGoodStar(),ord1005_reqBody.getGoodContent(),strDay,strMonth,strYear);
            orderMapper.updateevaulte(ord1005_reqBody.getOrderId());
            int b=shopEvaluteMapper.shopEve(order.getShop_id(),ord1005_reqBody.getOrderId(),ord1005_reqBody.getShopStar(),strDay,strMonth,strYear);
            int shopStar=shopEvaluteMapper.shopStar(order.getShop_id());
            shopMapper.updateShopStar(order.getShop_id(),shopStar);
            if(a==1&&b==1){
                ord1005_resBody.setResult("0");
                ord1005_resBody.setResultDesc("操作成功");
                response.setBodyObject(ord1005_resBody);
                response.setResult(ResultCode.SUCCESS);

            }else{
                ord1005_resBody.setResult("1");
                ord1005_resBody.setResultDesc("操作失败");
                response.setBodyObject(ord1005_resBody);
                response.setResult(ResultCode.PARAM_ERROR);

            }

        }catch(Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }
    }

    @Override
    public Class<ORD1005_Req> getReqType() {
        return ORD1005_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
