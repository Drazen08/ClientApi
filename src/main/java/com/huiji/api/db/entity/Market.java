package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class Market  extends AbstractBaseEntity {
    private Integer id;
    private String market_name;
    private String market_desc;
    private String affiliated_pic;
    private String market_adv;
    private Integer city_id;
    public Market(){}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarket_name() {
        return market_name;
    }

    public void setMarket_name(String market_name) {
        this.market_name = market_name;
    }

    public String getMarket_desc() {
        return market_desc;
    }

    public void setMarket_desc(String market_desc) {
        this.market_desc = market_desc;
    }

    public String getAffiliated_pic() {
        return affiliated_pic;
    }

    public void setAffiliated_pic(String affiliated_pic) {
        this.affiliated_pic = affiliated_pic;
    }

    public String getMarket_adv() {
        return market_adv;
    }

    public void setMarket_adv(String market_adv) {
        this.market_adv = market_adv;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Market market = (Market) o;

        return id.equals(market.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Market{" +
                "id=" + id +
                ", market_name='" + market_name + '\'' +
                ", market_desc='" + market_desc + '\'' +
                ", affiliated_pic='" + affiliated_pic + '\'' +
                ", market_adv='" + market_adv + '\'' +
                ", city_id=" + city_id +
                '}';
    }
}
