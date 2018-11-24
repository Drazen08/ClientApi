package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public class GoodProperty extends AbstractBaseEntity {
    /*
    `id` int(11) NOT NULL AUTO_INCREMENT,
  `good_id` int(11) NOT NULL,
  `good_property_desc` varchar(45) DEFAULT NULL,
  `good_property_english_desc` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private String good_id;
    private String  good_property_desc;
    private String  good_property_english_desc;
    public GoodProperty(){}
    public GoodProperty(Integer id, String good_id, String good_property_desc, String good_property_english_desc) {
        this.id = id;
        this.good_id = good_id;
        this.good_property_desc = good_property_desc;
        this.good_property_english_desc = good_property_english_desc;
    }

    public GoodProperty(String good_id, String good_property_desc, String good_property_english_desc) {
        this.good_id = good_id;
        this.good_property_desc = good_property_desc;
        this.good_property_english_desc = good_property_english_desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGood_id() {
        return good_id;
    }

    public void setGood_id(String good_id) {
        this.good_id = good_id;
    }

    public String getGood_property_desc() {
        return good_property_desc;
    }

    public void setGood_property_desc(String good_property_desc) {
        this.good_property_desc = good_property_desc;
    }

    public String getGood_property_english_desc() {
        return good_property_english_desc;
    }

    public void setGood_property_english_desc(String good_property_english_desc) {
        this.good_property_english_desc = good_property_english_desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodProperty)) return false;

        GoodProperty that = (GoodProperty) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "GoodProperty{" +
                "id=" + id +
                ", good_id=" + good_id +
                ", good_property_desc='" + good_property_desc + '\'' +
                ", good_property_english_desc='" + good_property_english_desc + '\'' +
                '}';
    }
}
