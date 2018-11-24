package com.huiji.api.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/18.
 */
public class StringSplitUtil {
    public static Map<String,Object> stringSplit(String param){
        Map<String,Object> map=new HashMap<String,Object>();
        String[] params=param.split(",");
        List<String> payOrders=new ArrayList<String>();
        for(int i=0;i<params.length;i++){
            if(i==0){
                map.put("msgId",params[i]);
                continue;
            }
            payOrders.add(params[i]);
        }
        map.put("payOrders",payOrders);
        return map;
    }
}
