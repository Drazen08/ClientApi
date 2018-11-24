package com.huiji.api.biz.controller;

import com.huiji.api.util.StringUtil;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by 王潇雨 on 2016/7/19.
 */
public class DIC1001Test extends TestCase {
    @Test
    public void testV() throws Exception {
        String body = "eJyr5qoFAAIFAQM=";
        //MiCyJESlX4SYb474v1Pum+So9FoOHr/+FNrI3XMvYjzXFLpt2RXKGvQQkGcLKUG2
        String digest = StringUtil.MD5EncodeToHex(body) + "";
        String req = "{    \"deviceId\": \"设备编号\",\n" +
                "    \"session\": \"1234$3A626C482147D547F12D66D374841FC8\",\n" +
                "    \"mode\": \"1\",\n" +
                "    \"body\": \"" + body + "\",\n" +
                "    \"digest\": \"" + digest + "\"\n" +
                "}";
        HttpRequest http_req = HttpRequest.post("http://localhost:8080/android/1.0/DIC1001/1.0");
        http_req.body(req.getBytes(), "");
        //发送请求  并返回
        HttpResponse http_resp = null;

        http_resp = http_req.connectionKeepAlive(false).timeout(10000).send();
        byte[] resp_mi_body = http_resp.bodyBytes();

        System.out.println("res : " + new String(resp_mi_body));
    }

}