package com.huiji.api.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 王潇雨 on 2016/7/18.
 */
public class ValidateUtil {
    public static boolean ValidatePhone(String phone){
        Pattern p = Pattern
                .compile("^((13[0-9])|(14[5,7,9])|(15[^4,\\D])|(18[0-9])|(17[0,1,3,5,6,7,8,9]))\\d{8}$");
        Matcher m = p.matcher(phone);
        System.out.println(m.matches()+"---");
        return m.matches();
    }
}
