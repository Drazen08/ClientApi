package com.huiji.api.util;

import java.util.Random;

/**
 * Created by 王潇雨 on 2016/7/18.
 */
public class ActiveCodeUtil {
    public static int productActiveCode(){
        return (int)((Math.random()*9+1)*100000);
    }
   public static String getRandomString() {
        char[] chs = new char[10];
        Random ran = new Random();
        for(int i = 0; i < chs.length; i++) {
            chs[i] = (char)(ran.nextInt(10) + '0');
        } return new String(chs);
    }

}
