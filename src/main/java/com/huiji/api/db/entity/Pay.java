package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 孙文剑 on 2016/8/8 0008.
 */
public class Pay extends AbstractBaseEntity {
    /*
    `id` int(11) NOT NULL AUTO_INCREMENT,
  `describe` varchar(45) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `create_time` varchar(45) DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private String  describe;
    private String  url;
    private String create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;
    public Pay(){}
    public Pay(Integer id, String describe, String url, String create_time, String str_day, String str_month, String str_year) {
        this.id = id;
        this.describe = describe;
        this.url = url;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(o instanceof Pay)) return false;

        Pay pay = (Pay) o;

        return getId().equals(pay.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "Pay{" +
                "id=" + id +
                ", describe='" + describe + '\'' +
                ", url='" + url + '\'' +
                ", create_time='" + create_time + '\'' +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
