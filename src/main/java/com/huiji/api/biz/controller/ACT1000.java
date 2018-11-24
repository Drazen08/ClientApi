package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserAct;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.UserActMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.ACT1000_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ACT1000_ReqBody;
import com.huiji.api.msg.response.ACT1000_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ACT1000_ResBody;
import com.huiji.api.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Jingxiang on 2016/8/5.用户账户查询
 */
@RestController
public class ACT1000 extends AbstractBaseController<ACT1000_Req,ACT1000_ReqBody,ACT1000_Res,ACT1000_ResBody> {

    @Autowired
    private UserActMapper userActMapper;
    @RequestMapping(URLPREFIX + "/ACT1000/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        return super.v(requestMsg, httpServletRequest);
    }

    @Override
    public boolean checkRequestBodyParam(ACT1000_Req act1000_req) {
        return true;
    }

    @Override
    public ACT1000_Res getRes() {
        return new ACT1000_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<ACT1000_ReqBody> request, String uid) throws Exception {
        try {
            GlobalLog.Biz.debug("Sid=" + request.getSid());
//            uid=userSessionMapper.loginuid(request.getSid());
            GlobalLog.Biz.debug("uid=" + uid);
            ACT1000_ReqBody act1000_reqBody=request.getBodyObject();
            ACT1000_ResBody ACT1000_resBody = new ACT1000_ResBody();

//            UserSession userSession=userSessionMapper.searchUserSessionBySid(request.getSid());
//            if(userSession==null){
//                response.setResult(ResultCode.SESSION_TIMEOUT);
//                return;
//            }
            int type=act1000_reqBody.getType();
            //month 1--本月  2--前一个月  3--前两个月

            int page=request.getBodyObject().getCurrentPage();
            int pages=(page-1)*10;
            int show=page*10;
            String act_type=null;

            //类型:1全部2充值3退款      充值10  退款20 提现30 支付40
            if(type==1){
                act_type="("+"10,20,30,40"+")";
            }else if(type==2){
                act_type="("+"10"+")";
            }else if(type==3){
                act_type="("+"20"+")";
            }
            String returnStr = null;
            Date date = new Date();//当前日期
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
            Calendar calendar = Calendar.getInstance();//日历对象搜索
            int month_str=act1000_reqBody.getMonth();
            if(month_str==1){
                calendar.setTime(date);//设置当前日期
                returnStr = f.format(calendar.getTime());

            }else if(month_str==2){
                calendar.setTime(date);//设置当前日期
                calendar.add(Calendar.MONTH, -1);//月份减一
                returnStr = f.format(calendar.getTime());
            }else if(month_str==3){
                calendar.setTime(date);//设置当前日期
                calendar.add(Calendar.MONTH, -2);//月份减一
                returnStr = f.format(calendar.getTime());
            }
            List<UserAct> list=userActMapper.userbalance(uid,act_type,returnStr,pages,show);
            List<ACT1000_ResBody.ItemsBean> li=new ArrayList<ACT1000_ResBody.ItemsBean>();
            ACT1000_ResBody.ItemsBean itemsBean =null;
            Map<String,String> map=null;
            for(UserAct userAct:list){
                map=DateUtil.parseDate(userAct.getCreate_time().replace(".0",""));
                itemsBean =new ACT1000_ResBody.ItemsBean();
                itemsBean.setType(userAct.getType());
                itemsBean.setDesc(userAct.getOpt_desc());
                itemsBean.setLogo(userAct.getUrl());
                itemsBean.setTime(map != null ? map.get("time") : "获取时间错误联系客服");
                itemsBean.setDate(map!=null?map.get("date"):"获取时间错误联系客服");
                itemsBean.setMoney(userAct.getChange_money());
                itemsBean.setAct_type(userAct.getAct_type());
                li.add(itemsBean);
            }
            ACT1000_resBody.setItems(li);
            response.setBodyObject(ACT1000_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
            throw e;
        }
    }

    @Override
    public Class<ACT1000_Req> getReqType() {
        return ACT1000_Req.class;
    }

    @Override
    public boolean needUid() {
        return true;
    }
}
