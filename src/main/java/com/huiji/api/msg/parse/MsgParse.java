package com.huiji.api.msg.parse;

import com.huiji.api.common.Mode;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.util.AesUtil;
import com.huiji.api.util.Base64Util;
import com.huiji.api.util.StringUtil;
import com.huiji.api.util.ZipUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by yasenagat on 16/7/14 Time 上午12:15.
 */
@Component
public class MsgParse {

    private MsgParse() {
    }

    public static MsgParse getInstance() {
        return msgParse;
    }

    private static final MsgParse msgParse = new MsgParse();

    private String encodeMode1(String mingBody) throws ParseException {
        try {
            return Base64Util.encode(ZipUtil.zip(mingBody.getBytes("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
            throw new ParseException();
        }
    }

    private String encodeMode2(String mingBody, String key) throws ParseException {
        try {
            return Base64Util.encode(AesUtil.encrypt(ZipUtil.zip(mingBody.getBytes("UTF-8")), StringUtil.hexStringToByte(key)));
        } catch (IOException e) {
            e.printStackTrace();
            throw new ParseException();
        }
    }

    public String encodeBody(String mode, String mingBody) throws ParseException {

        GlobalLog.Biz.debug("key : " + key);
        if (Mode.ONE.getValue().equals(mode)) {
            return encodeMode1(mingBody);
        } else if (Mode.TWO.getValue().equals(mode)) {
            return encodeMode2(mingBody, key);
        }

        return null;
    }

    private String decodeMode1(String miBody) throws ParseException {
        try {
//            GlobalLog.Biz.debug("miBody : " + miBody);
//            GlobalLog.Biz.debug("Base64Util.decode(miBody) :" + Base64Util.decode(miBody));
            return new String(ZipUtil.unzip(Base64Util.decode(miBody)), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            throw new ParseException();
        }
    }

    private String decodeMode2(String miBody, String key) throws ParseException {
        try {
//            GlobalLog.Biz.debug("miBody : " + miBody);
//            GlobalLog.Biz.debug("Base64Util.decode(miBody) :" + Base64Util.decode(miBody));
            return new String(ZipUtil.unzip(AesUtil.decrypt(Base64Util.decode(miBody), StringUtil.hexStringToByte(key))), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            throw new ParseException();
        }
    }

    public String decodeBody(String mode, String miBody) throws ParseException {

//        GlobalLog.Biz.debug("key : " + key);
        if (Mode.ONE.getValue().equals(mode)) {
            return decodeMode1(miBody);
        } else if (Mode.TWO.getValue().equals(mode)) {
            return decodeMode2(miBody, key);
        }

        return null;
    }

    //    @Value("${key}")
    private String key = "3A3132333435363738393B3132333435";

}
