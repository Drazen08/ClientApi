package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/20.
 */
public class OrderPayLock extends AbstractBaseEntity {
    /*
      `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(11) NOT NULL,
  `type` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
     */
    private Integer id;
    private String  order_id;
    private Integer type;
    private Date create_time;

    public OrderPayLock() {
    }

    public OrderPayLock(Integer id, String order_id, Integer type, Date create_time) {
        this.id = id;
        this.order_id = order_id;
        this.type = type;
        this.create_time = create_time;
    }

    public OrderPayLock(String order_id, Integer type, Date create_time) {
        this.order_id = order_id;
        this.type = type;
        this.create_time = create_time;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderPayLock that = (OrderPayLock) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "OrderPayLock{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", type=" + type +
                ", create_time=" + create_time +
                '}';
    }
}
