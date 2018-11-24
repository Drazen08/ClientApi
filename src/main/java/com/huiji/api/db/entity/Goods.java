package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 孙文剑 on 2016/8/5 0005.
 */
public class Goods extends AbstractBaseEntity {
    private int id;
    //收藏人数
    private String scrs;
    //分类id
    private Integer t_id;
    private String modify_time;
    private String goodsname;
    private String goodsintro;
    private Integer shopid;
    private String goodsurl;
    private String title;
    private Integer goodstar;
    private long postcost;
    //市场价
    private long price;
    //平台价
    private long pingtaiprice;
    //是否支持急速快速:1 all，2 急速 ，3 快速
    private Integer postpower;
    private String create_time;
    private String str_day;
    private String str_month;
    private String str_year;
    //商品销量
    private int num;
    private Integer online;//上架下架
    private String images ;//轮播图

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScrs() {
        return scrs;
    }

    public void setScrs(String scrs) {
        this.scrs = scrs;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsintro() {
        return goodsintro;
    }

    public void setGoodsintro(String goodsintro) {
        this.goodsintro = goodsintro;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getGoodsurl() {
        return goodsurl;
    }

    public void setGoodsurl(String goodsurl) {
        this.goodsurl = goodsurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getGoodstar() {
        return goodstar;
    }

    public void setGoodstar(Integer goodstar) {
        this.goodstar = goodstar;
    }

    public long getPostcost() {
        return postcost;
    }

    public void setPostcost(long postcost) {
        this.postcost = postcost;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPingtaiprice() {
        return pingtaiprice;
    }

    public void setPingtaiprice(long pingtaiprice) {
        this.pingtaiprice = pingtaiprice;
    }

    public Integer getPostpower() {
        return postpower;
    }

    public void setPostpower(Integer postpower) {
        this.postpower = postpower;
    }

    public String getCreate_time() {
        return create_time;
    }


    public void setCreate_time(String createtime) {
        this.create_time = createtime;
    }

    public String getStr_day() {
        return str_day;
    }

    public void setStr_day(String str_day) {
        this.str_day = str_day;
    }

    public String getStr_month() {
        return str_month;
    }

    public void setStr_month(String str_month) {
        this.str_month = str_month;
    }

    public String getStr_year() {
        return str_year;
    }

    public void setStr_year(String str_year) {
        this.str_year = str_year;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (id != goods.id) return false;
        if (postcost != goods.postcost) return false;
        if (price != goods.price) return false;
        if (pingtaiprice != goods.pingtaiprice) return false;
        if (num != goods.num) return false;
        if (scrs != null ? !scrs.equals(goods.scrs) : goods.scrs != null) return false;
        if (t_id != null ? !t_id.equals(goods.t_id) : goods.t_id != null) return false;
        if (modify_time != null ? !modify_time.equals(goods.modify_time) : goods.modify_time != null) return false;
        if (goodsname != null ? !goodsname.equals(goods.goodsname) : goods.goodsname != null) return false;
        if (goodsintro != null ? !goodsintro.equals(goods.goodsintro) : goods.goodsintro != null) return false;
        if (shopid != null ? !shopid.equals(goods.shopid) : goods.shopid != null) return false;
        if (goodsurl != null ? !goodsurl.equals(goods.goodsurl) : goods.goodsurl != null) return false;
        if (title != null ? !title.equals(goods.title) : goods.title != null) return false;
        if (goodstar != null ? !goodstar.equals(goods.goodstar) : goods.goodstar != null) return false;
        if (postpower != null ? !postpower.equals(goods.postpower) : goods.postpower != null) return false;
        if (create_time != null ? !create_time.equals(goods.create_time) : goods.create_time != null) return false;
        if (str_day != null ? !str_day.equals(goods.str_day) : goods.str_day != null) return false;
        if (str_month != null ? !str_month.equals(goods.str_month) : goods.str_month != null) return false;
        if (str_year != null ? !str_year.equals(goods.str_year) : goods.str_year != null) return false;
        if (online != null ? !online.equals(goods.online) : goods.online != null) return false;
        return !(images != null ? !images.equals(goods.images) : goods.images != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (scrs != null ? scrs.hashCode() : 0);
        result = 31 * result + (t_id != null ? t_id.hashCode() : 0);
        result = 31 * result + (modify_time != null ? modify_time.hashCode() : 0);
        result = 31 * result + (goodsname != null ? goodsname.hashCode() : 0);
        result = 31 * result + (goodsintro != null ? goodsintro.hashCode() : 0);
        result = 31 * result + (shopid != null ? shopid.hashCode() : 0);
        result = 31 * result + (goodsurl != null ? goodsurl.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (goodstar != null ? goodstar.hashCode() : 0);
        result = 31 * result + (int) (postcost ^ (postcost >>> 32));
        result = 31 * result + (int) (price ^ (price >>> 32));
        result = 31 * result + (int) (pingtaiprice ^ (pingtaiprice >>> 32));
        result = 31 * result + (postpower != null ? postpower.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (str_day != null ? str_day.hashCode() : 0);
        result = 31 * result + (str_month != null ? str_month.hashCode() : 0);
        result = 31 * result + (str_year != null ? str_year.hashCode() : 0);
        result = 31 * result + num;
        result = 31 * result + (online != null ? online.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", scrs='" + scrs + '\'' +
                ", t_id=" + t_id +
                ", modify_time='" + modify_time + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", goodsintro='" + goodsintro + '\'' +
                ", shopid=" + shopid +
                ", goodsurl='" + goodsurl + '\'' +
                ", title='" + title + '\'' +
                ", goodstar=" + goodstar +
                ", postcost=" + postcost +
                ", price=" + price +
                ", pingtaiprice=" + pingtaiprice +
                ", postpower=" + postpower +
                ", create_time=" + create_time +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                ", num=" + num +
                ", online=" + online +
                ", images='" + images + '\'' +
                '}';
    }
}
