package com.huiji.api.util;

import com.huiji.api.db.entity.AliPayParamter;
import com.huiji.api.db.entity.WXPayParamter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/24.
 */
public class PayInfoUtil  {

    public static Map<String, String> buildOrderParamMap(WXPayParamter wxPayParamter) {
        Map<String, String> keyValues = new HashMap<String, String>();
        keyValues.put("appid",wxPayParamter.getAppid());
        keyValues.put("mch_id",wxPayParamter.getMch_id());
        keyValues.put("nonce_str",UUIDUtil.getUUID());
        keyValues.put("body",wxPayParamter.getBody());
        keyValues.put("out_trade_no",wxPayParamter.getOut_trade_no());
        keyValues.put("total_fee",wxPayParamter.getTotal_fee());
        keyValues.put("spbill_create_ip",wxPayParamter.getSpbill_create_ip());
        keyValues.put("notify_url","http://yasenagat.f3322.org:10080/clientApi/android/1.0/all/AndroidCallBackProcess/1.0");
        keyValues.put("trade_type","APP");
        return keyValues;
    }
    public static Map<String, String> buildOrderInfoParamMap(WXPayParamter wxPayParamter,String prepayid) {
        Map<String, String> keyValues = new HashMap<String, String>();
        keyValues.put("appid",wxPayParamter.getAppid());
        keyValues.put("partnerid",wxPayParamter.getPartnerid());
        keyValues.put("noncestr",UUIDUtil.getUUID());
        keyValues.put("prepayid",prepayid);
        keyValues.put("package","Sign=WXPay");
        keyValues.put("timestamp",(int) (System.currentTimeMillis() / 1000)+"");
        return keyValues;
    }
}
