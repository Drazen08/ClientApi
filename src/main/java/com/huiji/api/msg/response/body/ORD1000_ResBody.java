package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/6.
 */
public class ORD1000_ResBody extends AbstractResponseBody {
    /**
     * pageNow : 当前页
     * items : [{"orderId":"订单号","logo":"logo url","goodprice":"商品价格","desc":"商品描述","time":"时间","num":"购买数量","state":"状态","stateDesc":"状态描述","goodsSpec":"商品规格","shopName":"商铺名称","costprice":"市场价（划线的）","pid":"关联订单id","flag":"是否为主订单 true 是 false 不是"}]
     */

    private Integer pageNow;
    /**
     * orderId : 订单号
     * logo : logo url
     * goodprice : 商品价格
     * desc : 商品描述
     * time : 时间
     * num : 购买数量
     * state : 状态
     * stateDesc : 状态描述
     * goodsSpec : 商品规格
     * shopName : 商铺名称
     * costprice : 市场价（划线的）
     * pid : 关联订单id
     * flag : 是否为主订单 true 是 false 不是
     */

    private List<ItemsBean> items;

    public ORD1000_ResBody(){}

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }


    public static class ItemsBean {
        private String orderId;
        private String logo;
        private long goodprice;//订单价格
        private long pingtaiPrice;//商品的平台价格
        private long postPrice;//邮费
        private String desc;
        private String time;
        private Integer num;
        private Integer state;
        private String stateDesc;
        private String goodsSpec;
        private String shopName;
        private long costprice;
        private String pid;
        private String flag;
        private String pState;
        private String goodId;
        private String shopId;
        private String puFlag;
        private String yiPayFalg;

        public String getYiPayFalg() {
            return yiPayFalg;
        }

        public void setYiPayFalg(String yiPayFalg) {
            this.yiPayFalg = yiPayFalg;
        }

        public long getPingtaiPrice() {
            return pingtaiPrice;
        }

        public void setPingtaiPrice(long pingtaiPrice) {
            this.pingtaiPrice = pingtaiPrice;
        }

        public long getPostPrice() {
            return postPrice;
        }

        public void setPostPrice(long postPrice) {
            this.postPrice = postPrice;
        }

        public String getpState() {
            return pState;
        }

        public void setpState(String pState) {
            this.pState = pState;
        }

        public String getPuFlag() {
            return puFlag;
        }

        public String getGoodId() {
            return goodId;
        }

        public void setGoodId(String goodId) {
            this.goodId = goodId;
        }

        public String getShopId() {
            return shopId;
        }

        public void setShopId(String shopId) {
            this.shopId = shopId;
        }

        public void setPuFlag(String puFlag) {
            this.puFlag = puFlag;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public long getGoodprice() {
            return goodprice;
        }

        public void setGoodprice(long goodprice) {
            this.goodprice = goodprice;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
        }

        public String getStateDesc() {
            return stateDesc;
        }

        public void setStateDesc(String stateDesc) {
            this.stateDesc = stateDesc;
        }

        public String getGoodsSpec() {
            return goodsSpec;
        }

        public void setGoodsSpec(String goodsSpec) {
            this.goodsSpec = goodsSpec;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public long getCostprice() {
            return costprice;
        }

        public void setCostprice(long costprice) {
            this.costprice = costprice;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }
    }

    public ORD1000_ResBody(Integer pageNow, List<ItemsBean> items) {
        this.pageNow = pageNow;
        this.items = items;
    }
}
