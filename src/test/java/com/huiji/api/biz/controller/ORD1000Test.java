package com.huiji.api.biz.controller;

import com.huiji.api.util.StringUtil;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.junit.Test;

/**
 * Created by Jingxiang on 2016/8/8.
 */
public class ORD1000Test {
    @Test
    public void testV() throws Exception {
        String body = "WU5zN+77CJSHjt+HDfSo4i4t8cbB9ArlGOoIbtU0vTsT8nri4N7bKKj4PCToE2ao";
        //Eaz9NmUz+5hwKoKguwqgo977vUM+1P0KgrPGiu3gTBdWIrJ/gjWNSumsSI0un7zY
        String digest = StringUtil.MD5EncodeToHex(body) + "";
        String req = "{    \"deviceId\": \"设备编号\",\n" +
                "    \"session\": \"f8935173-4264-446b-8f68-02f52418d6c1$3A626C482147D547F12D66D374841FC8\",\n" +
                "    \"mode\": \"2\",\n" +
                "    \"body\": \"" + body + "\",\n" +
                "    \"digest\": \"" + digest + "\"\n" +
                "}";
        HttpRequest http_req = HttpRequest.post("http://localhost:8080/clientApi/android/1.0/all/ORD1000/1.0");
        http_req.body(req.getBytes(), "");
        //发送请求  并返回
        HttpResponse http_resp = null;

        http_resp = http_req.connectionKeepAlive(false).timeout(10000).send();
        byte[] resp_mi_body = http_resp.bodyBytes();

        System.out.println("res : " + new String(resp_mi_body));
    }
}
