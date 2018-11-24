package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 孙文剑 on 2016/8/11 0011.
 */
public class UserBalanceChange extends AbstractBaseEntity {
    public UserBalanceChange(){}
    /*
    `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(45) NOT NULL,
  `act_type` int(11) DEFAULT NULL COMMENT '资金变动性质（1充值、2. 从余额支付、3.提现、4.退款）',
  `url` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL COMMENT '+ -',
  `change_money` bigint(45) DEFAULT NULL COMMENT '变动金额',
  `change_time` varchar(45) DEFAULT NULL COMMENT '変动时间',
  `before_money` bigint(45) DEFAULT NULL COMMENT '变动前金额',
  `after_money` bigint(45) DEFAULT NULL COMMENT '变动后金额',
  `change_desc` varchar(45) DEFAULT NULL COMMENT '描述',
  `create_time` varchar(45) DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private String  uid;
    private Integer act_type;
    private String  url;
    private String  type;
    private Long    change_money;
    private String  change_time;
    private Long    before_money;
    private Long    after_money;
    private String  change_desc;
    private String create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;

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

    public String getChange_time() {
        return change_time;
    }

    public void setChange_time(String change_time) {
        this.change_time = change_time;
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

    public String getChange_desc() {
        return change_desc;
    }

    public void setChange_desc(String change_desc) {
        this.change_desc = change_desc;
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

        UserBalanceChange that = (UserBalanceChange) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (act_type != null ? !act_type.equals(that.act_type) : that.act_type != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (change_money != null ? !change_money.equals(that.change_money) : that.change_money != null) return false;
        if (change_time != null ? !change_time.equals(that.change_time) : that.change_time != null) return false;
        if (before_money != null ? !before_money.equals(that.before_money) : that.before_money != null) return false;
        if (after_money != null ? !after_money.equals(that.after_money) : that.after_money != null) return false;
        if (change_desc != null ? !change_desc.equals(that.change_desc) : that.change_desc != null) return false;
        if (create_time != null ? !create_time.equals(that.create_time) : that.create_time != null) return false;
        if (str_day != null ? !str_day.equals(that.str_day) : that.str_day != null) return false;
        if (str_month != null ? !str_month.equals(that.str_month) : that.str_month != null) return false;
        return !(str_year != null ? !str_year.equals(that.str_year) : that.str_year != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (act_type != null ? act_type.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (change_money != null ? change_money.hashCode() : 0);
        result = 31 * result + (change_time != null ? change_time.hashCode() : 0);
        result = 31 * result + (before_money != null ? before_money.hashCode() : 0);
        result = 31 * result + (after_money != null ? after_money.hashCode() : 0);
        result = 31 * result + (change_desc != null ? change_desc.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (str_day != null ? str_day.hashCode() : 0);
        result = 31 * result + (str_month != null ? str_month.hashCode() : 0);
        result = 31 * result + (str_year != null ? str_year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserBalanceChange{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", act_type=" + act_type +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", change_money=" + change_money +
                ", change_time='" + change_time + '\'' +
                ", before_money=" + before_money +
                ", after_money=" + after_money +
                ", change_desc='" + change_desc + '\'' +
                ", create_time=" + create_time +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
