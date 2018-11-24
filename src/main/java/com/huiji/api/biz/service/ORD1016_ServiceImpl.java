package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.ORD1016_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.OrderLogistics;
import com.huiji.api.db.mapper.OrderLogisticsMapper;
import com.huiji.api.db.mapper.OrderMapper;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1016_ReqBody;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1016_ResBody;
import com.huiji.api.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/31.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ORD1016_ServiceImpl implements ORD1016_Service {
    @Resource
    private OrderLogisticsMapper orderLogisticsMapper;
    @Resource
    private OrderMapper orderMapper;
    public void executeService (IResponse response, IRequest<ORD1016_ReqBody> request, String uid) throws Exception{
        try {
//            String order_id, String logistic_name, String logistic_num,
// String return_remarks, Date create_time, String str_day, String str_month, String str_year
            String date1= DateUtil.dateToString2(new Date());
            String strDay=date1;
            String strMonth=date1.substring(4, 6);
            String strYear=date1.substring(0, 4);
            String orderId=request.getBodyObject().getOrderId();
            orderLogisticsMapper.saveOrderLogistics(new OrderLogistics(
                    orderId, request.getBodyObject().getLogisticsName(), request.getBodyObject().getLogisticsNumber(),
                    request.getBodyObject().getReturnRemarks(), new Date(), strDay, strMonth, strYear
            ));
            orderMapper.updateRejectedStatus(orderId, 45);
            ORD1016_ResBody ord1016_resBody=new ORD1016_ResBody();
            ord1016_resBody.setResult("0");
            ord1016_resBody.setResultDesc("发货设置完毕");
            response.setBodyObject(ord1016_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
