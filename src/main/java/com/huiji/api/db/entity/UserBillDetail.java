package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 孙文剑 on 2016/8/13 0013.
 */
public class UserBillDetail extends AbstractBaseEntity {
    /*
     `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(45) NOT NULL,
  `bill_id` varchar(45) NOT NULL,
  `order_id` varchar(45) NOT NULL,
  `pay_price` bigint(45) NOT NULL DEFAULT '0' COMMENT '际实支付金额',
  `pay_balance` bigint(45) DEFAULT '0',
  `type` int(11) DEFAULT NULL COMMENT '1支付宝 2微信 3余额',
  `state` int(11) DEFAULT NULL COMMENT '此次账单的状态 10success 20 fail  ',
  `create_time` datetime(6) NOT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `srt_year` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private String out_trade_no;
    private String running_number;
    private String  uid;
    private String  bill_id;
    private String  order_id;
    private Long order_price;
    private Long    pay_price;
    private Long    pay_balance;
    private Long    blance1000;
    private Long    blance2000;
    private Integer type;
    private Integer state;
    private String  create_time;
    private Date    pay_result_time;
    private String  str_day;
    private String  str_month;
    private String  srt_year;

    public UserBillDetail() {

    }

    public UserBillDetail(Integer id, String out_trade_no, String running_number, String uid, String bill_id, String order_id, Long order_price, Long pay_price, Long pay_balance, Long blance1000, Long blance2000, Integer type, Integer state, String create_time, Date pay_result_time, String str_day, String str_month, String srt_year) {
        this.id = id;
        this.out_trade_no = out_trade_no;
        this.running_number = running_number;
        this.uid = uid;
        this.bill_id = bill_id;
        this.order_id = order_id;
        this.order_price = order_price;
        this.pay_price = pay_price;
        this.pay_balance = pay_balance;
        this.blance1000 = blance1000;
        this.blance2000 = blance2000;
        this.type = type;
        this.state = state;
        this.create_time = create_time;
        this.pay_result_time = pay_result_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.srt_year = srt_year;
    }

    public UserBillDetail(String out_trade_no, String running_number, String uid, String bill_id, String order_id, Long order_price, Long pay_price, Long pay_balance, Long blance1000, Long blance2000, Integer type, Integer state, String create_time, Date pay_result_time, String str_day, String str_month, String srt_year) {
        this.out_trade_no = out_trade_no;
        this.running_number = running_number;
        this.uid = uid;
        this.bill_id = bill_id;
        this.order_id = order_id;
        this.order_price = order_price;
        this.pay_price = pay_price;
        this.pay_balance = pay_balance;
        this.blance1000 = blance1000;
        this.blance2000 = blance2000;
        this.type = type;
        this.state = state;
        this.create_time = create_time;
        this.pay_result_time = pay_result_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.srt_year = srt_year;
    }

    public Date getPay_result_time() {
        return pay_result_time;
    }

    public void setPay_result_time(Date pay_result_time) {
        this.pay_result_time = pay_result_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getRunning_number() {
        return running_number;
    }

    public void setRunning_number(String running_number) {
        this.running_number = running_number;
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

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Long getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Long order_price) {
        this.order_price = order_price;
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

    public Long getBlance1000() {
        return blance1000;
    }

    public void setBlance1000(Long blance1000) {
        this.blance1000 = blance1000;
    }

    public Long getBlance2000() {
        return blance2000;
    }

    public void setBlance2000(Long blance2000) {
        this.blance2000 = blance2000;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public String getSrt_year() {
        return srt_year;
    }

    public void setSrt_year(String srt_year) {
        this.srt_year = srt_year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBillDetail that = (UserBillDetail) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }


}
