package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/31.
 */
public class OrderLogistics extends AbstractBaseEntity {
    /*
        `id` int(11) NOT NULL,
  `order_id` varchar(45) DEFAULT NULL,
  `logistic_name` varchar(45) DEFAULT NULL COMMENT '物流公司名称',
  `logistic_num` varchar(45) DEFAULT NULL COMMENT '物流单号',
  `return_remarks` varchar(500) DEFAULT NULL,
  `create_time` varchar(45) DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private String  order_id;
    private String  logistic_name;
    private String  logistic_num;
    private String  return_remarks;
    private Date    create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;

    public OrderLogistics() {
    }

    public OrderLogistics(Integer id, String order_id, String logistic_name, String logistic_num, String return_remarks, Date create_time, String str_day, String str_month, String str_year) {
        this.id = id;
        this.order_id = order_id;
        this.logistic_name = logistic_name;
        this.logistic_num = logistic_num;
        this.return_remarks = return_remarks;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public OrderLogistics(String order_id, String logistic_name, String logistic_num, String return_remarks, Date create_time, String str_day, String str_month, String str_year) {
        this.order_id = order_id;
        this.logistic_name = logistic_name;
        this.logistic_num = logistic_num;
        this.return_remarks = return_remarks;
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

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getLogistic_name() {
        return logistic_name;
    }

    public void setLogistic_name(String logistic_name) {
        this.logistic_name = logistic_name;
    }

    public String getLogistic_num() {
        return logistic_num;
    }

    public void setLogistic_num(String logistic_num) {
        this.logistic_num = logistic_num;
    }

    public String getReturn_remarks() {
        return return_remarks;
    }

    public void setReturn_remarks(String return_remarks) {
        this.return_remarks = return_remarks;
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

        OrderLogistics that = (OrderLogistics) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "OrderLogistics{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", logistic_name='" + logistic_name + '\'' +
                ", logistic_num='" + logistic_num + '\'' +
                ", return_remarks='" + return_remarks + '\'' +
                ", create_time=" + create_time +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
