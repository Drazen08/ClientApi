package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 孙文剑 on 2016/8/5 0005.
 */
public class ShopClass extends AbstractBaseEntity {
    /*
     `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(45) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `create_time` varchar(45) DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private Integer pid;
    private String  class_name;
    private String create_time;
    private String  str_day ;
    private String  str_month;
    private String  str_year;
    public ShopClass(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
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

        ShopClass shopClass = (ShopClass) o;

        if (id != null ? !id.equals(shopClass.id) : shopClass.id != null) return false;
        if (pid != null ? !pid.equals(shopClass.pid) : shopClass.pid != null) return false;
        if (class_name != null ? !class_name.equals(shopClass.class_name) : shopClass.class_name != null) return false;
        if (create_time != null ? !create_time.equals(shopClass.create_time) : shopClass.create_time != null)
            return false;
        if (str_day != null ? !str_day.equals(shopClass.str_day) : shopClass.str_day != null) return false;
        if (str_month != null ? !str_month.equals(shopClass.str_month) : shopClass.str_month != null) return false;
        return !(str_year != null ? !str_year.equals(shopClass.str_year) : shopClass.str_year != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (class_name != null ? class_name.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (str_day != null ? str_day.hashCode() : 0);
        result = 31 * result + (str_month != null ? str_month.hashCode() : 0);
        result = 31 * result + (str_year != null ? str_year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShopClass{" +
                "id=" + id +
                ", pid=" + pid +
                ", class_name='" + class_name + '\'' +
                ", create_time=" + create_time +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
