package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 孙文剑 on 2016/8/5 0005.
 */
public class Shop extends AbstractBaseEntity {
   /*

  `shop_info` varchar(45) DEFAULT NULL,
  `shop_logo` varchar(45) DEFAULT NULL,
  `cuxiao_url` varchar(45) DEFAULT NULL COMMENT '  所有促销的url 用英文的;分号分割',
  `address` varchar(45) DEFAULT NULL,
  `add_id` int(11) DEFAULT NULL,
  `num` int(11) NOT NULL DEFAULT '0' COMMENT '商铺的销量',
  `listener_num` int(11) DEFAULT '0' COMMENT '关注数量',
  `id_card_url` varchar(45) DEFAULT NULL,
  `province_id` int(11) DEFAULT NULL,
  `province` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  `area_id` int(11) DEFAULT NULL,
  `collect_num` int(11) DEFAULT '0' COMMENT '收藏人数',
  `bussiness_licence_url` varchar(45) DEFAULT NULL,
  `bussiness_licence_name` varchar(45) DEFAULT NULL,
  `bussiness_licence_regcode` varchar(45) DEFAULT NULL,
  `bussiness_licence_address` varchar(45) DEFAULT NULL,
  `bussiness_licence_expired_time` datetime(6) DEFAULT NULL,
  `allgoods` int(11) NOT NULL DEFAULT '0' COMMENT '商铺的全部商品',
  `postpower` int(11) NOT NULL COMMENT '是否支持极快速',
  `post_type` varchar(45) DEFAULT NULL,
  `post_time` datetime(6) DEFAULT NULL,
  `build_time` datetime(6) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
  `shop_star` int(11) DEFAULT '0',
  `background_url` varchar(45) DEFAULT NULL,
  `class_id1` int(11) DEFAULT NULL COMMENT '大分类id',
  `class_id2` int(11) DEFAULT NULL COMMENT '二级分类id',*/
    private Integer id;
    private String  name;
    private String seller_id;//卖家的uid
    private String shop_user;//卖家的名称
    private String card_id;//身份证号
    //申请状态 1待完善 2审核中 3需修改 4待审核 5未通过
    private String state;
    private String firstCat;
    private String secondCat;
    private String thirdCat;
    private String phone;//手机
    private  String province;
    private String city;
    private String area;
    private Integer postpower ;
    private Integer class_id3;//店家类别的id号
    private String shop_info;//店家的信息介绍
    private String shop_logo;//logo
    private String  cuxiao_url;//所有带  促  新 的图片
    private String address;//店家地址
    private Integer add_id;
    private Integer listener_num;//关注数量
    private String id_card_url; //身份证的图片
    private Integer province_id ;//
    private Integer city_id ;
    private Integer area_id;
    private String bussiness_licence_url;//营业执照的url
    private String bussiness_licence_name ;//营业执照的name
    private String bussiness_licence_regcode;//营业执照的注册号
    private String bussiness_licence_address;//营业执照的地址
    private String bussiness_licence_expired_time;//营业执照的过期时间
    private String post_type ;//配送方式
    private String post_time;//
    private String build_time;//
    private String create_time;//
    private String str_day;//
    private String str_month;//
    private String str_year;//
    private Integer shop_star;//评星
    private Integer num;//商铺的销量
    private Integer collect_num;//收藏人数
    private Integer allgoods;//商铺内所有的商品数
    private String background_url;
    private Integer class_id1;
    private Integer class_id2;
    public Shop(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getShop_user() {
        return shop_user;
    }

    public void setShop_user(String shop_user) {
        this.shop_user = shop_user;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = state;
    }

    public String getFirstCat() {
        return firstCat;
    }

    public void setFirstCat(String firstCat) {
        this.firstCat = firstCat;
    }

    public String getSecondCat() {
        return secondCat;
    }

    public void setSecondCat(String secondCat) {
        this.secondCat = secondCat;
    }

    public String getThirdCat() {
        return thirdCat;
    }

    public void setThirdCat(String thirdCat) {
        this.thirdCat = thirdCat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getPostpower() {
        return postpower;
    }

    public void setPostpower(Integer postpower) {
        this.postpower = postpower;
    }

    public Integer getClass_id3() {
        return class_id3;
    }

    public void setClass_id3(Integer class_id3) {
        this.class_id3 = class_id3;
    }

    public String getShop_info() {
        return shop_info;
    }

    public void setShop_info(String shop_info) {
        this.shop_info = shop_info;
    }

    public String getShop_logo() {
        return shop_logo;
    }

    public void setShop_logo(String shop_logo) {
        this.shop_logo = shop_logo;
    }

    public String getCuxiao_url() {
        return cuxiao_url;
    }

    public void setCuxiao_url(String cuxiao_url) {
        this.cuxiao_url = cuxiao_url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAdd_id() {
        return add_id;
    }

    public void setAdd_id(Integer add_id) {
        this.add_id = add_id;
    }

    public Integer getListener_num() {
        return listener_num;
    }

    public void setListener_num(Integer listener_num) {
        this.listener_num = listener_num;
    }

    public String getId_card_url() {
        return id_card_url;
    }

    public void setId_card_url(String id_card_url) {
        this.id_card_url = id_card_url;
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public String getBussiness_licence_url() {
        return bussiness_licence_url;
    }

    public void setBussiness_licence_url(String bussiness_licence_url) {
        this.bussiness_licence_url = bussiness_licence_url;
    }

    public String getBussiness_licence_name() {
        return bussiness_licence_name;
    }

    public void setBussiness_licence_name(String bussiness_licence_name) {
        this.bussiness_licence_name = bussiness_licence_name;
    }

    public String getBussiness_licence_regcode() {
        return bussiness_licence_regcode;
    }

    public void setBussiness_licence_regcode(String bussiness_licence_regcode) {
        this.bussiness_licence_regcode = bussiness_licence_regcode;
    }

    public String getBussiness_licence_address() {
        return bussiness_licence_address;
    }

    public void setBussiness_licence_address(String bussiness_licence_address) {
        this.bussiness_licence_address = bussiness_licence_address;
    }

    public String getBussiness_licence_expired_time() {
        return bussiness_licence_expired_time;
    }

    public void setBussiness_licence_expired_time(String bussiness_licence_expired_time) {
        this.bussiness_licence_expired_time = bussiness_licence_expired_time;
    }

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public String getPost_time() {
        return post_time;
    }

    public void setPost_time(String post_time) {
        this.post_time = post_time;
    }

    public String getBuild_time() {
        return build_time;
    }

    public void setBuild_time(String build_time) {
        this.build_time = build_time;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
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

    public Integer getShop_star() {
        return shop_star;
    }

    public void setShop_star(Integer shop_star) {
        this.shop_star = shop_star;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCollect_num() {
        return collect_num;
    }

    public void setCollect_num(Integer collect_num) {
        this.collect_num = collect_num;
    }

    public Integer getAllgoods() {
        return allgoods;
    }

    public void setAllgoods(Integer allgoods) {
        this.allgoods = allgoods;
    }

    public String getBackground_url() {
        return background_url;
    }

    public void setBackground_url(String background_url) {
        this.background_url = background_url;
    }

    public Integer getClass_id1() {
        return class_id1;
    }

    public void setClass_id1(Integer class_id1) {
        this.class_id1 = class_id1;
    }

    public Integer getClass_id2() {
        return class_id2;
    }

    public void setClass_id2(Integer class_id2) {
        this.class_id2 = class_id2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        return id.equals(shop.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seller_id='" + seller_id + '\'' +
                ", shop_user='" + shop_user + '\'' +
                ", card_id='" + card_id + '\'' +
                ", state='" + state + '\'' +
                ", firstCat='" + firstCat + '\'' +
                ", secondCat='" + secondCat + '\'' +
                ", thirdCat='" + thirdCat + '\'' +
                ", phone='" + phone + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", postpower=" + postpower +
                ", class_id3=" + class_id3 +
                ", shop_info='" + shop_info + '\'' +
                ", shop_logo='" + shop_logo + '\'' +
                ", cuxiao_url='" + cuxiao_url + '\'' +
                ", address='" + address + '\'' +
                ", add_id=" + add_id +
                ", listener_num=" + listener_num +
                ", id_card_url='" + id_card_url + '\'' +
                ", province_id=" + province_id +
                ", city_id=" + city_id +
                ", area_id=" + area_id +
                ", bussiness_licence_url='" + bussiness_licence_url + '\'' +
                ", bussiness_licence_name='" + bussiness_licence_name + '\'' +
                ", bussiness_licence_regcode='" + bussiness_licence_regcode + '\'' +
                ", bussiness_licence_address='" + bussiness_licence_address + '\'' +
                ", bussiness_licence_expired_time='" + bussiness_licence_expired_time + '\'' +
                ", post_type='" + post_type + '\'' +
                ", post_time='" + post_time + '\'' +
                ", build_time='" + build_time + '\'' +
                ", create_time='" + create_time + '\'' +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                ", shop_star=" + shop_star +
                ", num=" + num +
                ", collect_num=" + collect_num +
                ", allgoods=" + allgoods +
                ", background_url='" + background_url + '\'' +
                ", class_id1=" + class_id1 +
                ", class_id2=" + class_id2 +
                '}';
    }
}
