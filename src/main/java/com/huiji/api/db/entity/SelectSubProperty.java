package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by Administrator on 2016/9/9.
 */
public class SelectSubProperty extends AbstractBaseEntity {
    /*
    `id` int(11) NOT NULL,
  `select_pro_id` varchar(11) NOT NULL,
  `sub_pro_desc` varchar(100) NOT NULL,

     */
    private Integer id;
    private String  select_pro_id;
    private String  sub_pro_desc;
    private Integer pro_id;

    public SelectSubProperty(Integer id, String select_pro_id, String sub_pro_desc, Integer pro_id) {
        this.id = id;
        this.select_pro_id = select_pro_id;
        this.sub_pro_desc = sub_pro_desc;
        this.pro_id = pro_id;
    }

    public SelectSubProperty(String select_pro_id, String sub_pro_desc, Integer pro_id) {
        this.select_pro_id = select_pro_id;
        this.sub_pro_desc = sub_pro_desc;
        this.pro_id = pro_id;
    }

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSelect_pro_id() {
        return select_pro_id;
    }

    public void setSelect_pro_id(String select_pro_id) {
        this.select_pro_id = select_pro_id;
    }

    public String getSub_pro_desc() {
        return sub_pro_desc;
    }

    public void setSub_pro_desc(String sub_pro_desc) {
        this.sub_pro_desc = sub_pro_desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectSubProperty that = (SelectSubProperty) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "SelectSubProperty{" +
                "id=" + id +
                ", select_pro_id='" + select_pro_id + '\'' +
                ", sub_pro_desc='" + sub_pro_desc + '\'' +
                ", pro_id=" + pro_id +
                '}';
    }
}
