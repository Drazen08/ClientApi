package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/8/11 0011.
 */
public class ChangeBalanceUrl extends AbstractBaseEntity {
    /*
     `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL COMMENT '1充值、2. 支付宝、3.提现、4.退款  5威信 6 余额',
  `url` varchar(3000) NOT NULL,
  `url_desc` varchar(3000) DEFAULT NULL,
     */
    private Integer id;
    private Integer type;
    private String  url;
    private String  url_desc;

    public ChangeBalanceUrl(Integer id, Integer type, String url, String url_desc) {
        this.id = id;
        this.type = type;
        this.url = url;
        this.url_desc = url_desc;
    }

    public ChangeBalanceUrl(Integer type, String url, String url_desc) {
        this.type = type;
        this.url = url;
        this.url_desc = url_desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl_desc() {
        return url_desc;
    }

    public void setUrl_desc(String url_desc) {
        this.url_desc = url_desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChangeBalanceUrl)) return false;

        ChangeBalanceUrl that = (ChangeBalanceUrl) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "ChangeBalanceUrl{" +
                "id=" + id +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", url_desc='" + url_desc + '\'' +
                '}';
    }
}
