package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/11.
 */
public class ORD1006_ReqBody extends AbstractBaseRequestBody {
    /**
     * orderId : 订单号
     * shopStar : 店铺评分1,2,3,4,5
     * logisticalStar : 物流评分
     * shopid : 商铺id
     */

    private String orderId;
    private Integer shopStar;
    private Integer logisticalStar;
    private Integer shopid;

    public ORD1006_ReqBody(){}


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getShopStar() {
        return shopStar;
    }

    public void setShopStar(Integer shopStar) {
        this.shopStar = shopStar;
    }

    public Integer getLogisticalStar() {
        return logisticalStar;
    }

    public void setLogisticalStar(Integer logisticalStar) {
        this.logisticalStar = logisticalStar;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public ORD1006_ReqBody(String orderId, Integer shopStar, Integer logisticalStar, Integer shopid) {
        this.orderId = orderId;
        this.shopStar = shopStar;
        this.logisticalStar = logisticalStar;
        this.shopid = shopid;
    }
}
