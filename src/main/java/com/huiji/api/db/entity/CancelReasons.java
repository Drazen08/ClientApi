package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
public class CancelReasons extends AbstractBaseEntity {
    /*取消订单原因
     `id` int(11) NOT NULL,
  `cancel_reasons` varchar(3000) NOT NULL,
     */
    private Integer id;
    private String  cancel_reasons;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCancel_reasons() {
        return cancel_reasons;
    }

    public void setCancel_reasons(String cancel_reasons) {
        this.cancel_reasons = cancel_reasons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CancelReasons)) return false;

        CancelReasons that = (CancelReasons) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "CancelReasons{" +
                "id=" + id +
                ", cancel_reasons='" + cancel_reasons + '\'' +
                '}';
    }
}
