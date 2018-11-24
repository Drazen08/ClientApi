package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/4.
 */
public class SAR1000_ResBody  extends AbstractResponseBody {
    /**
     * goodId : 商品id
     * goodName : 商品名称
     * goodUrl : url
     * goodPrice : 平台价格
     * salNum : 购买数量
     */

    private List<ItemsBean> items;

    public SAR1000_ResBody(){}

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }


    public static class ItemsBean {
        private int goodId;
        private String goodName;
        private String goodUrl;
        private long goodPrice;
        private int salNum;

        public int getGoodId() {
            return goodId;
        }

        public void setGoodId(int goodId) {
            this.goodId = goodId;
        }

        public String getGoodName() {
            return goodName;
        }

        public void setGoodName(String goodName) {
            this.goodName = goodName;
        }

        public String getGoodUrl() {
            return goodUrl;
        }

        public void setGoodUrl(String goodUrl) {
            this.goodUrl = goodUrl;
        }

        public long getGoodPrice() {
            return goodPrice;
        }

        public void setGoodPrice(long goodPrice) {
            this.goodPrice = goodPrice;
        }

        public int getSalNum() {
            return salNum;
        }

        public void setSalNum(int salNum) {
            this.salNum = salNum;
        }
    }

    public SAR1000_ResBody(List<ItemsBean> items) {
        this.items = items;
    }
}
