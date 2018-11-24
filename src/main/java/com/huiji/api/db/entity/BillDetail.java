package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by Jingxiang on 2016/8/22.
 */
public class BillDetail extends AbstractBaseEntity {

    /*
    * `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(45) NOT NULL,
  `bill_id` varchar(45) NOT NULL,
  `order_id` varchar(45) NOT NULL,
  `pay_price` bigint(45) NOT NULL DEFAULT '0' COMMENT '际实支付金额',
  `pay_balance` bigint(45) DEFAULT '0',
  `type` int(11) DEFAULT NULL COMMENT '1支付宝 2微信 3余额',
  `state` int(11) DEFAULT NULL COMMENT '此次账单的状态 10success 20 fail  ',
  `create_time` datetime NOT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `srt_year` varchar(45) DEFAULT NULL,*/
    public BillDetail(){}
    private Integer id;
    private String bill_id;
    private String uid;
    private String order_id;
    private long pay_price;
    private long pay_balance;
    //'1支付宝 2微信 3余额',
    private Integer type;
    //'此次账单的状态 10success 20 fail  '
    private Integer state;
    private String create_time;
    private String str_day;
    private String str_month;
    private String srt_year;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public long getPay_price() {
        return pay_price;
    }

    public void setPay_price(long pay_price) {
        this.pay_price = pay_price;
    }

    public long getPay_balance() {
        return pay_balance;
    }

    public void setPay_balance(long pay_balance) {
        this.pay_balance = pay_balance;
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

        BillDetail that = (BillDetail) o;

        if (pay_price != that.pay_price) return false;
        if (pay_balance != that.pay_balance) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (bill_id != null ? !bill_id.equals(that.bill_id) : that.bill_id != null) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (order_id != null ? !order_id.equals(that.order_id) : that.order_id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (create_time != null ? !create_time.equals(that.create_time) : that.create_time != null) return false;
        if (str_day != null ? !str_day.equals(that.str_day) : that.str_day != null) return false;
        if (str_month != null ? !str_month.equals(that.str_month) : that.str_month != null) return false;
        if (srt_year != null ? !srt_year.equals(that.srt_year) : that.srt_year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bill_id != null ? bill_id.hashCode() : 0);
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (order_id != null ? order_id.hashCode() : 0);
        result = 31 * result + (int) (pay_price ^ (pay_price >>> 32));
        result = 31 * result + (int) (pay_balance ^ (pay_balance >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (str_day != null ? str_day.hashCode() : 0);
        result = 31 * result + (str_month != null ? str_month.hashCode() : 0);
        result = 31 * result + (srt_year != null ? srt_year.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "BillDetail{" +
                "id=" + id +
                ", bill_id='" + bill_id + '\'' +
                ", uid='" + uid + '\'' +
                ", order_id='" + order_id + '\'' +
                ", pay_price=" + pay_price +
                ", pay_balance=" + pay_balance +
                ", type=" + type +
                ", state=" + state +
                ", create_time='" + create_time + '\'' +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", srt_year='" + srt_year + '\'' +
                '}';
    }
}
