package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by Administrator on 2016/9/9.
 */
public class SelectPorperty extends AbstractBaseEntity {
    /*
    `id` int(11) NOT NULL,
  `good_id` varchar(11) NOT NULL,
  `good_name` varchar(255) NOT NULL,
  `pro_ch_desc` varchar(100) NOT NULL,
  `pro_en_desc` varchar(100) DEFAULT NULL,
     */
    private Integer id;
    private String  good_id;
    private String  good_name;
    private String  pro_ch_desc;
    private String  pro_en_desc;

    public SelectPorperty(Integer id, String good_id, String good_name, String pro_ch_desc, String pro_en_desc) {
        this.id = id;
        this.good_id = good_id;
        this.good_name = good_name;
        this.pro_ch_desc = pro_ch_desc;
        this.pro_en_desc = pro_en_desc;
    }

    public SelectPorperty(String good_id, String good_name, String pro_ch_desc, String pro_en_desc) {
        this.good_id = good_id;
        this.good_name = good_name;
        this.pro_ch_desc = pro_ch_desc;
        this.pro_en_desc = pro_en_desc;
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

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public String getPro_ch_desc() {
        return pro_ch_desc;
    }

    public void setPro_ch_desc(String pro_ch_desc) {
        this.pro_ch_desc = pro_ch_desc;
    }

    public String getPro_en_desc() {
        return pro_en_desc;
    }

    public void setPro_en_desc(String pro_en_desc) {
        this.pro_en_desc = pro_en_desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectPorperty that = (SelectPorperty) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "SelectPorperty{" +
                "id=" + id +
                ", good_id='" + good_id + '\'' +
                ", good_name='" + good_name + '\'' +
                ", pro_ch_desc='" + pro_ch_desc + '\'' +
                ", pro_en_desc='" + pro_en_desc + '\'' +
                '}';
    }
}
