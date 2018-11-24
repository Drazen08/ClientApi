package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/8/31 0031.
 */
public class OrderAddress extends AbstractBaseEntity {
    /*
     `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `uid` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `province` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `area` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `street` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zipCode` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `str_day` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `str_month` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `str_year` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
     */
    private Integer id;
    private String order_id;
    private String name;
    private String phone;
    private String uid;
    private String province;
    private String city;
    private String area;
    private String street;
    private String zipCode;
    private String address;
    private String create_time;
    private String str_day;
    private String str_month;
    private String str_year;
    public OrderAddress(){}
    public OrderAddress(Integer id, String order_id, String name, String phone, String uid, String province, String city, String area, String street, String zipCode, String address, String create_time, String str_day, String str_month, String str_year) {
        this.id = id;
        this.order_id = order_id;
        this.name = name;
        this.phone = phone;
        this.uid = uid;
        this.province = province;
        this.city = city;
        this.area = area;
        this.street = street;
        this.zipCode = zipCode;
        this.address = address;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public OrderAddress(String order_id, String name, String phone, String uid, String province, String city, String area, String street, String zipCode, String address, String create_time, String str_day, String str_month, String str_year) {
        this.order_id = order_id;
        this.name = name;
        this.phone = phone;
        this.uid = uid;
        this.province = province;
        this.city = city;
        this.area = area;
        this.street = street;
        this.zipCode = zipCode;
        this.address = address;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderAddress)) return false;

        OrderAddress that = (OrderAddress) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "OrderAddress{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", uid='" + uid + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", address='" + address + '\'' +
                ", create_time='" + create_time + '\'' +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
