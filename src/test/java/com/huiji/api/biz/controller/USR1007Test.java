package com.huiji.api.biz.controller;

import com.huiji.api.util.StringUtil;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Administrator on 2016/7/17.
 */
public class USR1007Test  {

    @Test
    public void testV() throws Exception {

        String  body = "MiCyJESlX4SYb474v1Pum2gxRCBwJIo30obxGN2UUhOKKC+3KPMuGi+LKqgLje7tpLEbqvBC3MxE2YDUqjDMrVCFFHitjB+FzdFLfVI50iY=";
        String digest = StringUtil.MD5EncodeToHex(body) + "";
        String req = "{    \"deviceId\": \"设备编号\",\n" +
                "    \"session\": \"7404b5e9-c670-4035-9158-872dc1732eed$3A626C482147D547F12D66D374841FC8\",\n" +
                "    \"mode\": \"2\",\n" +
                "    \"body\": \"" + body + "\",\n" +
                "    \"digest\": \"" + digest + "\"\n" +
                "}";
        HttpRequest http_req = HttpRequest.post("http://localhost:8080/android/1.0/USR1007/1.0");
        http_req.body(req.getBytes(), "");
        //发送请求  并返回
        HttpResponse http_resp = null;

        http_resp = http_req.connectionKeepAlive(false).timeout(10000).send();
        byte[] resp_mi_body = http_resp.bodyBytes();

        System.out.println("res : " + new String(resp_mi_body));
    }

}