package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by Jingxiang on 2016/8/5.
 */
public class UserAct extends AbstractBaseEntity {
    public UserAct(){}
    private Integer id;
    private String  uid;
    private String  bill_id;
    //资金变动性质
    private Integer act_type;
    private String  bill_id_type;
    private String  url;
    private String  type;
    private Long    change_money;
    private Long    before_money;
    private Long    after_money;
    private Long    balance1000;
    private Long    balance2000;
    private String  opt_desc;
    private String create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;

    public UserAct(Integer id, String uid, String bill_id, Integer act_type, String bill_id_type, String url, String type, Long change_money, Long before_money, Long after_money, Long balance1000, Long balance2000, String opt_desc, String create_time, String str_day, String str_month, String str_year) {
        this.id = id;
        this.uid = uid;
        this.bill_id = bill_id;
        this.act_type = act_type;
        this.bill_id_type = bill_id_type;
        this.url = url;
        this.type = type;
        this.change_money = change_money;
        this.before_money = before_money;
        this.after_money = after_money;
        this.balance1000 = balance1000;
        this.balance2000 = balance2000;
        this.opt_desc = opt_desc;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public UserAct(String uid, String bill_id, Integer act_type, String bill_id_type, String url, String type, Long change_money, Long before_money, Long after_money, Long balance1000, Long balance2000, String opt_desc, String create_time, String str_day, String str_month, String str_year) {
        this.uid = uid;
        this.bill_id = bill_id;
        this.act_type = act_type;
        this.bill_id_type = bill_id_type;
        this.url = url;
        this.type = type;
        this.change_money = change_money;
        this.before_money = before_money;
        this.after_money = after_money;
        this.balance1000 = balance1000;
        this.balance2000 = balance2000;
        this.opt_desc = opt_desc;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public String getBill_id_type() {
        return bill_id_type;
    }

    public void setBill_id_type(String bill_id_type) {
        this.bill_id_type = bill_id_type;
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

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public Integer getAct_type() {
        return act_type;
    }

    public void setAct_type(Integer act_type) {
        this.act_type = act_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getChange_money() {
        return change_money;
    }

    public void setChange_money(Long change_money) {
        this.change_money = change_money;
    }

    public Long getBefore_money() {
        return before_money;
    }

    public void setBefore_money(Long before_money) {
        this.before_money = before_money;
    }

    public Long getAfter_money() {
        return after_money;
    }

    public void setAfter_money(Long after_money) {
        this.after_money = after_money;
    }

    public Long getBalance1000() {
        return balance1000;
    }

    public void setBalance1000(Long balance1000) {
        this.balance1000 = balance1000;
    }

    public Long getBalance2000() {
        return balance2000;
    }

    public void setBalance2000(Long balance2000) {
        this.balance2000 = balance2000;
    }

    public String getOpt_desc() {
        return opt_desc;
    }

    public void setOpt_desc(String opt_desc) {
        this.opt_desc = opt_desc;
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
        if (!(o instanceof UserAct)) return false;

        UserAct userAct = (UserAct) o;

        return getId().equals(userAct.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();

    }

    @Override
    public String toString() {
        return "UserAct{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", bill_id='" + bill_id + '\'' +
                ", act_type=" + act_type +
                ", bill_id_type='" + bill_id_type + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", change_money=" + change_money +
                ", before_money=" + before_money +
                ", after_money=" + after_money +
                ", balance1000=" + balance1000 +
                ", balance2000=" + balance2000 +
                ", opt_desc='" + opt_desc + '\'' +
                ", create_time='" + create_time + '\'' +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
