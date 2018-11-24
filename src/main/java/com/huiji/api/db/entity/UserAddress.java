package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 孙旌翔 on 2016/7/20.
 */
public class UserAddress extends AbstractBaseEntity{
    public UserAddress(){}
    /**
     * name : 收货人姓名
     * phone : 收货人电话
     * id : 编号
     * province : 省
     * city : 市
     * area : 县区
     * street : 街道
     * zipCode : 邮编
     * address : 详细地址(门牌号)
     */



    private String name;
    private String phone;
    private int id;
    private String uid;
    private String province;
    private String city;
    private String area;
    private String street;
    private String zipCode;
    private String address;
    private Integer top;
    private String create_time;
    private String str_day;
    private String str_month;
    private String str_year;

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

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
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
        if (o == null || getClass() != o.getClass()) return false;

        UserAddress that = (UserAddress) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (top != null ? !top.equals(that.top) : that.top != null) return false;
        if (create_time != null ? !create_time.equals(that.create_time) : that.create_time != null) return false;
        if (str_day != null ? !str_day.equals(that.str_day) : that.str_day != null) return false;
        if (str_month != null ? !str_month.equals(that.str_month) : that.str_month != null) return false;
        return !(str_year != null ? !str_year.equals(that.str_year) : that.str_year != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (top != null ? top.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (str_day != null ? str_day.hashCode() : 0);
        result = 31 * result + (str_month != null ? str_month.hashCode() : 0);
        result = 31 * result + (str_year != null ? str_year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", uid='" + uid + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", address='" + address + '\'' +
                ", top=" + top +
                ", create_time=" + create_time +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
