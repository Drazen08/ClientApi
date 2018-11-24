package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 孙文剑 on 2016/8/4 0004.
 */
public class UserBank extends AbstractBaseEntity {
    /*
    `id` int(11) NOT NULL,
  `uid` varchar(45) DEFAULT NULL,
  `cardid` varchar(45) DEFAULT NULL COMMENT '卡号',
  `banktype` varchar(45) DEFAULT NULL COMMENT '银行名称',
  `name` varchar(45) DEFAULT NULL COMMENT '持卡人',
  `userphone` varchar(45) DEFAULT NULL COMMENT '开户人手机号',
  `create_time` varchar(45) DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private String uid;
    private String cardid;
    private String banktype;
    private String name;
    private String userphone;
    private String create_time;
    private String str_day;
    private String str_month;
    private String str_year;
    public UserBank(){}

    public UserBank(String uid, String cardid, String banktype, String name, String userphone, String create_time, String str_day, String str_month, String str_year) {
        this.uid = uid;
        this.cardid = cardid;
        this.banktype = banktype;
        this.name = name;
        this.userphone = userphone;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getBanktype() {
        return banktype;
    }

    public void setBanktype(String banktype) {
        this.banktype = banktype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
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

        UserBank userBank = (UserBank) o;

        if (id != null ? !id.equals(userBank.id) : userBank.id != null) return false;
        if (uid != null ? !uid.equals(userBank.uid) : userBank.uid != null) return false;
        if (cardid != null ? !cardid.equals(userBank.cardid) : userBank.cardid != null) return false;
        if (banktype != null ? !banktype.equals(userBank.banktype) : userBank.banktype != null) return false;
        if (name != null ? !name.equals(userBank.name) : userBank.name != null) return false;
        if (userphone != null ? !userphone.equals(userBank.userphone) : userBank.userphone != null) return false;
        if (create_time != null ? !create_time.equals(userBank.create_time) : userBank.create_time != null)
            return false;
        if (str_day != null ? !str_day.equals(userBank.str_day) : userBank.str_day != null) return false;
        if (str_month != null ? !str_month.equals(userBank.str_month) : userBank.str_month != null) return false;
        return !(str_year != null ? !str_year.equals(userBank.str_year) : userBank.str_year != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (cardid != null ? cardid.hashCode() : 0);
        result = 31 * result + (banktype != null ? banktype.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (userphone != null ? userphone.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (str_day != null ? str_day.hashCode() : 0);
        result = 31 * result + (str_month != null ? str_month.hashCode() : 0);
        result = 31 * result + (str_year != null ? str_year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserBank{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", cardid='" + cardid + '\'' +
                ", banktype='" + banktype + '\'' +
                ", name='" + name + '\'' +
                ", userphone='" + userphone + '\'' +
                ", create_time=" + create_time +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
