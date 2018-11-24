package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.PAY1005_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.*;
import com.huiji.api.db.mapper.*;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.PAY1005_ReqBody;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.PAY1005_ResBody;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.OrderCodeUtil;
import com.huiji.api.util.OutTradeNoUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/13.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PAY1005_ServiceImpl implements PAY1005_Service {
    @Resource
    private UserBillDetailMapper userBillDetailMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OutTradeNoMapper outTradeNoMapper;
    @Resource
    private OrderPayLockMapper orderPayLockMapper;
    public void executeService(IResponse response, IRequest<PAY1005_ReqBody> request, String uid) throws Exception {

        try {
            List<String> orders = request.getBodyObject().getOrders();
            StringBuffer sbf=new StringBuffer();
            sbf.append("in (");
            for(int i=0;i<orders.size()-1;i++){
                sbf.append(orders.get(i)+",");
            }
            sbf.append(orders.get(orders.size() - 1));
            sbf.append(")");
            orderPayLockMapper.updateOrderPaying(sbf.toString());

            PAY1005_ResBody pay1005_resBody=new PAY1005_ResBody();
            pay1005_resBody.setResult("0");
            pay1005_resBody.setResultDesc("订单付款进行中设置完毕");
            response.setBodyObject(pay1005_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (ParseException e) {
            e.printStackTrace();
            throw e;
        }
    }
}