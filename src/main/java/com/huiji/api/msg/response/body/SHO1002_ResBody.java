package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/9.
 */
public class SHO1002_ResBody extends AbstractResponseBody {
public SHO1002_ResBody(){}
    /**
     * goodId : 商品id
     * goodName : 商品名称
     * goodUrl : url
     * goodPrice : 平台价格
     * salNum : 购买数量
     */

    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        private Integer goodId;
        private String goodName;
        private String goodUrl;
        private long goodPrice;
        private Integer salNum;

        public Integer getGoodId() {
            return goodId;
        }

        public void setGoodId(Integer goodId) {
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

        public Integer getSalNum() {
            return salNum;
        }

        public void setSalNum(Integer salNum) {
            this.salNum = salNum;
        }
    }

    public SHO1002_ResBody(List<ItemsBean> items) {
        this.items = items;
    }
}
