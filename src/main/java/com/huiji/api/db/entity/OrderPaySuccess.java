package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/21.
 */
public class OrderPaySuccess extends AbstractBaseEntity {
    /*
    `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(45) NOT NULL,
  `pay_success_time` datetime NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '1:可操作   2:操作已失效',
  `create_time` datetime NOT NULL,
     */
    private Integer id;
    private String  uid;
    private String  bill_id;
    private String  order_id;
    private Long    pay_price;
    private Long    cash_pirce;
    private Date    pay_success_time;
    private Integer state;
    private Integer pay_type;
    private Date    create_time;

    public OrderPaySuccess() {
    }

    public OrderPaySuccess(Integer id, String uid, String bill_id, String order_id, Long pay_price, Long cash_pirce, Date pay_success_time, Integer state, Integer pay_type, Date create_time) {
        this.id = id;
        this.uid = uid;
        this.bill_id = bill_id;
        this.order_id = order_id;
        this.pay_price = pay_price;
        this.cash_pirce = cash_pirce;
        this.pay_success_time = pay_success_time;
        this.state = state;
        this.pay_type = pay_type;
        this.create_time = create_time;
    }

    public OrderPaySuccess(String uid, String bill_id, String order_id, Long pay_price, Long cash_pirce, Date pay_success_time, Integer state, Integer pay_type, Date create_time) {
        this.uid = uid;
        this.bill_id = bill_id;
        this.order_id = order_id;
        this.pay_price = pay_price;
        this.cash_pirce = cash_pirce;
        this.pay_success_time = pay_success_time;
        this.state = state;
        this.pay_type = pay_type;
        this.create_time = create_time;
    }

    public Long getCash_pirce() {
        return cash_pirce;
    }

    public void setCash_pirce(Long cash_pirce) {
        this.cash_pirce = cash_pirce;
    }

    public Integer getId() {
        return id;
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
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

    public Long getPay_price() {
        return pay_price;
    }

    public void setPay_price(Long pay_price) {
        this.pay_price = pay_price;
    }

    public Integer getPay_type() {
        return pay_type;
    }

    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Date getPay_success_time() {
        return pay_success_time;
    }

    public void setPay_success_time(Date pay_success_time) {
        this.pay_success_time = pay_success_time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderPaySuccess that = (OrderPaySuccess) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "OrderPaySuccess{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", bill_id='" + bill_id + '\'' +
                ", order_id='" + order_id + '\'' +
                ", pay_price=" + pay_price +
                ", cash_pirce=" + cash_pirce +
                ", pay_success_time=" + pay_success_time +
                ", state=" + state +
                ", pay_type=" + pay_type +
                ", create_time=" + create_time +
                '}';
    }
}
