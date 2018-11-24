package com.huiji.api.biz.controller;

import com.alibaba.fastjson.JSON;
import com.huiji.api.msg.request.USR1000_Req;
import com.huiji.api.util.StringUtil;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.*;

/**
 * Created by yasenagat on 16/7/14 Time 上午10:15.
 */
public class USR1000Test {

    @Test
    public void testV() throws Exception {

        String  body = "MiCyJESlX4SYb474v1Pum2gxRCBwJIo30obxGN2UUhM8HMRKL7NUDJ0ayLmiw2H6Jn21dPXVTPncJNKjr5ymXs2VQaf9w8PDAWY3kUwQBXQ=";
        String digest = StringUtil.MD5EncodeToHex(body) + "";
        String req = "{    \"deviceId\": \"设备编号\",\n" +
                "    \"session\": \"1234$3A626C482147D547F12D66D374841FC8\",\n" +
                "    \"mode\": \"2\",\n" +
                "    \"body\": \"" + body + "\",\n" +
                "    \"digest\": \"" + digest + "\"\n" +
                "}";
        HttpRequest http_req = HttpRequest.post("http://localhost:8080/android/1.0/USR1000/1.0");
        http_req.body(req.getBytes(), "");
        //发送请求  并返回
        HttpResponse http_resp = null;

        http_resp = http_req.connectionKeepAlive(false).timeout(10000).send();
        byte[] resp_mi_body = http_resp.bodyBytes();

        System.out.println("res : " + new String(resp_mi_body));
    }

    @Test
    public void testVMulit() throws Exception {


        String body = "eJyr5lIAAqWCjPy8VCUrBaVnnd3P5ux62r9dSQcqk1hcXJ5flAKSfD5z99O9U5+ub3u+oFHD2Ojp2ukvupp8XUw1YYoTk0syy1Kd81PAZr1c1fNifSNQrRJXLQBLdSnw";

        String digest = StringUtil.MD5EncodeToHex(body) + "";
        String req = "{    \"deviceId\": \"设备编号\",\n" +
                "    \"session\": \"1234$3A626C482147D547F12D66D374841FC8\",\n" +
                "    \"mode\": \"1\",\n" +
                "    \"body\": \"" + body + "\",\n" +
                "    \"digest\": \"" + digest + "\"\n" +
                "}";

//        ExecutorService executorService = new ThreadPoolExecutor(1000, 1000, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000));

        for (int i = 0; i < 1000; i++) {
//            executorService.execute(new Runnable() {
//            @Override
//            public void run () {
            HttpRequest http_req = HttpRequest.post("http://localhost:8080/android/1.0/USR1000/1.0");
            http_req.body(req.getBytes(), "");
            //发送请求  并返回
            HttpResponse http_resp = null;
            http_resp = http_req.connectionKeepAlive(false).timeout(10000).send();
            byte[] resp_mi_body = http_resp.bodyBytes();

            System.out.println("res : " + new String(resp_mi_body));
//            }
//            });
        }


    }
}