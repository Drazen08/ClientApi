package com.huiji.api.msg.parse;

import com.alibaba.fastjson.JSON;
import com.huiji.api.common.ResultCode;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.response.USR1000_Res;
import com.huiji.api.msg.response.body.USR1000_ResBody;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yasenagat on 16/7/14 Time 上午9:40.
 */
public class MsgParseTest {


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testEncodeBody() throws Exception {
        String mode = "2";

//        String body = "{\n" +
//                "    \"orderId\": \"16081817230001\",\n" +
//                "}";
//        String body = "{\n" +
//                "    \"productId\": \"android\",\n" +
//                "    \"productVersion\": \"1.0\",\n" +
//                "    \"channelId\": \"default\"\n" +
//                "}";
//
//        String body = "{\n" +
//                "    \"addressId\": \"2\",\n" +
//                "    \"price\": \"0\",\n" +
//                "    \"balance\": \"0\",\n" +
//                "    \"num\": \"1\",\n" +
//                "    \"note\": \"时代发生地方\",\n" +
//                "    \"sendTypeId\": \"1\",\n" +
//                "    \"buyTypeId\": \"1\",\n" +
//                "    \"paySale\": \"15500\",\n" +
//                "    \"temid\": \"fbcb09be-fc2b-443f-819f-9395095ee48d\",\n" +
//                "    \"postPrice\": \"100\",\n" +
//                "    \"goodUrl\": \"www.xie.com\"\n" +
//                "}";

//
//        String body = "{\n" +
//                "    \"orderId\": \"1\"\n" +
//                "}";

//                String body = "{\n" +
//                "    \"content\": \"鞋\",\n" +
//                "    \"type\": \"3\",\n" +
//                "    \"currentPage\": \"1\"\n" +
//                "}";

           /*   String body = "{\n" +
                "    \"orderId\": \"16081009320001\",\n"+
                "    \"reason\": \"1\"\n"+
                "}";
*/
//        String body = "{\n"+
//              "\"shopid\":\"1\",\n"+
//                "  \"type\":\"1\",\n"+
//                "  \"pagenow\":\"1\"\n"+
//            "}";

//        String body = "{\n"+
//                "  \"type\":\"1\",\n"+
//                "  \"pageNow\":\"1\"\n"+
//                "}";
     /*   String body = "{\n" +
                "    \"goodId\": \"1\"\n" +
*/
//
//        String body = "{\n" +
//                "    \"orderIds\":[\"16081009320001\",\"16081913440002\"],\n" +
//                "    \"balance\":\"20000\"\n" +
//                "}";
//        String body = "{\n" +
//                "    \"orderId\":\"16081817230001\",\n" +
//                "    \"payPassword\":\"111\"\n" +
//                "}";

//        String body = "{\n" +
//                "    \"orderid\": \"16081817230001\"\n" +
//                "}";
//        String body = "{\n" +
//                "}";

//        String body = "{\n" +
//                "}";



//        String body = "{\n" +
//                "    \"orderId\": \"16081009320001\",\n" +
//                "    \"monand\": \"1\",\n" +
//                "    \"reason\": \"1\",\n" +
//                "    \"money\": \"400433\",\n" +
//                "    \"wanttosay\": \"dfdvvdv\"\n" +
//                "}";

     String body = "{\n" +
                "    \"phone\": \"15169170818\"\n" +
                "}";

//        String body = "{\n" +
//                "    \"phone\": \"15169170818\"\n" +
//                "}";
//        String body = "{\n" +
//                "    \"phone\": \"15169170818\",\n" +
//                "    \"password\": \"123456\",\n" +
//                "    \"activeCode\": \"218917\"\n" +
//                "}";
//        String body = "{\n" +
//                "    \"phone\": \"15169170818\",\n" +
//                "    \"payPassword\": \"111\",\n" +
//                "    \"activeCode\": \"371611\"\n" +
//                "}";
//        String body = "{\n" +
//                "    \"phone\": \"15169170818\",\n" +
//                "    \"password\": \"12345\"\n" +
//                "}";
//        String body = "{\n" +
//                "    \"token\": \"107831131008011\",\n" +
//                "    \"password\": \"123\"\n" +
//                "}";
//        String body = "{\n" +             //000000001
//                "    \"provisionalId\": \"fbcb09be-fc2b-443f-819f-9395095ee48d\"\n" +
//                "}";
//        String body = "{\n" +
//                "    \"oldPassword\": \"123\",\n" +
//                "    \"newPassword\": \"123456\"\n" +
//                "}";

//        String body = "{\n" +
//      "  \"makeSure\":{\n"+
//	"  \"goodsId\":\"1\",\n"+
//	"  \"buyNum\":\"1\",\n" +
//	"   \"shopId\":\"3\",\n"+
//	"   \"subid\":\"1\",\n"+
//	"    \"currentPrice\":\"1200\" },\n"+
//    "    \"couldBuy\":[{\n"+
//	 "      \"goodsId\":\"1\",\n"+
//	        "  \"subid\":\"2\",\n"+
//                " \"price\":\"1300\",\n"+
//                " \"buyNum\":\"1\",\n"+
//                "}]}";

        String miBody = MsgParse.getInstance().encodeBody(mode, body);
        System.out.println(miBody);
        String mingBody = MsgParse.getInstance().decodeBody(mode, miBody);
        Assert.assertEquals(body, mingBody);
    }
    @Test
    public void testEncodeBod() throws Exception {
        String mode = "2";


            String body = "{\n" +
              "    \"money\": \"11111\",\n" +
               "    \"bankid\": \"1\"\n" +
                "}";
        String miBody = MsgParse.getInstance().encodeBody(mode, body);
        System.out.println(miBody);
        String mingBody = MsgParse.getInstance().decodeBody(mode, miBody);
        Assert.assertEquals(body, mingBody);
    }

    @Test
    public void testDecodeBody() throws Exception {

        String mode = "2";
        USR1000_Res<USR1000_ResBody> response = new USR1000_Res<>();

        USR1000_ResBody usr1000_resBody = new USR1000_ResBody("aaabbb", "jack", "13344445555");
        usr1000_resBody.setResult("0");
        usr1000_resBody.setResultDesc("注册成功");
        response.setBodyObject(usr1000_resBody);

        response.setResult(ResultCode.SUCCESS);
        String body = JSON.toJSONString(response);
        String miBody = MsgParse.getInstance().encodeBody(mode, body);
        String mingBody = MsgParse.getInstance().decodeBody(mode, miBody);
        Assert.assertEquals(body, mingBody);
    }
}