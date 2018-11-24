package com.huiji.api.biz.controller;

import com.huiji.api.util.StringUtil;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
public class PAY1001Test {

    @Test
    public void testV() throws Exception {
        String body = "eJyr5lIAAqX8opTUIs+UYiWraCVDMwMLQwMDS2MjAwMDQyUdiIClobGJCVDASClWB6InKTEnMS85VclKCaTQQImrFgC2MhFp";
        //MiCyJESlX4SYb474v1Pum+So9FoOHr/+FNrI3XMvYjzXFLpt2RXKGvQQkGcLKUG2
        String digest = StringUtil.MD5EncodeToHex(body) + "";
        String req = "{    \"deviceId\": \"设备编号\",\n" +
                "    \"session\": \"76c42a47-169f-4dca-8006-4182e5537220$3A626C482147D547F12D66D374841FC8\",\n" +
                "    \"mode\": \"1\",\n" +
                "    \"body\": \"" + body + "\",\n" +
                "    \"digest\": \"" + digest + "\"\n" +
                "}";
        HttpRequest http_req = HttpRequest.post("http://localhost:8080/clientApi/android/1.0/all/PAY1001/1.0");
        http_req.body(req.getBytes(), "");
        //发送请求  并返回
        HttpResponse http_resp = null;

        http_resp = http_req.connectionKeepAlive(false).timeout(10000).send();
        byte[] resp_mi_body = http_resp.bodyBytes();

        System.out.println("res : " + new String(resp_mi_body));
    }
}