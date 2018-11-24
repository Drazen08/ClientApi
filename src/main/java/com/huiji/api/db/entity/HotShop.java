package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class HotShop extends AbstractBaseEntity {
    public HotShop() {
    }

    private Integer id;
    private String shop_name;
    private String shop_desc;
    private String affiliated_pic;
    private Integer city_id;
    private String shop_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_desc() {
        return shop_desc;
    }

    public void setShop_desc(String shop_desc) {
        this.shop_desc = shop_desc;
    }

    public String getAffiliated_pic() {
        return affiliated_pic;
    }

    public void setAffiliated_pic(String affiliated_pic) {
        this.affiliated_pic = affiliated_pic;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotShop hotShop = (HotShop) o;

        return id.equals(hotShop.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "HotShop{" +
                "id=" + id +
                ", shop_name='" + shop_name + '\'' +
                ", shop_desc='" + shop_desc + '\'' +
                ", affiliated_pic='" + affiliated_pic + '\'' +
                ", city_id=" + city_id +
                ", shop_id='" + shop_id + '\'' +
                '}';
    }
}



