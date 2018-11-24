package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/11.
 */
public class ORD1005_ReqBody  extends AbstractBaseRequestBody {
    /**
     * orderId : 订单号
     * goodStar : 商品评价1,2,3,4,5
     * goodContent : 商品评价的内容
     * shopStar : 店铺评分1,2,3,4,5
     * goodsid : 商品id
     */

    private String orderId;
    private Integer goodStar;
    private String goodContent;
    private Integer shopStar;
    private Integer goodsid;

    public ORD1005_ReqBody(){}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodStar() {
        return goodStar;
    }

    public void setGoodStar(Integer goodStar) {
        this.goodStar = goodStar;
    }

    public String getGoodContent() {
        return goodContent;
    }

    public void setGoodContent(String goodContent) {
        this.goodContent = goodContent;
    }

    public Integer getShopStar() {
        return shopStar;
    }

    public void setShopStar(Integer shopStar) {
        this.shopStar = shopStar;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public ORD1005_ReqBody(String orderId, Integer goodStar, String goodContent, Integer shopStar, Integer goodsid) {
        this.orderId = orderId;
        this.goodStar = goodStar;
        this.goodContent = goodContent;
        this.shopStar = shopStar;
        this.goodsid = goodsid;
    }
}
