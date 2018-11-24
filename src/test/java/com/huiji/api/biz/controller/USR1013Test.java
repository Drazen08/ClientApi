package com.huiji.api.biz.controller;

import com.huiji.api.util.StringUtil;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by 孙旌翔 on 2016/7/17.
 */
public class USR1013Test extends TestCase {
        @Test
    public void testInsertAddRess() throws Exception {
            String body = "b2Jh4IEhUlajD5CkUikkmameJ/pEnu4DcgCZsE1lCaU5GA3QhrHnRgpobrnFXZZmlqOkQW6JBY1CDWRzSdzHX7TFdJ27rwb0soCG6nsfvdbgjPr/77lUE1OfB5d4zBxQd9mS8qhodGxAYsb5QqBY7WUtsGwWspyYo65CoW11NmCr81dSTCBRwwl8XnNlMPZajEFkcnuiSz4AKu45aMF1KSfeeW+y9K50+BMoJ8NpA1mYXZroWNGEOpeWv4ckguv9";

            String digest = StringUtil.MD5EncodeToHex(body) + "";
            String req = "{    \"deviceId\": \"设备编号\",\n" +
                    "    \"session\": \"508b227b-2911-4da1-8cd2-e576d0115b56$3A626C482147D547F12D66D374841FC8\",\n" +
                    "    \"mode\": \"2\",\n" +
                    "    \"body\": \"" + body + "\",\n" +
                    "    \"digest\": \"" + digest + "\"\n" +
                    "}";
            HttpRequest http_req = HttpRequest.post("http://localhost:8080/android/1.0/USR1013/1.0");
            http_req.body(req.getBytes(), "");
            //发送请求  并返回
            HttpResponse http_resp = null;

            http_resp = http_req.connectionKeepAlive(false).timeout(10000).send();
            byte[] resp_mi_body = http_resp.bodyBytes();

            System.out.println("res : " + new String(resp_mi_body));
    }
}