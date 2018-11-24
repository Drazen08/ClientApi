package com.huiji.api.biz.controller;

import com.huiji.api.util.StringUtil;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by 孙旌翔 on 2016/7/16.
 */
public class USR1001Test  {
@Test
    public void testLogin() throws Exception {
        /*session=sid+$+ssign
        sid=用户登录返回的sid
        ssign=md5(interface+deviceId+sid+digest)*/


        String body = "MiCyJESlX4SYb474v1Pum2gxRCBwJIo30obxGN2UUhNw9ny+ZA/OWcLshipVLtkfDpfMQIIWU7qMH90cmNLiGw==";
        String session="";
        String digest = StringUtil.MD5EncodeToHex(body) + "";
        String req = "{    \"deviceId\": \"设备编号\",\n" +
                "    \"session\": \"1234$3A626C482147D547F12D66D374841FC8\",\n" +
                "    \"mode\": \"2\",\n" +
                "    \"body\": \"" + body + "\",\n" +
                "    \"digest\": \"" + digest + "\"\n" +
                "}";
        HttpRequest http_req = HttpRequest.post("http://localhost:8080/android/1.0/USR1001/1.0");
        http_req.body(req.getBytes(), "");
        //发送请求  并返回
        HttpResponse http_resp = null;

        http_resp = http_req.connectionKeepAlive(false).timeout(10000).send();
        byte[] resp_mi_body = http_resp.bodyBytes();

        System.out.println("res : " + new String(resp_mi_body));
    }
}