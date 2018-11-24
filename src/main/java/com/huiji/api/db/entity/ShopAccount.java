package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/8/18 0018.
 */
public class ShopAccount extends AbstractBaseEntity {
    /*
     `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` varchar(45) NOT NULL,
  `balance` bigint(45) DEFAULT '0' COMMENT '店家账户余额',
  `get_money` bigint(45) DEFAULT '0' COMMENT '可提现金额',
  `account_type` int(11) DEFAULT NULL COMMENT '帐户类型  1000 资金帐户',
  `create_time` datetime DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private String  seller_id;
    private Long    balance;
    private Long    get_money;
    private Integer account_type;
    private String  create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;
    public ShopAccount (){}

    public ShopAccount(Integer id, String seller_id, Long balance, Long get_money, Integer account_type, String create_time, String str_day, String str_month, String str_year) {
        this.id = id;
        this.seller_id = seller_id;
        this.balance = balance;
        this.get_money = get_money;
        this.account_type = account_type;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public ShopAccount(String seller_id, Long balance, Long get_money, Integer account_type, String create_time, String str_day, String str_month, String str_year) {
        this.seller_id = seller_id;
        this.balance = balance;
        this.get_money = get_money;
        this.account_type = account_type;
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

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getGet_money() {
        return get_money;
    }

    public void setGet_money(Long get_money) {
        this.get_money = get_money;
    }

    public Integer getAccount_type() {
        return account_type;
    }

    public void setAccount_type(Integer account_type) {
        this.account_type = account_type;
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
        if (!(o instanceof ShopAccount)) return false;

        ShopAccount that = (ShopAccount) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "ShopAccount{" +
                "id=" + id +
                ", seller_id='" + seller_id + '\'' +
                ", balance=" + balance +
                ", get_money=" + get_money +
                ", account_type=" + account_type +
                ", create_time='" + create_time + '\'' +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
