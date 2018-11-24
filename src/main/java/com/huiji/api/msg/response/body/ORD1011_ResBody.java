package com.huiji.api.msg.response.body;

import com.huiji.api.db.entity.Order;
import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
public class ORD1011_ResBody extends AbstractResponseBody {


    /**
     * address : 详细地址
     * persion : 收货人
     * phone : 收货人电话
     * returnTable : {"makeSureOrder":{"orderId":"","orderType":"订单的总状态","orderTypeDesc":"订单的状态描述","orderSendType":"订单的发货状态","orderPayType":"订单的支付状态","orderRejectedType":"订单的退货状态","goodsId":"","buyNum":"","goodurl":"","shopName":"店铺名","goodsName":"商品名","price":"商品价格","marketPrice":"市场价","willBuy":"规格描述"},"couldBuy":[{"order":{"orderId":" 返回整个Order表的所有属性","orderType":"订单的总状态","orderTypeDesc":"订单的状态描述","orderSendType":"订单的发货状态","orderPayType":"订单的支付状态","orderRejectedType":"订单的退货状态","create_time":"","pay_time":"付款时间","closing_time":"关闭时间","payback_time":"退款时间","send_time":"发货时间","getdell_time":"成交时间","goodsId":"","price":"商品价格","marketPrice":"市场价","buyNum":"1","goodurl":""},"goodsName":"商品名","willBuy":"规格描述"}]}
     * note : 买家备注
     * paySale : 支付金额
     * yue : 余额支付
     * postPrice : 邮费
     * orderPrice : 订单总价
     * orderId :
     * createTime :
     * payTime :
     * sendTime :
     * getdellTime : 成交时间
     * sellerPhone : 卖家电话
     */

    private String address;
    private String persion;
    private String phone;
    private String shopId;



    /**
     * makeSureOrder : {"orderId":"","orderType":"订单的总状态","orderTypeDesc":"订单的状态描述","orderSendType":"订单的发货状态","orderPayType":"订单的支付状态","orderRejectedType":"订单的退货状态","goodsId":"","buyNum":"","goodurl":"","shopName":"店铺名","goodsName":"商品名","price":"商品价格","marketPrice":"市场价","willBuy":"规格描述"}
     * couldBuy : [{"order":{"orderId":" 返回整个Order表的所有属性","orderType":"订单的总状态","orderTypeDesc":"订单的状态描述","orderSendType":"订单的发货状态","orderPayType":"订单的支付状态","orderRejectedType":"订单的退货状态","create_time":"","pay_time":"付款时间","closing_time":"关闭时间","payback_time":"退款时间","send_time":"发货时间","getdell_time":"成交时间","goodsId":"","price":"商品价格","marketPrice":"市场价","buyNum":"1","goodurl":""},"goodsName":"商品名","willBuy":"规格描述"}]
     */

    private ReturnTableBean returnTable;
    private Boolean yiPayFlag;
    private String note;
    private Long paySale;
    private Long yue;
    private Long postPrice;
    private Long orderPrice;
    private String orderId;
    private String createTime;
    private String payTime;
    private String sendTime;
    private String getdellTime;
    private String sellerPhone;

    public Boolean getYiPayFlag() {
        return yiPayFlag;
    }

