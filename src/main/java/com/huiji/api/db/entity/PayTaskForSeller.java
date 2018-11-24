package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/8/11 0011.
 */
public class PayTaskForSeller extends AbstractBaseEntity {
    /*
    `id` int(11) NOT NULL AUTO_INCREMENT,
  `pay_code_id` varchar(45) NOT NULL COMMENT '支付单号id',
  `order_id` varchar(45) NOT NULL,
  `uid` varchar(45) CHARACTER SET utf8 NOT NULL,
  `pay_price` bigint(45) NOT NULL,
  `state` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '状态 0未操作 1成功    2失败',
  `type` int(11) NOT NULL COMMENT '1 支付宝支付 ',
  `oper_num` int(45) NOT NULL,
  `oper_time` varchar(45) DEFAULT NULL,
  `create_time` varchar(45) DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private String  pay_code_id;
    private String  order_id;
    private String  uid;
    private Long    pay_price;
    private String  state;
    private Integer type;
    private Integer oper_num;
    private String  oper_time ;
    private String  create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;

    public PayTaskForSeller(Integer id, String pay_code_id, String order_id, String uid, Long pay_price, String state, Integer type, Integer oper_num, String oper_time, String create_time, String str_day, String str_month, String str_year) {
        this.id = id;
        this.pay_code_id = pay_code_id;
        this.order_id = order_id;
        this.uid = uid;
        this.pay_price = pay_price;
        this.state = state;
        this.type = type;
        this.oper_num = oper_num;
        this.oper_time = oper_time;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public PayTaskForSeller(String pay_code_id, String order_id, String uid, Long pay_price, String state, Integer type, Integer oper_num, String oper_time, String create_time, String str_day, String str_month, String str_year) {
        this.pay_code_id = pay_code_id;
        this.order_id = order_id;
        this.uid = uid;
        this.pay_price = pay_price;
        this.state = state;
        this.type = type;
        this.oper_num = oper_num;
        this.oper_time = oper_time;
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

    public String getPay_code_id() {
        return pay_code_id;
    }

    public void setPay_code_id(String pay_code_id) {
        this.pay_code_id = pay_code_id;
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

    public String getstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOper_num() {
        return oper_num;
    }

    public void setOper_num(Integer oper_num) {
        this.oper_num = oper_num;
    }

    public String getOper_time() {
        return oper_time;
    }

    public void setOper_time(String oper_time) {
        this.oper_time = oper_time;
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
        if (!(o instanceof PayTaskForSeller)) return false;

        PayTaskForSeller that = (PayTaskForSeller) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "PayTaskForSeller{" +
                "id=" + id +
                ", pay_code_id='" + pay_code_id + '\'' +
                ", order_id='" + order_id + '\'' +
                ", uid='" + uid + '\'' +
                ", pay_price=" + pay_price +
                ", state='" + state + '\'' +
                ", type=" + type +
                ", oper_num=" + oper_num +
                ", oper_time='" + oper_time + '\'' +
                ", create_time='" + create_time + '\'' +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
