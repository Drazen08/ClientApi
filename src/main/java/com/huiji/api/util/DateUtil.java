package com.huiji.api.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王潇雨 on 2016/7/18.
 */
public class DateUtil {
    public static String dateToString( Date date) {
        String str = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        str = format.format(date);
        return str;
    }
    public static String dateToString2(Date date) {
        String str = null;
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        str = format.format(date);
        return str;
    }

    public static  Date stringToDate(String date) throws ParseException {
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                return format.parse(date);

        }catch(Exception e){
           e.printStackTrace();
            throw e;
        }

    }




    //***************************************************************************************

    public static Map<String,String> parseDate(String createTime){
        try {
            Map<String,String> map=new HashMap<String,String>();
            String ret = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long create = sdf.parse(createTime).getTime();
            Calendar now = Calendar.getInstance();
            long ms  = 1000*(now.get(Calendar.HOUR_OF_DAY)*3600+now.get(Calendar.MINUTE)*60+now.get(Calendar.SECOND));//毫秒数
            long ms_now = now.getTimeInMillis();
            String date=createTime.split(" ")[0];
            String time=createTime.split(" ")[1];
            if(ms_now-create<ms){
                ret = "今天";
                map.put("date",ret);
            }else if(ms_now-create<(ms+24*3600*1000)){
                ret = "昨天";
                map.put("date",ret);
            }else if(ms_now-create<(ms+24*3600*1000*2)){
                ret = "前天";
                map.put("date",ret);
            }else if(ms_now-create<(ms+24*3600*1000*3)){
                ret = getWeekOfDate(stringToDate(createTime));
                map.put("date",ret);
            }else if(ms_now-create<(ms+24*3600*1000*4)){
                ret = getWeekOfDate(stringToDate(createTime));
                map.put("date",ret);
            }else if(ms_now-create<(ms+24*3600*1000*5)){
                ret = getWeekOfDate(stringToDate(createTime));
                map.put("date",ret);
            }else if(ms_now-create<(ms+24*3600*1000*6)){
                ret =getWeekOfDate(stringToDate(createTime));
                map.put("date",ret);
            }else{
                ret=date;
                map.put("date",ret);
            }
            map.put("time",time);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        String weekCount=isThisWeek(dt.getTime());
        return "".equals(weekCount)?weekCount+weekDays[w]:weekCount+weekDays[w].replace("星期","");
    }
    public static String isThisWeek(long time)
    {
        Calendar calendar = Calendar.getInstance();
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.setTime(new Date(time));
        int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        if(paramWeek==currentWeek){
            return "";
        }
        return "上周";
    }

}
