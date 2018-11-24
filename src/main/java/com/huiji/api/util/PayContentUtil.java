package com.huiji.api.util;

import com.alibaba.fastjson.JSON;
import com.huiji.api.db.entity.AliPayParamter;
import com.huiji.api.db.entity.WXPayParamter;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/29.
 */
public class PayContentUtil {

    public static String getPayContentUtil(AliPayParamter aliPayParamter) {
        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(aliPayParamter);
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
        String sign = OrderInfoUtil2_0.getSign(params, aliPayParamter.getRSA_PRIVATE());
        return orderParam + "&" + sign;//final String orderInfo =
    }


    private static String uniformOrderUtil(WXPayParamter wxPayParamter) throws Exception {//微信统一下单

        Map<String, String> params = PayInfoUtil.buildOrderParamMap(wxPayParamter);

        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

        String SignTemp = orderParam + "&key=" + wxPayParamter.getKey();

        String sign = StringUtil.MD5EncodeToHex(SignTemp).toUpperCase();

        String xml = BuildXMLUtil.toXML(wxPayParamter, sign);//缺参

        Map<String, String> map = parseXml(WXOrderUtil.WXOrder(xml).replace("<![CDATA[", "").replace("]]>", ""));

        String return_code = map.get("return_code");

        if (return_code != null && return_code.length() > 0 && return_code.trim().length() > 0
                && return_code.equals("SUCCESS")) {

            String return_msg = map.get("return_msg");

            if (return_msg != null && return_msg.length() > 0 && return_msg.trim().length() > 0
                    && !return_msg.equals("OK")) {

                return "-1";

            }
        } else {

            return "-1";

        }

        String prepay_id = map.get("prepay_id");

        return prepay_id;

    }

    private static Map<String, String> parseXml(String xml) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        Document document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();
        List<Element> elementList = root.elements();
        for (Element e : elementList)
            map.put(e.getName(), e.getText());
        return map;
    }

    public static String WXPayContent(WXPayParamter wxPayParamter) throws Exception {
        String prepayid = uniformOrderUtil(wxPayParamter);
        if ("-1".equals(prepayid))
            return "";
        Map<String, String> params = PayInfoUtil.buildOrderInfoParamMap(wxPayParamter, prepayid);
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
        String SignTemp = orderParam + "&key=" + wxPayParamter.getKey();
        String sign = StringUtil.MD5EncodeToHex(SignTemp).toUpperCase();
        params.put("sign", sign);
        return JSON.toJSONString(params);

    }
}
