package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public class SubGoods extends AbstractBaseEntity {
    /*
     `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_pid` varchar(45) DEFAULT NULL COMMENT '商品共性id',
  `goods_spec_id` varchar(45) DEFAULT NULL COMMENT '商品规格id',
  `goods_spec_desc` varchar(45) DEFAULT NULL COMMENT '商品规格描述',
  `goods_spec` varchar(45) DEFAULT NULL COMMENT '(color#size)',
  `num` int(11) DEFAULT NULL COMMENT '卖出数量',
  `price` bigInt(45) DEFAULT NULL COMMENT '商品',
  `create_time` varchar(45) DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private String  goods_pid;
    private String  goods_spec_id;
    private String  goods_spec_desc;
    private String  goods_spec;
    private Integer num;
    private Long    price;
    private Long    market_Price;
    private String create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;
    public SubGoods(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoods_pid() {
        return goods_pid;
    }

    public void setGoods_pid(String goods_pid) {
        this.goods_pid = goods_pid;
    }

    public String getGoods_spec_id() {
        return goods_spec_id;
    }

    public void setGoods_spec_id(String goods_spec_id) {
        this.goods_spec_id = goods_spec_id;
    }

    public String getGoods_spec_desc() {
        return goods_spec_desc;
    }

    public void setGoods_spec_desc(String goods_spec_desc) {
        this.goods_spec_desc = goods_spec_desc;
    }

    public String getGoods_spec() {
        return goods_spec;
    }

    public void setGoods_spec(String goods_spec) {
        this.goods_spec = goods_spec;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getMarket_Price() {
        return market_Price;
    }

    public void setMarket_Price(Long market_Price) {
        this.market_Price = market_Price;
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
        if (o == null || getClass() != o.getClass()) return false;

        SubGoods subGoods = (SubGoods) o;

        if (id != null ? !id.equals(subGoods.id) : subGoods.id != null) return false;
        if (goods_pid != null ? !goods_pid.equals(subGoods.goods_pid) : subGoods.goods_pid != null) return false;
        if (goods_spec_id != null ? !goods_spec_id.equals(subGoods.goods_spec_id) : subGoods.goods_spec_id != null)
            return false;
        if (goods_spec_desc != null ? !goods_spec_desc.equals(subGoods.goods_spec_desc) : subGoods.goods_spec_desc != null)
            return false;
        if (goods_spec != null ? !goods_spec.equals(subGoods.goods_spec) : subGoods.goods_spec != null) return false;
        if (num != null ? !num.equals(subGoods.num) : subGoods.num != null) return false;
        if (price != null ? !price.equals(subGoods.price) : subGoods.price != null) return false;
        if (market_Price != null ? !market_Price.equals(subGoods.market_Price) : subGoods.market_Price != null)
            return false;
        if (create_time != null ? !create_time.equals(subGoods.create_time) : subGoods.create_time != null)
            return false;
        if (str_day != null ? !str_day.equals(subGoods.str_day) : subGoods.str_day != null) return false;
        if (str_month != null ? !str_month.equals(subGoods.str_month) : subGoods.str_month != null) return false;
        return !(str_year != null ? !str_year.equals(subGoods.str_year) : subGoods.str_year != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (goods_pid != null ? goods_pid.hashCode() : 0);
        result = 31 * result + (goods_spec_id != null ? goods_spec_id.hashCode() : 0);
        result = 31 * result + (goods_spec_desc != null ? goods_spec_desc.hashCode() : 0);
        result = 31 * result + (goods_spec != null ? goods_spec.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (market_Price != null ? market_Price.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (str_day != null ? str_day.hashCode() : 0);
        result = 31 * result + (str_month != null ? str_month.hashCode() : 0);
        result = 31 * result + (str_year != null ? str_year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SubGoods{" +
                "id=" + id +
                ", goods_pid='" + goods_pid + '\'' +
                ", goods_spec_id='" + goods_spec_id + '\'' +
                ", goods_spec_desc='" + goods_spec_desc + '\'' +
                ", goods_spec='" + goods_spec + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", market_Price=" + market_Price +
                ", create_time=" + create_time +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
