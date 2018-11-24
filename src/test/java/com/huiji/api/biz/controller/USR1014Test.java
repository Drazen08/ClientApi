package com.huiji.api.biz.controller;

import org.junit.Test;
import com.huiji.api.util.StringUtil;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

/**
 * Created by 孙旌翔 on 2016/7/18.
 */
public class USR1014Test {
    @Test
    public void testUpdateAddRess() throws Exception {
        String body =
        "b2Jh4IEhUlajD5CkUikkmameJ/pEnu4DcgCZsE1lCaU5GA3QhrHnRgpobrnFXZZm8eZo0omywgXhhuZflFUA7EI8uo57CJ4uKa7KGuE8d754+ReZOM4YmMKsFfqCj/dzPXd5RYYF+6Lt2TISdn2HqbwTpgklimyeRBIV1uOnPKuxW/MV8f/4f0oesS8dswM3oP2TmZKfawRnPzP51AbUV16oqxlG3bbBPOR4PzTqpBTHfsmr9r1gZi4RtfyAKq4E";

        String digest = StringUtil.MD5EncodeToHex(body) + "";
        String req = "{    \"deviceId\": \"设备编号\",\n" +
                "    \"session\": \"508b227b-2911-4da1-8cd2-e576d0115b56$3A626C482147D547F12D66D374841FC8\",\n" +
                "    \"mode\": \"2\",\n" +
                "    \"body\": \"" + body + "\",\n" +
                "    \"digest\": \"" + digest + "\"\n" +
                "}";
        HttpRequest http_req = HttpRequest.post("http://localhost:8080/android/1.0/USR1014/1.0");
        http_req.body(req.getBytes(), "");
        //发送请求  并返回
        HttpResponse http_resp = null;

        http_resp = http_req.connectionKeepAlive(false).timeout(10000).send();
        byte[] resp_mi_body = http_resp.bodyBytes();

        System.out.println("res : " + new String(resp_mi_body));
    }
}
