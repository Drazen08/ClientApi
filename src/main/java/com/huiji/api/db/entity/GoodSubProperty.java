package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public class GoodSubProperty extends AbstractBaseEntity {
    public GoodSubProperty(){}
    /*
    `id` int(11) NOT NULL,
  `good_property_id` varchar(11) NOT NULL,
  `property_desc` varchar(45) DEFAULT NULL,
     */
    private  Integer id;
    private  String good_property_id;
    private  String property_desc;

    public GoodSubProperty(Integer id, String good_property_id, String property_desc) {
        this.id = id;
        this.good_property_id = good_property_id;
        this.property_desc = property_desc;
    }

    public GoodSubProperty(String good_property_id, String property_desc) {
        this.good_property_id = good_property_id;
        this.property_desc = property_desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGood_property_id() {
        return good_property_id;
    }

    public void setGood_property_id(String good_property_id) {
        this.good_property_id = good_property_id;
    }

    public String getProperty_desc() {
        return property_desc;
    }

    public void setProperty_desc(String property_desc) {
        this.property_desc = property_desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodSubProperty)) return false;

        GoodSubProperty that = (GoodSubProperty) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "GoodSubProperty{" +
                "id=" + id +
                ", good_property_id='" + good_property_id + '\'' +
                ", property_desc='" + property_desc + '\'' +
                '}';
    }
}
