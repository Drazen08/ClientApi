package com.huiji.api.util;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

/**
 * Created by Administrator on 2016/10/24.
 */
public class WXOrderUtil  {
    public static String WXOrder(String payParams){
        HttpRequest http_req = HttpRequest.post("https://api.mch.weixin.qq.com/pay/unifiedorder");
        http_req.body(payParams.getBytes(), "");
        //发送请求  并返回
        HttpResponse http_resp = null;

        http_resp = http_req.connectionKeepAlive(false).timeout(20000).send();
        byte[] resp_mi_body = http_resp.bodyBytes();
        String res=new String(resp_mi_body);
        System.out.println("res : " +res );

        return res;
    }


}
