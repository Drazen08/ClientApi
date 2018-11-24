package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/14.
 */
public class DIC1003_ResBody extends AbstractResponseBody {
    public DIC1003_ResBody(){}
    /**
     * ClassName : 所选一级分类名称
     * items : [{"shopId":"店铺id","shopName":"店铺名称","shopLogo":"店铺logo","shopUrl":"图片","shopScore":"店铺评分","sellNum":"销量","shopclass":"shop分类"}]
     */

    private String ClassName;
    /**
     * shopId : 店铺id
     * shopName : 店铺名称
     * shopLogo : 店铺logo
     * shopUrl : 图片
     * shopScore : 店铺评分
     * sellNum : 销量
     * shopclass : shop分类
     */

    private List<ItemsBean> items;

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        private Integer shopId;
        private String shopName;
        private String shopLogo;
        private String shopUrl;
        private Integer shopScore;
        private Integer sellNum;
        private String shopclass;

        public Integer getShopId() {
            return shopId;
        }

        public void setShopId(Integer shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getShopLogo() {
            return shopLogo;
        }

        public void setShopLogo(String shopLogo) {
            this.shopLogo = shopLogo;
        }

        public String getShopUrl() {
            return shopUrl;
        }

        public void setShopUrl(String shopUrl) {
            this.shopUrl = shopUrl;
        }

        public Integer getShopScore() {
            return shopScore;
        }

        public void setShopScore(Integer shopScore) {
            this.shopScore = shopScore;
        }

        public Integer getSellNum() {
            return sellNum;
        }

        public void setSellNum(Integer sellNum) {
            this.sellNum = sellNum;
        }

        public String getShopclass() {
            return shopclass;
        }

        public void setShopclass(String shopclass) {
            this.shopclass = shopclass;
        }
    }

    public DIC1003_ResBody(String className, List<ItemsBean> items) {
        ClassName = className;
        this.items = items;
    }
}
