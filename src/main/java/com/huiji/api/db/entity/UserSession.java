package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 孙文剑 on 2016/7/17 0017.
 */
public class UserSession extends AbstractBaseEntity {
    public UserSession(){}
    /*
     `id` int(11) NOT NULL,
  `uid` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `sid` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `product_id` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `expired_time` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
     */
    private Integer id;
    private String  uid;
    private String  sid;
    private String  product_id;
    private String expired_time;
    private String create_time;
    private String str_day;
    private String str_month;
    private String str_year;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getExpired_time() {
        return expired_time;
    }

    public void setExpired_time(String expired_time) {
        this.expired_time = expired_time;
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

        UserSession that = (UserSession) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (product_id != null ? !product_id.equals(that.product_id) : that.product_id != null) return false;
        if (expired_time != null ? !expired_time.equals(that.expired_time) : that.expired_time != null) return false;
        if (create_time != null ? !create_time.equals(that.create_time) : that.create_time != null) return false;
        if (str_day != null ? !str_day.equals(that.str_day) : that.str_day != null) return false;
        if (str_month != null ? !str_month.equals(that.str_month) : that.str_month != null) return false;
        return !(str_year != null ? !str_year.equals(that.str_year) : that.str_year != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (product_id != null ? product_id.hashCode() : 0);
        result = 31 * result + (expired_time != null ? expired_time.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (str_day != null ? str_day.hashCode() : 0);
        result = 31 * result + (str_month != null ? str_month.hashCode() : 0);
        result = 31 * result + (str_year != null ? str_year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", sid='" + sid + '\'' +
                ", product_id='" + product_id + '\'' +
                ", expired_time=" + expired_time +
                ", create_time=" + create_time +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
