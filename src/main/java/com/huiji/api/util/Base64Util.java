package com.huiji.api.util;

import jodd.util.Base64;

/**
 * Created by yasenagat on 16/7/13 Time 下午11:41.
 */
public class Base64Util {

    public static byte[] decode(String oriData) {
        return Base64.decode(oriData.replace(" ", "").replace("\r\n", ""));
    }

    public static String encode(byte[] oriData) {
        return Base64.encodeToString(oriData).replace(" ", "").replace("\r\n", "");
    }
}
