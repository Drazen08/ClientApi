package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.biz.service.base.ORD1003_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.ORD1003_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1003_ReqBody;
import com.huiji.api.msg.response.ORD1003_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1003_ResBody;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.OrderCodeUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Jingxiang on 2016/8/11.用户订单--退货
 */
@RestController
public class ORD1003 extends AbstractBaseController<ORD1003_Req, ORD1003_ReqBody, ORD1003_Res, ORD1003_ResBody> {
   /* @Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private ORD1003_Service ord1003_service;


    @RequestMapping(URLPREFIX + "/ORD1003/*")


    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(ORD1003_Req ord1003_req) {
        return true;
    }

    @Override
    public ORD1003_Res getRes() {
        return new ORD1003_Res();
    }

    /*退货前提
    * 1.订单状态为交易关闭
    * 2.订单交易关闭之后
    *
    *
    * */
    @Override
    public void execute(IResponse response, IRequest<ORD1003_ReqBody> request, String uid) throws Exception {
        try {
            ORD1003_ReqBody ord1003_reqBody = null;
            ord1003_reqBody = request.getBodyObject();
            ORD1003_ResBody ord1003_resBody = new ORD1003_ResBody();
           /* UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }*/
            String pid = orderMapper.pid(ord1003_reqBody.getOrderId());
            Order order = orderMapper.getOrderByOrderId(ord1003_reqBody.getOrderId());
            long tuiPrice = ord1003_reqBody.getMoney();
            long chajia = order.getPrice() - tuiPrice;
            if (chajia < 0) {
                ord1003_resBody.setResult("-2");
                ord1003_resBody.setResultDesc("您输入的退款金额已大于该订单的金额，输入无效。");
                response.setBodyObject(ord1003_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }
            ord1003_service.executeService(tuiPrice,order, ord1003_reqBody);
            ord1003_resBody.setResult("0");
            ord1003_resBody.setResultDesc("操作成功");
            response.setBodyObject(ord1003_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }


    }

    @Override
    public Class<ORD1003_Req> getReqType() {
        return ORD1003_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
