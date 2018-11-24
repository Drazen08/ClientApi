package com.huiji.api.util;

import com.huiji.api.db.entity.WXPayParamter;

/**
 * Created by Administrator on 2016/10/24.
 */
public class BuildXMLUtil  {
    public static String toXML(WXPayParamter wxPayParamter,String sign){
        return "<xml>\n" +
                "<appid><![CDATA["+wxPayParamter.getAppid()+"]]</appid>\n" +
                "<mch_id><![CDATA["+wxPayParamter.getMch_id()+"]]</mch_id>\n" +
                "<nonce_str><![CDATA["+wxPayParamter.getNonce_str()+"]]<nonce_str>\n" +
                "<body><![CDATA["+wxPayParamter.getBody()+"]]</body>\n" +
                "<out_trade_no><![CDATA["+wxPayParamter.getOut_trade_no()+"]]</out_trade_no>\n" +
                "<total_fee><![CDATA["+wxPayParamter.getTotal_fee()+"]]</total_fee>\n" +
                "<spbill_create_ip><![CDATA["+wxPayParamter.getSpbill_create_ip()+"]]</spbill_create_ip>\n" +
                "<notify_url><![CDATA["+"http://yasenagat.f3322.org:10080/clientApi/android/1.0/all/AndroidCallBackProcess/1.0"+"]]</notify_url>\n" +
                "<trade_type><![CDATA[APP]]</trade_type>\n" +
                "<sign><![CDATA["+sign+"]]</sign>\n" +
                "<xml>";
    }
}
