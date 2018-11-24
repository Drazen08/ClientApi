package com.huiji.api.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Jingxiang on 2016/8/18.
 */
public class OrderDescUtil {
    //a 支付  b 发货   c 退货   d 主状态
    public static Map<String,Object> generateStatus(int a,int b,int c, int d,int type) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (a == 0 && b == 0 && c == 0 && d == 10) {
            map.put("state", 10);
            map.put("desc", "等待支付");
            return map;//未付款--付款
        }
        if (a == 20 && b == 0 && c == 0 && d == 10 && type==1) {//主订单付款失败   再次付款
            map.put("state", 20);
            map.put("desc", "付款失败");
            return map;//
        }
        if (a == 20 && b == 0 && c == 0 && d == 10 && type==2) {//预订单付款失败
            map.put("state", 30);
            map.put("desc", "付款失败");
            return map;//
        }
        //a 支付  b 发货   c 退货   d 主状态
        if (a == 30 && b == 0 && c == 0 && d == 10 ) {
            map.put("state",40);
            map.put("desc", "付款中");
            return map;//未确认收货--确认收货
        }
        //a 支付  b 发货   c 退货   d 主状态
        if (a == 90 && b == 0 && c == 0 && d == 10) {
            map.put("state", 50);
            map.put("desc", "付款已超时");
            return map;//未确认收货--确认收货
        }
        //  a 支付     b 发货     c 退货    d 主状态
        if (a == 10 && b == 10 && c == 0 && d == 10) {
            map.put("state", 60);
            map.put("desc", "等待收货");
            return map;//未确认收货--确认收货
        }
        //a 支付  b 发货   c 退货   d 主状态
        if (a == 10 && b == 0 && c == 0 && d == 10) {
            map.put("state", 70);
            map.put("desc", "等待发货");
            return map;//未发货--提醒发货
        }
        //a 支付  b 发货   c 退货   d 主状态
        if (a == 10 && b == 5 && c == 0 && d == 10) {
            map.put("state", 75);
            map.put("desc", "用户已提醒发货");
            return map;//未发货--提醒发货
        }
          //a 支付  b 发货   c 退货   d 主状态
        if (a == 10 && b == 20 && c == 0 && d == 20) {
            map.put("state", 80);
            map.put("desc", "交易成功");
            return map;//订单完成--未评价
        }
        if (a == 10 && b == 20 && c == 0 && d == 30) {
            map.put("state", 90);
            map.put("desc", "交易成功");
            return map;//订单完成--已经评价
        }
        //a 支付  b 发货   c 退货   d 主状态
        if (a == 10 && b == 20 &&  c == 30 && (d == 20 || d == 30)) {
            map.put("state", 100);
            map.put("desc", "发起退货申请");
            return map;//退款--发起
        }
        if (a == 10 && b == 20 &&  c == 40 && (d == 20 || d == 30)) {
            map.put("state", 110);
            map.put("desc", "商家同意退货");
            return map;//退款--发起
        }
        if (a == 10 && b == 20 &&  c == 45 && (d == 20 || d == 30)) {
            map.put("state", 115);
            map.put("desc", "用户退货已发货");
            return map;//退款--发起
        }
        if (a == 10 && b == 20 &&  c == 50 && (d == 20 || d == 30)) {
            map.put("state", 120);
            map.put("desc", "商家不同意退货");
            return map;//退款--发起
        }

        if (a == 10 && b == 20 &&  c == 60 && (d == 20 || d == 30)) {
            map.put("state", 130);
            map.put("desc", "商家确认收货");
            return map;//退款--发起
        }
        if (a == 10 && b == 20 &&  c == 90 && (d == 20 || d == 30)) {
            map.put("state", 140);
            map.put("desc", "商家同意退款");
            return map;//退款--发起
        }
        if (a == 10 && b == 20 &&  c ==100 && (d == 20 || d == 30)) {
            map.put("state", 150);
            map.put("desc", "商家不同意退款");
            return map;//退款--发起
        }
        if (a == 10 && b == 20 &&  c ==10&& (d == 20 || d == 30)) {
            map.put("state", 160);
            map.put("desc", "退款成功");
            return map;//退款--发起
        }
        if (a == 10 && b == 20 &&  c ==20 && (d == 20 || d == 30)) {
            map.put("state", 170);
            map.put("desc", "退款失败");
            return map;//退款--发起
        }
        if(d==40){
            map.put("state", 180);
            map.put("desc", "订单已关闭");
            return map;//退款--发起
        }

        map.put("state", -1);
        return map;
    }
}