    public void setYiPayFlag(Boolean yiPayFlag) {
        this.yiPayFlag = yiPayFlag;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
    public String getPersion() {
        return persion;
    }

    public void setPersion(String persion) {
        this.persion = persion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ReturnTableBean getReturnTable() {
        return returnTable;
    }

    public void setReturnTable(ReturnTableBean returnTable) {
        this.returnTable = returnTable;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getPaySale() {
        return paySale;
    }

    public void setPaySale(Long paySale) {
        this.paySale = paySale;
    }

    public Long getYue() {
        return yue;
    }

    public void setYue(Long yue) {
        this.yue = yue;
    }

    public Long getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(Long postPrice) {
        this.postPrice = postPrice;
    }

    public Long getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getGetdellTime() {
        return getdellTime;
    }

    public void setGetdellTime(String getdellTime) {
        this.getdellTime = getdellTime;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public static class ReturnTableBean {
        /**
         * orderId :
         * orderType : 订单的总状态
         * orderTypeDesc : 订单的状态描述
         * orderSendType : 订单的发货状态
         * orderPayType : 订单的支付状态
         * orderRejectedType : 订单的退货状态
         * goodsId :
         * buyNum :
         * goodurl :
         * shopName : 店铺名
         * goodsName : 商品名
         * price : 商品价格
         * marketPrice : 市场价
         * willBuy : 规格描述
         */

        private MakeSureOrderBean adminOrder;
        /**
         * order : {"orderId":" 返回整个Order表的所有属性","orderType":"订单的总状态","orderTypeDesc":"订单的状态描述","orderSendType":"订单的发货状态","orderPayType":"订单的支付状态","orderRejectedType":"订单的退货状态","create_time":"","pay_time":"付款时间","closing_time":"关闭时间","payback_time":"退款时间","send_time":"发货时间","getdell_time":"成交时间","goodsId":"","price":"商品价格","marketPrice":"市场价","buyNum":"1","goodurl":""}
         * goodsName : 商品名
         * willBuy : 规格描述
         */

        private List<CouldBuyBean> couldBuy;

        public MakeSureOrderBean getAdminOrder() {
            return adminOrder;
        }

        public void setAdminOrder(MakeSureOrderBean adminOrder) {
            this.adminOrder = adminOrder;
        }

        public List<CouldBuyBean> getCouldBuy() {
            return couldBuy;
        }

        public void setCouldBuy(List<CouldBuyBean> couldBuy) {
            this.couldBuy = couldBuy;
        }

        public static class MakeSureOrderBean {
            private String orderId;
            private int orderType;
            private String orderTypeDesc;
            private int goodsId;
            private int buyNum;
            private String goodurl;
            private String shopName;
            private String goodsName;
            private Long price;
            private Long marketPrice;
            private String willBuy;

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public int getOrderType() {
                return orderType;
            }

            public void setOrderType(int orderType) {
                this.orderType = orderType;
            }

            public String getOrderTypeDesc() {
                return orderTypeDesc;
            }

            public void setOrderTypeDesc(String orderTypeDesc) {
                this.orderTypeDesc = orderTypeDesc;
            }

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

            public String getGoodurl() {
                return goodurl;
            }

            public void setGoodurl(String goodurl) {
                this.goodurl = goodurl;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public Long getPrice() {
                return price;
            }

            public void setPrice(Long price) {
                this.price = price;
            }

            public Long getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(Long marketPrice) {
                this.marketPrice = marketPrice;
            }

            public String getWillBuy() {
                return willBuy;
            }

            public void setWillBuy(String willBuy) {
                this.willBuy = willBuy;
            }
        }

        public static class CouldBuyBean {
            /**
             * orderId :  返回整个Order表的所有属性
             * orderType : 订单的总状态
             * orderTypeDesc : 订单的状态描述
             * orderSendType : 订单的发货状态
             * orderPayType : 订单的支付状态
             * orderRejectedType : 订单的退货状态
             * create_time :
             * pay_time : 付款时间
             * closing_time : 关闭时间
             * payback_time : 退款时间
             * send_time : 发货时间
             * getdell_time : 成交时间
             * goodsId :
             * price : 商品价格
             * marketPrice : 市场价
             * buyNum : 1
             * goodurl :
             */

            private OrderBean orderBean;

            private String goodsName;
            private String willBuy;

            public OrderBean getOrderBean() {
                return orderBean;
            }

            public void setOrderBean(OrderBean orderBean) {
                this.orderBean = orderBean;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public String getWillBuy() {
                return willBuy;
            }

            public void setWillBuy(String willBuy) {
                this.willBuy = willBuy;
            }

            public static class OrderBean {
                private String orderId;
                private int orderType;
                private String orderTypeDesc;
                private String create_time;
                private String pay_time;
                private String payback_time;
                private String send_time;
                private String getdell_time;
                private String price;
                private String marketPrice;
                private String buyNum;
                private String goodurl;
                private String note;
                private Long paySale;
                private Long yue;
                private Long postPrice;
                private Long orderPrice;
                private String sellerPhone;

                public String getSellerPhone() {
                    return sellerPhone;
                }

                public void setSellerPhone(String sellerPhone) {
                    this.sellerPhone = sellerPhone;
                }

                public String getNote() {
                    return note;
                }

                public void setNote(String note) {
                    this.note = note;
                }

                public Long getPaySale() {
                    return paySale;
                }

                public void setPaySale(Long paySale) {
                    this.paySale = paySale;
                }

                public Long getYue() {
                    return yue;
                }

                public void setYue(Long yue) {
                    this.yue = yue;
                }

                public Long getPostPrice() {
                    return postPrice;
                }

                public void setPostPrice(Long postPrice) {
                    this.postPrice = postPrice;
                }

                public Long getOrderPrice() {
                    return orderPrice;
                }

                public void setOrderPrice(Long orderPrice) {
                    this.orderPrice = orderPrice;
                }

                public String getOrderId() {
                    return orderId;
                }

                public void setOrderId(String orderId) {
                    this.orderId = orderId;
                }

                public int getOrderType() {
                    return orderType;
                }

                public void setOrderType(int orderType) {
                    this.orderType = orderType;
                }

                public String getOrderTypeDesc() {
                    return orderTypeDesc;
                }

                public void setOrderTypeDesc(String orderTypeDesc) {
                    this.orderTypeDesc = orderTypeDesc;
                }
                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }

                public String getPay_time() {
                    return pay_time;
                }

                public void setPay_time(String pay_time) {
                    this.pay_time = pay_time;
                }

                public String getPayback_time() {
                    return payback_time;
                }

                public void setPayback_time(String payback_time) {
                    this.payback_time = payback_time;
                }

                public String getSend_time() {
                    return send_time;
                }

                public void setSend_time(String send_time) {
                    this.send_time = send_time;
                }

                public String getGetdell_time() {
                    return getdell_time;
                }

                public void setGetdell_time(String getdell_time) {
                    this.getdell_time = getdell_time;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getMarketPrice() {
                    return marketPrice;
                }

                public void setMarketPrice(String marketPrice) {
                    this.marketPrice = marketPrice;
                }

                public String getBuyNum() {
                    return buyNum;
                }

                public void setBuyNum(String buyNum) {
                    this.buyNum = buyNum;
                }

                public String getGoodurl() {
                    return goodurl;
                }

                public void setGoodurl(String goodurl) {
                    this.goodurl = goodurl;
                }
            }
        }
    }
}
