package com.huiji.api.msg.response.body;

import com.huiji.api.db.entity.UserAddress;
import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by 孙旌翔 on 2016/7/16.
 */
public class USR1012_ResBody extends AbstractResponseBody{
    public USR1012_ResBody(){}
    public USR1012_ResBody(List<UserAddress> addresses) {
        this.addresses = addresses;
    }

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

    private List<UserAddress> addresses;

    public List<UserAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<UserAddress> addresses) {
        this.addresses = addresses;
    }

    public static class AddressesBean {
        private String name;
        private String phone;
        private int id;
        private String province;
        private String city;
        private String area;
        private String street;
        private String zipCode;
        private String address;

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
}
