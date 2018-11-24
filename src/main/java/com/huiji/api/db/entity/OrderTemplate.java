package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public class OrderTemplate extends AbstractBaseEntity {
    /*
     `id` int(11) NOT NULL AUTO_INCREMENT,
  `good_id` int(11) NOT NULL COMMENT '商品共性的id',
  `sub_good_id` int(11) NOT NULL COMMENT '商品的子id',
  `buy_num` int(11) NOT NULL COMMENT '主商品的购买数量',
  `current_price` bigint(21) DEFAULT NULL COMMENT '主商品的当前价格',
  `pid` int(11) NOT NULL COMMENT '意向购买指向确定购买的商品id',
  `yu_price` bigint(21) DEFAULT NULL COMMENT '预选订单的价格',
  `create_time` varchar(45) DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private String template_id;
    private Integer shop_id;
    private Integer good_id;
    private Integer sub_good_id;
    private String good_pro;
    private Integer buy_num;
    private Long    current_price;
    private Long    marketPrice;
    private Long    postPrice;
    private Integer pid;
    private Long    yu_price;
    private Integer state;
    private String create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;
    public OrderTemplate(){}

    public OrderTemplate(Integer id, String template_id, Integer shop_id, Integer good_id, Integer sub_good_id, String good_pro, Integer buy_num, Long current_price, Long marketPrice, Long postPrice, Integer pid, Long yu_price, Integer state, String create_time, String str_day, String str_month, String str_year) {
        this.id = id;
        this.template_id = template_id;
        this.shop_id = shop_id;
        this.good_id = good_id;
        this.sub_good_id = sub_good_id;
        this.good_pro = good_pro;
        this.buy_num = buy_num;
        this.current_price = current_price;
        this.marketPrice = marketPrice;
        this.postPrice = postPrice;
        this.pid = pid;
        this.yu_price = yu_price;
        this.state = state;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public OrderTemplate(String template_id, Integer shop_id, Integer good_id, Integer sub_good_id, String good_pro, Integer buy_num, Long current_price, Long marketPrice, Long postPrice, Integer pid, Long yu_price, Integer state, String create_time, String str_day, String str_month, String str_year) {
        this.template_id = template_id;
        this.shop_id = shop_id;
        this.good_id = good_id;
        this.sub_good_id = sub_good_id;
        this.good_pro = good_pro;
        this.buy_num = buy_num;
        this.current_price = current_price;
        this.marketPrice = marketPrice;
        this.postPrice = postPrice;
        this.pid = pid;
        this.yu_price = yu_price;
        this.state = state;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public OrderTemplate(String template_id, Integer shop_id, Integer good_id, Integer sub_good_id, String good_pro, Integer buy_num, Long current_price, Long marketPrice, Long postPrice, Integer pid, Long yu_price, Integer state, String create_time) {
        this.template_id = template_id;
        this.shop_id = shop_id;
        this.good_id = good_id;
        this.sub_good_id = sub_good_id;
        this.good_pro = good_pro;
        this.buy_num = buy_num;
        this.current_price = current_price;
        this.marketPrice = marketPrice;
        this.postPrice = postPrice;
        this.pid = pid;
        this.yu_price = yu_price;
        this.state = state;
        this.create_time = create_time;
    }

    public Long getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Long marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Long getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(Long postPrice) {
        this.postPrice = postPrice;
    }

    public String getGood_pro() {
        return good_pro;
    }

    public void setGood_pro(String good_pro) {
        this.good_pro = good_pro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getGood_id() {
        return good_id;
    }

    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public Integer getSub_good_id() {
        return sub_good_id;
    }

    public void setSub_good_id(Integer sub_good_id) {
        this.sub_good_id = sub_good_id;
    }

    public Integer getBuy_num() {
        return buy_num;
    }

    public void setBuy_num(Integer buy_num) {
        this.buy_num = buy_num;
    }

    public Long getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(Long current_price) {
        this.current_price = current_price;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Long getYu_price() {
        return yu_price;
    }

    public void setYu_price(Long yu_price) {
        this.yu_price = yu_price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderTemplate)) return false;

        OrderTemplate that = (OrderTemplate) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "OrderTemplate{" +
                "id=" + id +
                ", template_id='" + template_id + '\'' +
                ", shop_id=" + shop_id +
                ", good_id=" + good_id +
                ", sub_good_id=" + sub_good_id +
                ", good_pro='" + good_pro + '\'' +
                ", buy_num=" + buy_num +
                ", current_price=" + current_price +
                ", marketPrice=" + marketPrice +
                ", postPrice=" + postPrice +
                ", pid=" + pid +
                ", yu_price=" + yu_price +
                ", state=" + state +
                ", create_time='" + create_time + '\'' +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
