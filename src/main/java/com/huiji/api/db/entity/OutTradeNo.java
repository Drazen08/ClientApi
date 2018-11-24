package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/18.
 */
public class OutTradeNo extends AbstractBaseEntity {
    /*
    `id` int(11) NOT NULL,
  `order_id` varchar(45) DEFAULT NULL,
  `out_trade_no` varchar(100) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */


    private Integer id;
    private String  order_id;
    private String  out_trade_no;
    private String  sub_order_id;
    private Integer type;
    private Date    create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;
    public OutTradeNo(){}
    public OutTradeNo(Integer id, String order_id, String out_trade_no, String sub_order_id, Integer type, Date create_time, String str_day, String str_month, String str_year) {
        this.id = id;
        this.order_id = order_id;
        this.out_trade_no = out_trade_no;
        this.sub_order_id = sub_order_id;
        this.type = type;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public OutTradeNo(String order_id, String out_trade_no, String sub_order_id, Integer type, Date create_time, String str_day, String str_month, String str_year) {
        this.order_id = order_id;
        this.out_trade_no = out_trade_no;
        this.sub_order_id = sub_order_id;
        this.type = type;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public String getSub_order_id() {
        return sub_order_id;
    }

    public void setSub_order_id(String sub_order_id) {
        this.sub_order_id = sub_order_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
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

        OutTradeNo that = (OutTradeNo) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "OutTradeNo{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", sub_order_id='" + sub_order_id + '\'' +
                ", type=" + type +
                ", create_time=" + create_time +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
