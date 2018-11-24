package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 王潇雨 on 2016/7/16.
 */
public class UserEntity extends AbstractBaseEntity {
    public UserEntity(){}
    private int id;
    private String uid;
    private String phone;
    private String username;
    private String pwd;
    private String nickname;
    private String paypwd;
    private String create_time;
    private String str_day;
    private String str_month;
    private String str_year;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPaypwd() {
        return paypwd;
    }

    public void setPaypwd(String paypwd) {
        this.paypwd = paypwd;
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

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (paypwd != null ? !paypwd.equals(that.paypwd) : that.paypwd != null) return false;
        if (create_time != null ? !create_time.equals(that.create_time) : that.create_time != null) return false;
        if (str_day != null ? !str_day.equals(that.str_day) : that.str_day != null) return false;
        if (str_month != null ? !str_month.equals(that.str_month) : that.str_month != null) return false;
        return !(str_year != null ? !str_year.equals(that.str_year) : that.str_year != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (paypwd != null ? paypwd.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (str_day != null ? str_day.hashCode() : 0);
        result = 31 * result + (str_month != null ? str_month.hashCode() : 0);
        result = 31 * result + (str_year != null ? str_year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", paypwd='" + paypwd + '\'' +
                ", create_time=" + create_time +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
