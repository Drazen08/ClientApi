package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by Administrator on 2016/9/29.
 */
public class AliPayParamter extends AbstractBaseEntity {

    private String APPID;
    private String RSA_PRIVATE;
    private String Order_Num;
    private String Show_Content;
    private String Order_Price;
    public AliPayParamter(){}
    public AliPayParamter(String APPID, String RSA_PRIVATE, String order_Num, String show_Content, String order_Price) {
        this.APPID = APPID;
        this.RSA_PRIVATE = RSA_PRIVATE;
        Order_Num = order_Num;
        Show_Content = show_Content;
        Order_Price = order_Price;
    }

    public AliPayParamter(String RSA_PRIVATE, String order_Num, String show_Content, String order_Price) {
        this.RSA_PRIVATE = RSA_PRIVATE;
        Order_Num = order_Num;
        Show_Content = show_Content;
        Order_Price = order_Price;
    }

    public String getAPPID() {
        return APPID;
    }

    public void setAPPID(String APPID) {
        this.APPID = APPID;
    }

    public String getRSA_PRIVATE() {
        return RSA_PRIVATE;
    }

    public void setRSA_PRIVATE(String RSA_PRIVATE) {
        this.RSA_PRIVATE = RSA_PRIVATE;
    }

    public String getOrder_Num() {
        return Order_Num;
    }

    public void setOrder_Num(String order_Num) {
        Order_Num = order_Num;
    }

    public String getShow_Content() {
        return Show_Content;
    }

    public void setShow_Content(String show_Content) {
        Show_Content = show_Content;
    }

    public String getOrder_Price() {
        return Order_Price;
    }

    public void setOrder_Price(String order_Price) {
        Order_Price = order_Price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AliPayParamter that = (AliPayParamter) o;

        return !(APPID != null ? !APPID.equals(that.APPID) : that.APPID != null);

    }

    @Override
    public int hashCode() {
        return APPID != null ? APPID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AliPayParamter{" +
                "APPID='" + APPID + '\'' +
                ", RSA_PRIVATE='" + RSA_PRIVATE + '\'' +
                ", Order_Num='" + Order_Num + '\'' +
                ", Show_Content='" + Show_Content + '\'' +
                ", Order_Price='" + Order_Price + '\'' +
                '}';
    }
}
