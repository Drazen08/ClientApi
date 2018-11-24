package com.huiji.api.db.entity;

        import com.huiji.api.db.entity.base.AbstractBaseEntity;

        import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/24.
 */
public class WXPayParamter extends AbstractBaseEntity  {
    private String appid;//
    private String mch_id;//
    private String nonce_str;
    private String body;
    private String out_trade_no;
    private String total_fee;
    private String spbill_create_ip;
    private String partnerid;//
    private String key;//

    public WXPayParamter() {
    }


    public WXPayParamter(String appid, String mch_id, String nonce_str, String body, String out_trade_no, String total_fee, String spbill_create_ip, String partnerid, String key) {
        this.appid = appid;
        this.mch_id = mch_id;
        this.nonce_str = nonce_str;
        this.body = body;
        this.out_trade_no = out_trade_no;
        this.total_fee = total_fee;
        this.spbill_create_ip = spbill_create_ip;
        this.partnerid = partnerid;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }


    @Override
    public String toString() {
        return "WXPayParamter{" +
                "appid='" + appid + '\'' +
                ", mch_id='" + mch_id + '\'' +
                ", nonce_str='" + nonce_str + '\'' +
                ", body='" + body + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", total_fee='" + total_fee + '\'' +
                ", spbill_create_ip='" + spbill_create_ip + '\'' +
                ", partnerid='" + partnerid + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
