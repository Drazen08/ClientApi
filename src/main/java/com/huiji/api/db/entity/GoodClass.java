package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by Jingxiang on 2016/8/13.
 */
public class GoodClass extends AbstractBaseEntity {
    private GoodClass(){}
        private Integer id;
        private String class_name;
        private Integer pid;
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

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

        GoodClass goodClass = (GoodClass) o;

        if (id != null ? !id.equals(goodClass.id) : goodClass.id != null) return false;
        if (class_name != null ? !class_name.equals(goodClass.class_name) : goodClass.class_name != null) return false;
        if (pid != null ? !pid.equals(goodClass.pid) : goodClass.pid != null) return false;
        if (create_time != null ? !create_time.equals(goodClass.create_time) : goodClass.create_time != null)
            return false;
        if (str_day != null ? !str_day.equals(goodClass.str_day) : goodClass.str_day != null) return false;
        if (str_month != null ? !str_month.equals(goodClass.str_month) : goodClass.str_month != null) return false;
        return !(str_year != null ? !str_year.equals(goodClass.str_year) : goodClass.str_year != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (class_name != null ? class_name.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (str_day != null ? str_day.hashCode() : 0);
        result = 31 * result + (str_month != null ? str_month.hashCode() : 0);
        result = 31 * result + (str_year != null ? str_year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GoodClass{" +
                "id=" + id +
                ", class_name='" + class_name + '\'' +
                ", pid=" + pid +
                ", create_time=" + create_time +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
