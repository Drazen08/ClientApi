package com.huiji.api.util;

import com.huiji.api.db.mapper.OrderMapper;
import com.huiji.api.db.mapper.OutTradeNoMapper;

import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */
public class OutTradeNoUtil  {
    public static String getOutTradeNo(List<String> orders,OutTradeNoMapper outTradeNoMapper) throws Exception{
        try {
            int orderNum=orders.size();
            if(orderNum==0){
                return "";
            }else
            {
                return outTradeNoMapper.getOutTradeNoBySubOrderId(orders.get(0)).getOut_trade_no();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
