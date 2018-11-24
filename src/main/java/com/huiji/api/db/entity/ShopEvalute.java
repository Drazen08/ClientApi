package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by Jingxiang on 2016/8/11.
 */
public class ShopEvalute extends AbstractBaseEntity {
    public ShopEvalute(){}

    private Integer id;
    private Integer shop_id;
    private String order_id;
    private Integer shop_star;
    private Integer  logistical_star;
    private String create_time;
    private String str_day;
    private String str_month;
    private  String str_year;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getShop_star() {
        return shop_star;
    }

    public void setShop_star(Integer shop_star) {
        this.shop_star = shop_star;
    }

    public Integer getLogistical_star() {
        return logistical_star;
    }

    public void setLogistical_star(Integer logistical_star) {
        this.logistical_star = logistical_star;
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

        ShopEvalute that = (ShopEvalute) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (shop_id != null ? !shop_id.equals(that.shop_id) : that.shop_id != null) return false;
        if (order_id != null ? !order_id.equals(that.order_id) : that.order_id != null) return false;
        if (shop_star != null ? !shop_star.equals(that.shop_star) : that.shop_star != null) return false;
        if (logistical_star != null ? !logistical_star.equals(that.logistical_star) : that.logistical_star != null)
            return false;
        if (create_time != null ? !create_time.equals(that.create_time) : that.create_time != null) return false;
        if (str_day != null ? !str_day.equals(that.str_day) : that.str_day != null) return false;
        if (str_month != null ? !str_month.equals(that.str_month) : that.str_month != null) return false;
        return !(str_year != null ? !str_year.equals(that.str_year) : that.str_year != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (shop_id != null ? shop_id.hashCode() : 0);
        result = 31 * result + (order_id != null ? order_id.hashCode() : 0);
        result = 31 * result + (shop_star != null ? shop_star.hashCode() : 0);
        result = 31 * result + (logistical_star != null ? logistical_star.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (str_day != null ? str_day.hashCode() : 0);
        result = 31 * result + (str_month != null ? str_month.hashCode() : 0);
        result = 31 * result + (str_year != null ? str_year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShopEvalute{" +
                "id=" + id +
                ", shop_id=" + shop_id +
                ", order_id='" + order_id + '\'' +
                ", shop_star=" + shop_star +
                ", logistical_star=" + logistical_star +
                ", create_time=" + create_time +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
