package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public class ORD1008_ReqBody extends AbstractBaseRequestBody {

    /**
     * goodsId :
     * buyNum :
     * shopId :
     * subid : 商品子id
     * currentPrice : 当前价格
     * willBuy : [{"id":"","desc":"颜色","item":{"id":"","desc":"红色"}}]
     */
    private Long postPrice;
    private MakeSureBean makeSure;
    /**
     * goodsId :
     * subid : 商品子id
     * price : 商品价格
     * buyNum :
     * shopId :
     * willBuy : [{"id":"","desc":"颜色","item":{"id":"","desc":"红色"}}]
     */

    private List<CouldBuyBean> couldBuy;

    public Long getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(Long postPrice) {
        this.postPrice = postPrice;
    }

    public MakeSureBean getMakeSure() {
        return makeSure;
    }

    public void setMakeSure(MakeSureBean makeSure) {
        this.makeSure = makeSure;
    }

    public List<CouldBuyBean> getCouldBuy() {
        return couldBuy;
    }

    public void setCouldBuy(List<CouldBuyBean> couldBuy) {
        this.couldBuy = couldBuy;
    }

    public static class MakeSureBean {
        private int goodsId;
        private int buyNum;
        private int shopId;
        private int subid;
        private Long currentPrice;
        private Long marketPrice;
        private String goodPro;

        public Long getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(Long marketPrice) {
            this.marketPrice = marketPrice;
        }

        public String getGoodPro() {
            return goodPro;
        }

        public void setGoodPro(String goodPro) {
            this.goodPro = goodPro;
        }

        /**
         * id :
         * desc : 颜色
         * item : {"id":"","desc":"红色"}
         */

        private List<WillBuyBean> willBuy;

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public int getBuyNum() {
            return buyNum;
        }

        public void setBuyNum(int buyNum) {
            this.buyNum = buyNum;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public int getSubid() {
            return subid;
        }

        public void setSubid(int subid) {
            this.subid = subid;
        }

        public Long getCurrentPrice() {
            return currentPrice;
        }

        public void setCurrentPrice(Long currentPrice) {
            this.currentPrice = currentPrice;
        }

        public List<WillBuyBean> getWillBuy() {
            return willBuy;
        }

        public void setWillBuy(List<WillBuyBean> willBuy) {
            this.willBuy = willBuy;
        }

        public static class WillBuyBean {
            private int id;
            private String desc;



            /**
             * id :
             * desc : 红色
             */

            private ItemBean item;

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

            public ItemBean getItem() {
                return item;
            }

            public void setItem(ItemBean item) {
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
    }

    public static class CouldBuyBean {
        private int goodsId;
        private int subid;
        private Long price;
        private Long marketPrice;
        private int buyNum;
        private String goodPro;
        public String getGoodPro() {
            return goodPro;
        }

        public Long getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(Long marketPrice) {
            this.marketPrice = marketPrice;
        }

        public void setGoodPro(String goodPro) {
            this.goodPro = goodPro;
        }
        /**
         * id :
         * desc : 颜色
         * item : {"id":"","desc":"红色"}
         */

        private List<WillBuyBean> willBuy;

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public int getSubid() {
            return subid;
        }

        public void setSubid(int subid) {
            this.subid = subid;
        }

        public Long getPrice() {
            return price;
        }

        public void setPrice(Long price) {
            this.price = price;
        }

        public int getBuyNum() {
            return buyNum;
        }

        public void setBuyNum(int buyNum) {
            this.buyNum = buyNum;
        }
        public List<WillBuyBean> getWillBuy() {
            return willBuy;
        }

        public void setWillBuy(List<WillBuyBean> willBuy) {
            this.willBuy = willBuy;
        }

        public static class WillBuyBean {
            private int id;
            private String desc;
            /**
             * id :
             * desc : 红色
             */

            private ItemBean item;

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

            public ItemBean getItem() {
                return item;
            }

            public void setItem(ItemBean item) {
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
    }
}
