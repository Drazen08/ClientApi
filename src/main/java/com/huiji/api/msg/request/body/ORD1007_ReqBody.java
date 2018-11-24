package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙文剑 on 2016/8/8 0008.
 */
public class ORD1007_ReqBody extends AbstractBaseRequestBody {

    /**
     * addressId : 地址id
     * Price : 实付金额
     * balance : 余额
     * num : 购买数量（针对主订单）
     * note : 买家备注
     * sendTypeId :
     * buyTypeId :
     * paySale : 订单总价
     * temid : 临时表id
     * postPrice : 邮费
     */

    private int addressId;
    private Long price;
    private Long balance;
    private int num;
    private String note;
    private int sendTypeId;
    private int buyTypeId;
    private Long paySale;
    private String temid;
    private Long postPrice;
    private String goodUrl;

    public String getGoodUrl() {
        return goodUrl;
    }

    public void setGoodUrl(String goodUrl) {
        this.goodUrl = goodUrl;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long Price) {
        this.price = Price;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getSendTypeId() {
        return sendTypeId;
    }

    public void setSendTypeId(int sendTypeId) {
        this.sendTypeId = sendTypeId;
    }

    public int getBuyTypeId() {
        return buyTypeId;
    }

    public void setBuyTypeId(int buyTypeId) {
        this.buyTypeId = buyTypeId;
    }

    public Long getPaySale() {
        return paySale;
    }

    public void setPaySale(Long paySale) {
        this.paySale = paySale;
    }

    public String getTemid() {
        return temid;
    }

    public void setTemid(String temid) {
        this.temid = temid;
    }

    public Long getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(Long postPrice) {
        this.postPrice = postPrice;
    }
}
