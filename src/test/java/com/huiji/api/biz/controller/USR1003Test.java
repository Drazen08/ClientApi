package com.huiji.api.biz.controller;

import com.huiji.api.util.StringUtil;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
public class USR1003Test {

    @Test
    public void testV() throws Exception {//T0lW+bKD9YiVdaMl/RYUypUJjFo0r/N1aSUHhvAcOrGfqqtFy1zX7ohQW1K7A915
        String body = "MiCyJESlX4SYb474v1Pum39Ori+kNEFPd2KZE9dUW0EK3wcfDjpu+bXcKDe0fb2P";
                //MiCyJESlX4SYb474v1Pum+So9FoOHr/+FNrI3XMvYjzXFLpt2RXKGvQQkGcLKUG2
        String digest = StringUtil.MD5EncodeToHex(body) + "";
        String req = "{    \"deviceId\": \"设备编号\",\n" +
                "    \"session\": \"3dbc1a6e-fdd0-4743-a233-66c6d233300e$3A626C482147D547F12D66D374841FC8\",\n" +
                "    \"mode\": \"2\",\n" +
                "    \"body\": \"" + body + "\",\n" +
                "    \"digest\": \"" + digest + "\"\n" +
                "}";
        HttpRequest http_req = HttpRequest.post("http://localhost:8080/android/1.0/USR1003/1.0");
        http_req.body(req.getBytes(), "");
        //发送请求  并返回
        HttpResponse http_resp = null;

        http_resp = http_req.connectionKeepAlive(false).timeout(10000).send();
        byte[] resp_mi_body = http_resp.bodyBytes();

        System.out.println("res : " + new String(resp_mi_body));
    }
}