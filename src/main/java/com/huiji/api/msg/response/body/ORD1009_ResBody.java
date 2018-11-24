package com.huiji.api.msg.response.body;

import com.huiji.api.db.entity.Pay;
import com.huiji.api.db.entity.Post;
import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/7 0007.
 */
public class ORD1009_ResBody extends AbstractResponseBody {


    /**
     * temid : 临时表id
     * addresses : {"addressid":"","name":"","phone":"","address":""}
     * returnTable : {"goodPublicProperty":{"images":"","goodId":"","shopId":"","shopName":"","goodName":""},"makeSure":{"goodsId":"","buyNum":"","subid":"商品子id","shopId":"","price":"价格","marketPrice":"市场价","spec":"规格描述"},"couldBuy":[{"goodsId":"","price":"商品价格","marketPrice":"市场价","buyNum":"1","subid":"商品子id","shopId":"","spec":"规格描述"}]}
     * pay : [{"payTypeId":"支付方式id","payTypeName":"","payDesc":"支付方式描述","paylogo":"支付方式logo"}]
     * post : [{"posttypeId":"配送方式id","posttypeName":"","postTypeDesc":"配送方式 "}]
     * balance : 余额
     * postPrice : 邮费
     */

    private String temid;
    /**
     * addressid :
     * name :
     * phone :
     * address :
     */

    private AddressesBean addresses;
    /**
     * goodPublicProperty : {"images":"","goodId":"","shopId":"","shopName":"","goodName":""}
     * makeSure : {"goodsId":"","buyNum":"","subid":"商品子id","shopId":"","price":"价格","marketPrice":"市场价","spec":"规格描述"}
     * couldBuy : [{"goodsId":"","price":"商品价格","marketPrice":"市场价","buyNum":"1","subid":"商品子id","shopId":"","spec":"规格描述"}]
     */

    private ReturnTableBean returnTable;
    private Long balance;
    private Long postPrice;
    /**
     * payTypeId : 支付方式id
     * payTypeName :
     * payDesc : 支付方式描述
     * paylogo : 支付方式logo
     */

    private List<Pay> pay;
    /**
     * posttypeId : 配送方式id
     * posttypeName :
     * postTypeDesc : 配送方式
     */

    private List<Post> post;

    public String getTemid() {
        return temid;
    }

    public void setTemid(String temid) {
        this.temid = temid;
    }

    public AddressesBean getAddresses() {
        return addresses;
    }

    public void setAddresses(AddressesBean addresses) {
        this.addresses = addresses;
    }

    public ReturnTableBean getReturnTable() {
        return returnTable;
    }

    public void setReturnTable(ReturnTableBean returnTable) {
        this.returnTable = returnTable;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(Long postPrice) {
        this.postPrice = postPrice;
    }

    public List<Pay> getPay() {
        return pay;
    }

    public void setPay(List<Pay> pay) {
        this.pay = pay;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public static class AddressesBean {
        private Integer addressid;
        private String name;
        private String phone;
        private String address;

        public Integer getAddressid() {
            return addressid;
        }

        public void setAddressid(Integer addressid) {
            this.addressid = addressid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public static class ReturnTableBean {
        /**
         * images :
         * goodId :
         * shopId :
         * shopName :
         * goodName :
         */

        private GoodPublicPropertyBean goodPublicProperty;
        /**
         * goodsId :
         * buyNum :
         * subid : 商品子id
         * shopId :
         * price : 价格
         * marketPrice : 市场价
         * spec : 规格描述
         */

        private MakeSureBean makeSure;
        /**
         * goodsId :
         * price : 商品价格
         * marketPrice : 市场价
         * buyNum : 1
         * subid : 商品子id
         * shopId :
         * spec : 规格描述
         */

        private List<CouldBuyBean> couldBuy=new ArrayList<CouldBuyBean>();

        public GoodPublicPropertyBean getGoodPublicProperty() {
            return goodPublicProperty;
        }

        public void setGoodPublicProperty(GoodPublicPropertyBean goodPublicProperty) {
            this.goodPublicProperty = goodPublicProperty;
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

        public static class GoodPublicPropertyBean {
            private String images;
            private int goodId;
            private int shopId;
            private String shopName;
            private String goodName;

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public int getGoodId() {
                return goodId;
            }

            public void setGoodId(int goodId) {
                this.goodId = goodId;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getGoodName() {
                return goodName;
            }

            public void setGoodName(String goodName) {
                this.goodName = goodName;
            }
        }

        public static class MakeSureBean {
            private int goodsId;
            private int buyNum;
            private int subid;
            private int shopId;
            private Long price;
            private Long marketPrice;
            private String spec;

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

            public int getSubid() {
                return subid;
            }

            public void setSubid(int subid) {
                this.subid = subid;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
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

            public String getSpec() {
                return spec;
            }

            public void setSpec(String spec) {
                this.spec = spec;
            }
        }

        public static class CouldBuyBean {
            private int id;
            private int goodsId;
            private Long price;
            private Long marketPrice;
            private int buyNum;
            private int subid;
            private int shopId;
            private String spec;
            private String goodName;
            private String image;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getGoodName() {
                return goodName;
            }

            public void setGoodName(String goodName) {
                this.goodName = goodName;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
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

            public int getBuyNum() {
                return buyNum;
            }

            public void setBuyNum(int buyNum) {
                this.buyNum = buyNum;
            }

            public int getSubid() {
                return subid;
            }

            public void setSubid(int subid) {
                this.subid = subid;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public String getSpec() {
                return spec;
            }

            public void setSpec(String spec) {
                this.spec = spec;
            }
        }
    }

    public static class PayBean {
        private Long payTypeId;
        private String payTypeName;

        private String paylogo;

        public Long getPayTypeId() {
            return payTypeId;
        }

        public void setPayTypeId(Long payTypeId) {
            this.payTypeId = payTypeId;
        }

        public String getPayTypeName() {
            return payTypeName;
        }

        public void setPayTypeName(String payTypeName) {
            this.payTypeName = payTypeName;
        }
        public String getPaylogo() {
            return paylogo;
        }

        public void setPaylogo(String paylogo) {
            this.paylogo = paylogo;
        }
    }

    public static class PostBean {
        private Long posttypeId;
        private String posttypeName;
        private String postTypeDesc;

        public Long getPosttypeId() {
            return posttypeId;
        }

        public void setPosttypeId(Long posttypeId) {
            this.posttypeId = posttypeId;
        }

        public String getPosttypeName() {
            return posttypeName;
        }

        public void setPosttypeName(String posttypeName) {
            this.posttypeName = posttypeName;
        }

        public String getPostTypeDesc() {
            return postTypeDesc;
        }

        public void setPostTypeDesc(String postTypeDesc) {
            this.postTypeDesc = postTypeDesc;
        }
    }
}
