package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
public class ClientVersionInfo extends AbstractBaseEntity {
    /*
    `product_id` varchar(16) CHARACTER SET utf8 NOT NULL,
  `product_version` varchar(16) CHARACTER SET utf8 NOT NULL COMMENT '当前产品版本',
  `channel_id` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'all' COMMENT '渠道编号',
  `splash_url` varchar(300) CHARACTER SET utf8 DEFAULT NULL COMMENT '启动页图片url',
  `update_flag` int(1) NOT NULL DEFAULT '0' COMMENT '缺省强制升级标志 0不强制升级，1强制升级',
  `update_url` varchar(300) CHARACTER SET utf8 DEFAULT NULL COMMENT '升级地址',
  `update_desc` varchar(300) CHARACTER SET utf8 DEFAULT NULL COMMENT '升级描述',
  `pack_size` bigint(20) NOT NULL DEFAULT '0' COMMENT '升级包大小',
  `update_url_new` varchar(300) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户端升级包备用地址',
     */
    private String  product_id;
    private String  product_version;
    private String  channel_id ;
    private String  splash_url;
    private Integer update_flag;
    private String  update_url;
    private String  update_desc;
    private Long    pack_size;
    private String  update_url_new;
    public ClientVersionInfo(){}

    public ClientVersionInfo(String product_id, String product_version, String channel_id, String splash_url, Integer update_flag, String update_url, String update_desc, Long pack_size, String update_url_new) {
        this.product_id = product_id;
        this.product_version = product_version;
        this.channel_id = channel_id;
        this.splash_url = splash_url;
        this.update_flag = update_flag;
        this.update_url = update_url;
        this.update_desc = update_desc;
        this.pack_size = pack_size;
        this.update_url_new = update_url_new;
    }

    public ClientVersionInfo(String product_version, String update_url_new, String update_desc, Long pack_size, String update_url, Integer update_flag, String splash_url, String channel_id) {
        this.product_version = product_version;
        this.update_url_new = update_url_new;
        this.update_desc = update_desc;
        this.pack_size = pack_size;
        this.update_url = update_url;
        this.update_flag = update_flag;
        this.splash_url = splash_url;
        this.channel_id = channel_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_version() {
        return product_version;
    }

    public void setProduct_version(String product_version) {
        this.product_version = product_version;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getSplash_url() {
        return splash_url;
    }

    public void setSplash_url(String splash_url) {
        this.splash_url = splash_url;
    }

    public Integer getUpdate_flag() {
        return update_flag;
    }

    public void setUpdate_flag(Integer update_flag) {
        this.update_flag = update_flag;
    }

    public String getUpdate_url() {
        return update_url;
    }

    public void setUpdate_url(String update_url) {
        this.update_url = update_url;
    }

    public String getUpdate_desc() {
        return update_desc;
    }

    public void setUpdate_desc(String update_desc) {
        this.update_desc = update_desc;
    }

    public Long getPack_size() {
        return pack_size;
    }

    public void setPack_size(Long pack_size) {
        this.pack_size = pack_size;
    }

    public String getUpdate_url_new() {
        return update_url_new;
    }

    public void setUpdate_url_new(String update_url_new) {
        this.update_url_new = update_url_new;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientVersionInfo)) return false;

        ClientVersionInfo that = (ClientVersionInfo) o;

        if (!getProduct_id().equals(that.getProduct_id())) return false;
        if (!getProduct_version().equals(that.getProduct_version())) return false;
        return getChannel_id().equals(that.getChannel_id());

    }

    @Override
    public int hashCode() {
        int result = getProduct_id().hashCode();
        result = 31 * result + getProduct_version().hashCode();
        result = 31 * result + getChannel_id().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ClientVersionInfo{" +
                "product_id='" + product_id + '\'' +
                ", product_version='" + product_version + '\'' +
                ", channel_id='" + channel_id + '\'' +
                ", splash_url='" + splash_url + '\'' +
                ", update_flag=" + update_flag +
                ", update_url='" + update_url + '\'' +
                ", update_desc='" + update_desc + '\'' +
                ", pack_size=" + pack_size +
                ", update_url_new='" + update_url_new + '\'' +
                '}';
    }
}
