package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.Order;
import com.huiji.api.db.entity.OrderPayTask;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.OrderMapper;
import com.huiji.api.db.mapper.OrderPayTaskMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.msg.request.PAY1003_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.PAY1003_ReqBody;
import com.huiji.api.msg.response.PAY1003_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.PAY1002_ResBody;
import com.huiji.api.msg.response.body.PAY1003_ResBody;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.OrderCodeUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
@RestController//此Controlller作废
public class PAY1003 extends AbstractBaseController<PAY1003_Req,PAY1003_ReqBody,PAY1003_Res,PAY1003_ResBody> {
    /*@Resource
    private UserSessionMapper userSessionMapper;*/
    @Resource
    private OrderPayTaskMapper orderPayTaskMapper;
    @Resource
    private OrderMapper orderMapper;
    @RequestMapping(URLPREFIX + "/PAY1003/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(PAY1003_Req pay1003_req) {
        return true;
    }

    @Override
    public PAY1003_Res getRes() {
        return new PAY1003_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<PAY1003_ReqBody> request, String uid) throws Exception {
//        UserSession userSession = userSessionMapper.searchUserSessionBySid(request.getSid());
//        if (userSession == null) {
//            response.setResult(ResultCode.SESSION_TIMEOUT);
//            return;
//        }
//        PAY1003_ResBody pay1003_resBody=new PAY1003_ResBody();
//        String orderId=request.getBodyObject().getOrderId();
//        Long balance=request.getBodyObject().getBalance();
//        Boolean flag=false;
//        OrderPayTask orderPayTasZhiFuBao=orderPayTaskMapper.searchPayTaskZhiFuBao(orderId);
//        OrderPayTask orderPayTaskWeiXin=orderPayTaskMapper.searchPayTaskWeiXin(orderId);//
//        if(orderPayTasZhiFuBao==null||orderPayTaskWeiXin==null)
//            flag=true;//如果没用支付宝支付过
//        else if("2".equals(orderPayTasZhiFuBao.getState())||"2".equals(orderPayTaskWeiXin.getState()))
//            flag=true;//如果使用支付宝支付失败
//
////        else if()
////            flag=true;//如果没用威信支付过
////        else if()
////            flag=true;//如果使用威信支付失败
//        if(!flag){
//            pay1003_resBody.setResult("-1");
//            pay1003_resBody.setResultDesc("当前状态不能使用微信支付");
//            response.setBodyObject(pay1003_resBody);
//            response.setResult(ResultCode.SUCCESS);
//            return;
//        }
//        String date= DateUtil.dateToString2(new Date());
//        String strDay=date;
//        String strMonth=date.substring(0, 6);
//        String strYear=date.substring(0, 4);
//        OrderPayTask orderPayTaskDB=orderPayTaskMapper.searchPayTaskYue(orderId);
//        OrderPayTask orderPayTask=null;
//        if(orderPayTaskDB==null){//如果根据订单号查支付任务 如果没查到表明要新建此定单号的任务
//                /*
//                (String pay_code_id, String order_id, String uid, String pay_price, String status,
//                 Integer type, String oper_num, String oper_time, String create_time, String str_day,
//                 String str_month, String str_year)
//                 */
//            String payCode= "YUEZF"+ OrderCodeUtil.getOrderNo();//生成支付单号
//            Order orderDB=orderMapper.getOrderByOrderId(orderId);//100-90=10 余额支付不起
//            Long balance0=balance-orderDB.getPrice();//订单的总价-余额支付的价格=实际支付宝要支付的钱
//            if(balance0<0){
//                pay1003_resBody.setResult("-3");
//                pay1003_resBody.setResultDesc("所剩余额不足以支付此订单");
//                response.setBodyObject(pay1003_resBody);
//                response.setResult(ResultCode.SUCCESS);
//                return;
//            }
////            orderPayTaskMapper.updateExecute(orderId);
////            orderPayTask =new OrderPayTask(payCode,orderId,userSession.getUid(),orderDB.getPrice(),"0",
////                    3,"excute",1,null,DateUtil.dateToString(new Date()),strDay,strMonth,strYear);
////            orderPayTaskMapper.savePayTask(orderPayTask);
//
//        }else{
//            if("1".equals(orderPayTaskDB.getState())){
//                pay1003_resBody.setResult("-2");
//                pay1003_resBody.setResultDesc("此订单已经支付成功不能再次支付");
//                response.setBodyObject(pay1003_resBody);
//                response.setResult(ResultCode.SUCCESS);
//                return;
//            }
////            orderPayTaskMapper.updateExecute(orderId);
//            int count=orderPayTaskDB.getOpt_num();
//            orderPayTaskMapper.updateYueCount(orderId, ++count);
//        }
//        pay1003_resBody.setResult("0");
//        pay1003_resBody.setResultDesc("余额支付成功");
//        pay1003_resBody.setBalance(0L);
//        response.setBodyObject(pay1003_resBody);
//        response.setResult(ResultCode.SUCCESS);
    }

    @Override
    public Class<PAY1003_Req> getReqType() {
        return PAY1003_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
