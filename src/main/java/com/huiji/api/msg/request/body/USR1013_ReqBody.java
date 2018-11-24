package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙旌翔 on 2016/7/16.
 */
public class USR1013_ReqBody extends AbstractBaseRequestBody {
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
    private String uid;
    private String province;
    private String city;
    private String area;
    private String street;
    private String zipCode;
    private String address;

    public USR1013_ReqBody(){}


    public USR1013_ReqBody(String name, String phone, String uid, String province, String city, String area, String street, String zipCode, String address) {
        this.name = name;
        this.phone = phone;
        this.uid = uid;
        this.province = province;
        this.city = city;
        this.area = area;
        this.street = street;
        this.zipCode = zipCode;
        this.address = address;
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
}
