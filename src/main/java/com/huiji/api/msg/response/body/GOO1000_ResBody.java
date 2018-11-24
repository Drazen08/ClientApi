package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/5 0005.
 */
public class GOO1000_ResBody extends AbstractResponseBody {

    /**
     * shopId :
     * goodId :
     * shopurl : 店铺url
     * shopName :
     * shopnum : 全部宝贝
     * scrs : 收藏人数
     * sendType : 返回是否支持急速快速1急速，2快速
     * goodName :
     * bigImages : []
     * goodPrice : 市场价格
     * discountPrice : 平台价
     * goodsStar : [{"evaluateId":"商品评价的id","evaluateStar":"商品评价的星级","evaluateContent":"商品评价的内容"}]
     * salesNum : 月销量
     * postCost : 邮费
     * shopAddress : 商家地址
     * goodSpec : [{"id":"","desc":"","item":[{"id":"","desc":""}]}]
     * price : [{"id":""},{"key":""},{"value":""}]
     * urlGoods : url
     */

    private int shopId;
    private int goodId;
    private String shopurl;
    private String shopName;
    private int shopnum;
    private int scrs;
    private int sendType;
    private String goodName;
    private Long goodPrice;
    private Long discountPrice;
    private int salesNum;
    private Long postCost;
    private String shopAddress;
    private String urlGoods;
    private String bigImages;
    /**
     * evaluateId : 商品评价的id
     * evaluateStar : 商品评价的星级
     * evaluateContent : 商品评价的内容
     */

    private List<GoodsStarBean> goodsStar;
    /**
     * id :
     * desc :
     * item : [{"id":"","desc":""}]
     */

    private List<GoodSpecBean> goodSpec;
    /**
     * id :
     */

    private List<PriceBean> price;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getShopurl() {
        return shopurl;
    }

    public void setShopurl(String shopurl) {
        this.shopurl = shopurl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getShopnum() {
        return shopnum;
    }

    public void setShopnum(int shopnum) {
        this.shopnum = shopnum;
    }

    public int getScrs() {
        return scrs;
    }

    public void setScrs(int scrs) {
        this.scrs = scrs;
    }

    public int getSendType() {
        return sendType;
    }

    public void setSendType(int sendType) {
        this.sendType = sendType;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Long getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Long goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Long getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Long discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(int salesNum) {
        this.salesNum = salesNum;
    }

    public Long getPostCost() {
        return postCost;
    }

    public void setPostCost(Long postCost) {
        this.postCost = postCost;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getUrlGoods() {
        return urlGoods;
    }

    public void setUrlGoods(String urlGoods) {
        this.urlGoods = urlGoods;
    }

    public String getBigImages() {
        return bigImages;
    }

    public void setBigImages(String bigImages) {
        this.bigImages = bigImages;
    }

    public List<GoodsStarBean> getGoodsStar() {
        return goodsStar;
    }

    public void setGoodsStar(List<GoodsStarBean> goodsStar) {
        this.goodsStar = goodsStar;
    }

    public List<GoodSpecBean> getGoodSpec() {
        return goodSpec;
    }

    public void setGoodSpec(List<GoodSpecBean> goodSpec) {
        this.goodSpec = goodSpec;
    }

    public List<PriceBean> getPrice() {
        return price;
    }

    public void setPrice(List<PriceBean> price) {
        this.price = price;
    }

    public static class GoodsStarBean {
        private int evaluateId;
        private int evaluateStar;
        private String evaluateContent;

        public int getEvaluateId() {
            return evaluateId;
        }

        public void setEvaluateId(int evaluateId) {
            this.evaluateId = evaluateId;
        }

        public int getEvaluateStar() {
            return evaluateStar;
        }

        public void setEvaluateStar(int evaluateStar) {
            this.evaluateStar = evaluateStar;
        }

        public String getEvaluateContent() {
            return evaluateContent;
        }

        public void setEvaluateContent(String evaluateContent) {
            this.evaluateContent = evaluateContent;
        }
    }

    public static class GoodSpecBean {
        private String id;
        private String desc;
        /**
         * id :
         * desc :
         */

        private List<ItemBean> item;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public List<ItemBean> getItem() {
            return item;
        }

        public void setItem(List<ItemBean> item) {
            this.item = item;
        }

        public static class ItemBean {
            private int id;
            private String desc;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }
    }

    public static class PriceBean {
        private int id;
        private String key;
        private Long   value;
        private String goodPro;
        private long  marketPrice;

        public long getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(long marketPrice) {
            this.marketPrice = marketPrice;
        }

        public String getGoodPro() {
            return goodPro;
        }

        public void setGoodPro(String goodPro) {
            this.goodPro = goodPro;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
        }
    }
}
