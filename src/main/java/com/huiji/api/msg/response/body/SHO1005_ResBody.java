package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by Jingxiang on 2016/10/9.
 */
public class SHO1005_ResBody extends AbstractResponseBody {
    public SHO1005_ResBody(){}

    /**
     * currentPage :
     * items : [{"shopId":"店铺id","shopName":"XXX","shopFeatures":"对商店的描述","logoUrl":"logourl","shopCommentStar":"点评/星级","shopAdress":"商店地址","saleType":"销售类型（韩料）","saleNum":"销量","advUrls":["url"]}]
     */

    private int currentPage;
    /**
     * shopId : 店铺id
     * shopName : XXX
     * shopFeatures : 对商店的描述
     * logoUrl : logourl
     * shopCommentStar : 点评/星级
     * shopAdress : 商店地址
     * saleType : 销售类型（韩料）
     * saleNum : 销量
     * advUrls : ["url"]
     */

    private List<ItemsBean> items;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
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
        private String shopFeatures;
        private String logoUrl;
        private Integer shopCommentStar;
        private String shopAdress;
        private String saleType;
        private Integer saleNum;
        private String advUrls;

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

        public String getShopFeatures() {
            return shopFeatures;
        }

        public void setShopFeatures(String shopFeatures) {
            this.shopFeatures = shopFeatures;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public Integer getShopCommentStar() {
            return shopCommentStar;
        }

        public void setShopCommentStar(Integer shopCommentStar) {
            this.shopCommentStar = shopCommentStar;
        }

        public String getShopAdress() {
            return shopAdress;
        }

        public void setShopAdress(String shopAdress) {
            this.shopAdress = shopAdress;
        }

        public String getSaleType() {
            return saleType;
        }

        public void setSaleType(String saleType) {
            this.saleType = saleType;
        }

        public Integer getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(Integer saleNum) {
            this.saleNum = saleNum;
        }

        public String getAdvUrls() {
            return advUrls;
        }

        public void setAdvUrls(String advUrls) {
            this.advUrls = advUrls;
        }
    }
}
