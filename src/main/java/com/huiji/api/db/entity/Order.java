package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by Jingxiang on 2016/8/5.
 */
public class Order extends AbstractBaseEntity {
    private int id;
    private String uid;
    //订单总状态
    private Integer type;
    private Integer send_type;
    private Integer pay_type;
    private Integer tuitype;
    private Integer delete_type;
    private String type_desc;
    private Integer user_address_id;
    private String seller_address;
    private Integer shop_id;
    private Integer goods_id;
    private String  goods_pro;
    private String goods_url;
    private Integer goods_pid;
    //订单总价
    private long price;
    //邮费
    private long postprice;
    //实际支付
    private long endprice;
    //余额支付了多少
    private long balance;
    //商品的价格
    private long goodprice;
    //市场价
    private long costprice;
    //买家留言
    private String leavewords;
    //购买数量
    private Integer num;
    //关联订单id
    private String pid;
    //订单序号
    private String order_id;
    //配送方式id
    private Integer sendid;
    //支付方式id
    private Integer payid;
    private String create_time;
    //付款时间
    private String pay_time;
    private String pay_expired_time;
    //关闭时间
    private String closing_time;
    //退款时间
    private String payback_time;
    //发货时间
    private String send_time;
    //成交时间
    private String getdell_time;

    private String str_day;
    private String str_month;
    private String str_year;
    private String esc_reason;
    private String seller_id;

    public String getGoods_pro() {
        return goods_pro;
    }

    public void setGoods_pro(String goods_pro) {
        this.goods_pro = goods_pro;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSend_type() {
        return send_type;
    }

    public void setSend_type(Integer send_type) {
        this.send_type = send_type;
    }

    public Integer getPay_type() {
        return pay_type;
    }

    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    public Integer getTuitype() {
        return tuitype;
    }

    public void setTuitype(Integer tuitype) {
        this.tuitype = tuitype;
    }

    public Integer getDelete_type() {
        return delete_type;
    }

    public void setDelete_type(Integer delete_type) {
        this.delete_type = delete_type;
    }

    public String getType_desc() {
        return type_desc;
    }

    public void setType_desc(String type_desc) {
        this.type_desc = type_desc;
    }

    public Integer getUser_address_id() {
        return user_address_id;
    }

    public void setUser_address_id(Integer user_address_id) {
        this.user_address_id = user_address_id;
    }

    public String getSeller_address() {
        return seller_address;
    }

    public void setSeller_address(String seller_address) {
        this.seller_address = seller_address;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_url() {
        return goods_url;
    }

    public void setGoods_url(String goods_url) {
        this.goods_url = goods_url;
    }

    public Integer getGoods_pid() {
        return goods_pid;
    }

    public void setGoods_pid(Integer goods_pid) {
        this.goods_pid = goods_pid;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPostprice() {
        return postprice;
    }

    public void setPostprice(long postprice) {
        this.postprice = postprice;
    }

    public long getEndprice() {
        return endprice;
    }

    public void setEndprice(long endprice) {
        this.endprice = endprice;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getGoodprice() {
        return goodprice;
    }

    public void setGoodprice(long goodprice) {
        this.goodprice = goodprice;
    }

    public long getCostprice() {
        return costprice;
    }

    public void setCostprice(long costprice) {
        this.costprice = costprice;
    }

    public String getLeavewords() {
        return leavewords;
    }

    public void setLeavewords(String leavewords) {
        this.leavewords = leavewords;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getSendid() {
        return sendid;
    }

    public void setSendid(Integer sendid) {
        this.sendid = sendid;
    }

    public Integer getPayid() {
        return payid;
    }

    public void setPayid(Integer payid) {
        this.payid = payid;
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

    public String getPay_expired_time() {
        return pay_expired_time;
    }

    public void setPay_expired_time(String pay_expired_time) {
        this.pay_expired_time = pay_expired_time;
    }

    public String getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(String closing_time) {
        this.closing_time = closing_time;
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

    public String getStr_day() {
        return str_day;
    }

    public void setStr_day(String str_day) {
        this.str_day = str_day;
    }

    public String getStr_month() {
        return str_month;
    }

    public void setStr_month(String str_month) {
        this.str_month = str_month;
    }

    public String getStr_year() {
        return str_year;
    }

    public void setStr_year(String str_year) {
        this.str_year = str_year;
    }

    public String getEsc_reason() {
        return esc_reason;
    }

    public void setEsc_reason(String esc_reason) {
        this.esc_reason = esc_reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return getId() == order.getId();

    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", type=" + type +
                ", send_type=" + send_type +
                ", pay_type=" + pay_type +
                ", tuitype=" + tuitype +
                ", delete_type=" + delete_type +
                ", type_desc='" + type_desc + '\'' +
                ", user_address_id=" + user_address_id +
                ", seller_address='" + seller_address + '\'' +
                ", shop_id=" + shop_id +
                ", goods_id=" + goods_id +
                ", goods_pro='" + goods_pro + '\'' +
                ", goods_url='" + goods_url + '\'' +
                ", goods_pid=" + goods_pid +
                ", price=" + price +
                ", postprice=" + postprice +
                ", endprice=" + endprice +
                ", balance=" + balance +
                ", goodprice=" + goodprice +
                ", costprice=" + costprice +
                ", leavewords='" + leavewords + '\'' +
                ", num=" + num +
                ", pid='" + pid + '\'' +
                ", order_id='" + order_id + '\'' +
                ", sendid=" + sendid +
                ", payid=" + payid +
                ", create_time='" + create_time + '\'' +
                ", pay_time='" + pay_time + '\'' +
                ", pay_expired_time='" + pay_expired_time + '\'' +
                ", closing_time='" + closing_time + '\'' +
                ", payback_time='" + payback_time + '\'' +
                ", send_time='" + send_time + '\'' +
                ", getdell_time='" + getdell_time + '\'' +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                ", esc_reason='" + esc_reason + '\'' +
                ", seller_id='" + seller_id + '\'' +
                '}';
    }
}