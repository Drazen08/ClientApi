package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.OrderMapper;
import com.huiji.api.db.mapper.ShopEvaluteMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.ORD1006_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1006_ReqBody;
import com.huiji.api.msg.response.ORD1006_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1006_ResBody;
import com.huiji.api.util.DateUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jingxiang on 2016/8/11.此接口已废弃，与ord1005合并
 */
@RestController
public class ORD1006  extends AbstractBaseController<ORD1006_Req,ORD1006_ReqBody,ORD1006_Res,ORD1006_ResBody> {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserSessionMapper userSessionMapper;
    @Resource
    private ShopEvaluteMapper shopEvaluteMapper;
    @RequestMapping(URLPREFIX+"/ORD1006/*")

    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest){
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }




    @Override
    public boolean checkRequestBodyParam(ORD1006_Req ord1006_req) {
        return true;
    }

    @Override
    public ORD1006_Res getRes() {
        return new ORD1006_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ORD1006_ReqBody> request, String uid) throws Exception {
        try {
            ORD1006_ReqBody ord1006_reqBody=null;
            ord1006_reqBody=request.getBodyObject();
            ORD1006_ResBody ord1005_resBody=new ORD1006_ResBody();
            UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
            if (userSession == null) {
                response.setResult(ResultCode.SESSION_TIMEOUT);
                return;
            }
            Date date = new Date();//当前日期
            String date1 = DateUtil.dateToString2(new Date());
            String strday = date1;
            String strmonth = date1.substring(4, 6);
            String stryear = date1.substring(0, 4);

/*

            Date date1 = new Date();//当前日期
            SimpleDateFormat fz = new SimpleDateFormat("yyyyMM");
            Calendar calendar = Calendar.getInstance();//日历对象搜索
*/



//            int a=shopEvaluteMapper.shopEve(ord1006_reqBody.getShopid(),ord1006_reqBody.getOrderId(),ord1006_reqBody.getShopStar(),ord1006_reqBody.getLogisticalStar(),strday,strmonth,stryear);
            orderMapper.updateevaulte(ord1006_reqBody.getOrderId());
//            if(a==1){
//                ord1005_resBody.setResult("0");
//                ord1005_resBody.setResultDesc("操作成功");
//                response.setBodyObject(ord1005_resBody);
//
//            }else{
//                ord1005_resBody.setResult("1");
//                ord1005_resBody.setResultDesc("操作失败");
//                response.setBodyObject(ord1005_resBody);
//
//            }

        }catch(Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }




    }

    @Override
    public Class<ORD1006_Req> getReqType() {
        return ORD1006_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
