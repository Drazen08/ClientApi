package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/11.
 */
public class ORD1003_ReqBody extends AbstractBaseRequestBody {


    /**
     * orderId : 订单号
     * monand : all/1/2
     * reason : 1/2/3/4
     * money :
     * wanttosay : 留言
     * flag : 1正常退货 2极速模式下的操作
     */

    private String orderId;
    private String monand;
    private Integer reason;
    private long money;
    private String wanttosay;
//    private Integer flag;

    public ORD1003_ReqBody(){}


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMonand() {
        return monand;
    }

    public void setMonand(String monand) {
        this.monand = monand;
    }

    public Integer getReason() {
        return reason;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getWanttosay() {
        return wanttosay;
    }

    public void setWanttosay(String wanttosay) {
        this.wanttosay = wanttosay;
    }

//    public Integer getFlag() {
//        return flag;
//    }
//
//    public void setFlag(Integer flag) {
//        this.flag = flag;
//    }

    public ORD1003_ReqBody(String orderId, String monand, Integer reason, long money, String wanttosay) {
        this.orderId = orderId;
        this.monand = monand;
        this.reason = reason;
        this.money = money;
        this.wanttosay = wanttosay;
//        this.flag = flag;
    }
}
