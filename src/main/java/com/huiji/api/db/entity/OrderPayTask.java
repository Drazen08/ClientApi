package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
public class OrderPayTask extends AbstractBaseEntity {
    /*
     `id` int(11) NOT NULL AUTO_INCREMENT,
  `pay_code_id` varchar(45) NOT NULL COMMENT '支付单号id',
  `order_id` varchar(45) NOT NULL,
  `uid` varchar(45) CHARACTER SET utf8 NOT NULL,
  `pay_price` bigint(45) NOT NULL,
  `pay_balance` bigint(45) NOT NULL,
  `status` int(45) NOT NULL COMMENT '1000 : 未执行',
  `type` int(11) NOT NULL COMMENT '1 支付宝支付  2威信支付 ',
  `oper_num` varchar(45) NOT NULL,
  `oper_time` datetime(6) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    private  Integer id;
    private  String  bill_id;
    private  String  running_number;
    private  String  order_id;
    private  String  uid;
    private  Long    pay_price;
    private  Long    pay_balance;
    private  Integer state;
    private  Integer type;
    private  Integer opt_num;
    private  String opt_time;
    private  String  create_time;
    private  String  str_day;
    private  String  str_month;
    private  String  str_year;
    public OrderPayTask(){}

    public OrderPayTask(Integer id, String bill_id, String running_number, String order_id, String uid, Long pay_price, Long pay_balance, Integer state, Integer type, Integer opt_num, String opt_time, String create_time, String str_day, String str_month, String str_year) {
        this.id = id;
        this.bill_id = bill_id;
        this.running_number = running_number;
        this.order_id = order_id;
        this.uid = uid;
        this.pay_price = pay_price;
        this.pay_balance = pay_balance;
        this.state = state;
        this.type = type;
        this.opt_num = opt_num;
        this.opt_time = opt_time;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public OrderPayTask(String bill_id, String running_number, String order_id, String uid, Long pay_price, Long pay_balance, Integer state, Integer type, Integer opt_num, String opt_time, String create_time, String str_day, String str_month, String str_year) {
        this.bill_id = bill_id;
        this.running_number = running_number;
        this.order_id = order_id;
        this.uid = uid;
        this.pay_price = pay_price;
        this.pay_balance = pay_balance;
        this.state = state;
        this.type = type;
        this.opt_num = opt_num;
        this.opt_time = opt_time;
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

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public String getRunning_number() {
        return running_number;
    }

    public void setRunning_number(String running_number) {
        this.running_number = running_number;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getPay_price() {
        return pay_price;
    }

    public void setPay_price(Long pay_price) {
        this.pay_price = pay_price;
    }

    public Long getPay_balance() {
        return pay_balance;
    }

    public void setPay_balance(Long pay_balance) {
        this.pay_balance = pay_balance;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOpt_num() {
        return opt_num;
    }

    public void setOpt_num(Integer opt_num) {
        this.opt_num = opt_num;
    }

    public String getOpt_time() {
        return opt_time;
    }

    public void setOpt_time(String opt_time) {
        this.opt_time = opt_time;
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
        if (!(o instanceof OrderPayTask)) return false;

        OrderPayTask that = (OrderPayTask) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "OrderPayTask{" +
                "id=" + id +
                ", bill_id='" + bill_id + '\'' +
                ", running_number='" + running_number + '\'' +
                ", order_id='" + order_id + '\'' +
                ", uid='" + uid + '\'' +
                ", pay_price=" + pay_price +
                ", pay_balance=" + pay_balance +
                ", state=" + state +
                ", type=" + type +
                ", opt_num=" + opt_num +
                ", opt_time='" + opt_time + '\'' +
                ", create_time='" + create_time + '\'' +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
