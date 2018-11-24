package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
public class DicNavType extends AbstractBaseEntity {
    /*
    `id` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
     */
    private Integer id;
    private String  class_name;
    private Integer pid;

    public DicNavType(Integer id, String class_name, Integer pid) {
        this.id = id;
        this.class_name = class_name;
        this.pid = pid;
    }

    public DicNavType(String class_name, Integer pid) {
        this.class_name = class_name;
        this.pid = pid;
    }
    public DicNavType(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DicNavType)) return false;

        DicNavType that = (DicNavType) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "DicNavType{" +
                "id=" + id +
                ", name='" + class_name + '\'' +
                ", pid=" + pid +
                '}';
    }
}
