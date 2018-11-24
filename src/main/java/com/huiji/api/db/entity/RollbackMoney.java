package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by Administrator on 2016/9/13.
 */
public class RollbackMoney  extends AbstractBaseEntity {
    /*
    `id` int(11) NOT NULL AUTO_INCREMENT,
  `` varchar(45) DEFAULT NULL,
  `relative_id` varchar(45) DEFAULT NULL,
  `relative_type` int(11) DEFAULT NULL,
  `change_money` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private String  uid;
    private String  bill_id;
    private String  relative_id;
    private Integer  relative_type;
    private Long    change_money;
    private String  rollback_reason;
    private String  create_time;
    private String  str_day;
    private String  str_month ;
    private String  str_year;
    public RollbackMoney(){}

    public RollbackMoney(Integer id, String uid, String bill_id, String relative_id, Integer relative_type, Long change_money, String rollback_reason, String create_time, String str_day, String str_month, String str_year) {
        this.id = id;
        this.uid = uid;
        this.bill_id = bill_id;
        this.relative_id = relative_id;
        this.relative_type = relative_type;
        this.change_money = change_money;
        this.rollback_reason = rollback_reason;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public RollbackMoney(String uid, String bill_id, String relative_id, Integer relative_type, Long change_money, String rollback_reason, String create_time, String str_day, String str_month, String str_year) {
        this.uid = uid;
        this.bill_id = bill_id;
        this.relative_id = relative_id;
        this.relative_type = relative_type;
        this.change_money = change_money;
        this.rollback_reason = rollback_reason;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public String getRelative_id() {
        return relative_id;
    }

    public void setRelative_id(String relative_id) {
        this.relative_id = relative_id;
    }

    public Integer getRelative_type() {
        return relative_type;
    }

    public void setRelative_type(Integer relative_type) {
        this.relative_type = relative_type;
    }

    public Long getChange_money() {
        return change_money;
    }

    public void setChange_money(Long change_money) {
        this.change_money = change_money;
    }

    public String getRollback_reason() {
        return rollback_reason;
    }

    public void setRollback_reason(String rollback_reason) {
        this.rollback_reason = rollback_reason;
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

        RollbackMoney that = (RollbackMoney) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "RollbackMoney{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", bill_id='" + bill_id + '\'' +
                ", relative_id='" + relative_id + '\'' +
                ", relative_type=" + relative_type +
                ", change_money=" + change_money +
                ", rollback_reason='" + rollback_reason + '\'' +
                ", create_time='" + create_time + '\'' +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
