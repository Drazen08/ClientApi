package com.huiji.api.biz.controller;

import com.huiji.api.util.StringUtil;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.junit.Test;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class ORD1002Test {
    @Test
    public void testV() throws Exception {
        String body = "eJyr5lIAAqX8opTUIs8UJSsFJUMzAwtDS0NzAxMDAwMjJa5aAJZYB/8=";
        //MiCyJESlX4SYb474v1Pum+So9FoOHr/+FNrI3XMvYjzXFLpt2RXKGvQQkGcLKUG2
        String digest = StringUtil.MD5EncodeToHex(body) + "";
        String req = "{    \"deviceId\": \"设备编号\",\n" +
                "    \"session\": \"5d450662-c648-4637-82e7-b42a12a4b823$3A626C482147D547F12D66D374841FC8\",\n" +
                "    \"mode\": \"1\",\n" +
                "    \"body\": \"" + body + "\",\n" +
                "    \"digest\": \"" + digest + "\"\n" +
                "}";
        HttpRequest http_req = HttpRequest.post("http://localhost:8080/android/1.0/ORD1002/1.0");
        http_req.body(req.getBytes(), "");
        //发送请求  并返回
        HttpResponse http_resp = null;

        http_resp = http_req.connectionKeepAlive(false).timeout(10000).send();
        byte[] resp_mi_body = http_resp.bodyBytes();

        System.out.println("res : " + new String(resp_mi_body));
    }
}
