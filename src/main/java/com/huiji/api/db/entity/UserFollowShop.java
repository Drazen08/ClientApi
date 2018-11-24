package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by Jingxiang on 2016/8/9.
 */
public class UserFollowShop  extends AbstractBaseEntity {
    public UserFollowShop(){}
    private int id;
    private String uid;
    private  String shop_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    @Override
    public String toString() {
        return "UserFollowShop{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", shop_id='" + shop_id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserFollowShop that = (UserFollowShop) o;

        if (id != that.id) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        return !(shop_id != null ? !shop_id.equals(that.shop_id) : that.shop_id != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (shop_id != null ? shop_id.hashCode() : 0);
        return result;
    }
}
