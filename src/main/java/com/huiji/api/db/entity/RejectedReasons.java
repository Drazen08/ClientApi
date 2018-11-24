package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
public class RejectedReasons extends AbstractBaseEntity {
    /*
    '退货原因'
     `id` int(11) NOT NULL AUTO_INCREMENT,
  `rejected_reasons` varchar(3000) NOT NULL,
     */
    private Integer id;
    private String  rejected_reasons;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRejected_reasons() {
        return rejected_reasons;
    }

    public void setRejected_reasons(String rejected_reasons) {
        this.rejected_reasons = rejected_reasons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RejectedReasons)) return false;

        RejectedReasons that = (RejectedReasons) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "RejectedReasons{" +
                "id=" + id +
                ", rejected_reasons='" + rejected_reasons + '\'' +
                '}';
    }
}
