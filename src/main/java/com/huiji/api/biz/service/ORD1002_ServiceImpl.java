package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.ORD1002_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.mapper.OrderMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.ORD1002_ReqBody;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.ORD1002_ResBody;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/10/27.
 */
@Service
@Transactional
public class ORD1002_ServiceImpl implements ORD1002_Service {
    @Resource
    private OrderMapper orderMapper;

    public void executeService(IResponse response, IRequest<ORD1002_ReqBody> request) throws Exception{
        try {
            ORD1002_ReqBody ord1002_reqBody=request.getBodyObject();
            ORD1002_ResBody ord1002_resBody=new ORD1002_ResBody();
            int a=orderMapper.updateStatusForDeleteType(ord1002_reqBody.getOrderId());
            int b=orderMapper.updateStatusForDeleteTypeYi(ord1002_reqBody.getOrderId());

            if(a==1){
                ord1002_resBody.setResult("0");
                ord1002_resBody.setResultDesc("操作成功");
                response.setBodyObject(ord1002_resBody);
                response.setResult(ResultCode.SUCCESS);

            }else{
                ord1002_resBody.setResult("1");
                ord1002_resBody.setResultDesc("操作失败");
                response.setBodyObject(ord1002_resBody);
                response.setResult(ResultCode.PARAM_ERROR);

            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw e;
        }


    }
}
