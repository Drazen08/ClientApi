package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public class GoodEvaluate extends AbstractBaseEntity {
    /*
    `id` int(11) NOT NULL AUTO_INCREMENT,
  `good_Id` int(11) NOT NULL,
  `order_Id` int(11) DEFAULT NULL,
  `good_star` int(11) DEFAULT NULL,
  `good_content` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private Integer good_id;
    private String order_id;
    private Integer good_star;
    private String  good_content;
    private String create_time;
    private String str_day;
    private String str_month;
    private String str_year;
    public GoodEvaluate(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGood_id() {
        return good_id;
    }

    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getGood_star() {
        return good_star;
    }

    public void setGood_star(Integer good_star) {
        this.good_star = good_star;
    }

    public String getGood_content() {
        return good_content;
    }

    public void setGood_content(String good_content) {
        this.good_content = good_content;
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

        GoodEvaluate that = (GoodEvaluate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (good_id != null ? !good_id.equals(that.good_id) : that.good_id != null) return false;
        if (order_id != null ? !order_id.equals(that.order_id) : that.order_id != null) return false;
        if (good_star != null ? !good_star.equals(that.good_star) : that.good_star != null) return false;
        if (good_content != null ? !good_content.equals(that.good_content) : that.good_content != null) return false;
        if (create_time != null ? !create_time.equals(that.create_time) : that.create_time != null) return false;
        if (str_day != null ? !str_day.equals(that.str_day) : that.str_day != null) return false;
        if (str_month != null ? !str_month.equals(that.str_month) : that.str_month != null) return false;
        return !(str_year != null ? !str_year.equals(that.str_year) : that.str_year != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (good_id != null ? good_id.hashCode() : 0);
        result = 31 * result + (order_id != null ? order_id.hashCode() : 0);
        result = 31 * result + (good_star != null ? good_star.hashCode() : 0);
        result = 31 * result + (good_content != null ? good_content.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (str_day != null ? str_day.hashCode() : 0);
        result = 31 * result + (str_month != null ? str_month.hashCode() : 0);
        result = 31 * result + (str_year != null ? str_year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GoodEvaluate{" +
                "id=" + id +
                ", good_id=" + good_id +
                ", order_id='" + order_id + '\'' +
                ", good_star=" + good_star +
                ", good_content='" + good_content + '\'' +
                ", create_time='" + create_time + '\'' +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
