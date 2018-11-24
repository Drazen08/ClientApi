package com.huiji.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 孙文剑 on 2016/8/8 0008.
 */
public class OrderCodeUtil {
    private static long orderNum = 0l;
    private static String date ;
    /**
     * 生成订单编号
     * @return
     */
    public static synchronized String getOrderNo() {
        String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());
        if(date==null||!date.equals(str)){
            date = str;
            orderNum  = 0l;
        }
        orderNum ++;
        long orderNo = Long.parseLong((date)) * 10000;
        orderNo += orderNum;;
        return orderNo+"";
    }
}
