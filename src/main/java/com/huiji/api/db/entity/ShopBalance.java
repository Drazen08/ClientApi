package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/8/18 0018.
 */
public class ShopBalance extends AbstractBaseEntity {
    /*
    `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` varchar(45) DEFAULT NULL,
  `act_type` varchar(45) DEFAULT NULL COMMENT '资金变动性质（0 从银行卡收入、1 交易成功收入、2提现 3.退款）',
  `url` varchar(45) DEFAULT NULL,
  `change_money` bigint(45) DEFAULT '0' COMMENT '变动金额',
  `bill_id` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL COMMENT '+ -',
  `before_money` bigint(45) DEFAULT '0' COMMENT '变动前金额',
  `after_money` bigint(45) unsigned DEFAULT '0' COMMENT '变动后金额',
  `opt_desc` varchar(45) DEFAULT NULL COMMENT '描述具体操作的充值   退款详细记录',
  `create_time` datetime DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    private Integer id;
    private String  seller_id;
    private String  bill_id;
    private Integer act_type;
    private String  url;
    private String  type;
    private Long    change_money;
    private Long    before_money;
    private Long    after_money;
    private String  opt_desc;
    private String  create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;
    public ShopBalance(){}
    public ShopBalance(Integer id, String seller_id, String bill_id, Integer act_type, String url, String type, Long change_money, Long before_money, Long after_money, String opt_desc, String create_time, String str_day, String str_month, String str_year) {
        this.id = id;
        this.seller_id = seller_id;
        this.bill_id = bill_id;
        this.act_type = act_type;
        this.url = url;
        this.type = type;
        this.change_money = change_money;
        this.before_money = before_money;
        this.after_money = after_money;
        this.opt_desc = opt_desc;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public ShopBalance(String seller_id, String bill_id, Integer act_type, String url, String type, Long change_money, Long before_money, Long after_money, String opt_desc, String create_time, String str_day, String str_month, String str_year) {
        this.seller_id = seller_id;
        this.bill_id = bill_id;
        this.act_type = act_type;
        this.url = url;
        this.type = type;
        this.change_money = change_money;
        this.before_money = before_money;
        this.after_money = after_money;
        this.opt_desc = opt_desc;
        this.create_time = create_time;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public ShopBalance(String seller_id, String bill_id, Integer act_type, String url, String type, Long change_money, Long before_money, Long after_money, String opt_desc, String create_time) {
        this.seller_id = seller_id;
        this.bill_id = bill_id;
        this.act_type = act_type;
        this.url = url;
        this.type = type;
        this.change_money = change_money;
        this.before_money = before_money;
        this.after_money = after_money;
        this.opt_desc = opt_desc;
        this.create_time = create_time;
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

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public Integer getAct_type() {
        return act_type;
    }

    public void setAct_type(Integer act_type) {
        this.act_type = act_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getChange_money() {
        return change_money;
    }

    public void setChange_money(Long change_money) {
        this.change_money = change_money;
    }

    public Long getBefore_money() {
        return before_money;
    }

    public void setBefore_money(Long before_money) {
        this.before_money = before_money;
    }

    public Long getAfter_money() {
        return after_money;
    }

    public void setAfter_money(Long after_money) {
        this.after_money = after_money;
    }

    public String getOpt_desc() {
        return opt_desc;
    }

    public void setOpt_desc(String opt_desc) {
        this.opt_desc = opt_desc;
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
        if (!(o instanceof ShopBalance)) return false;

        ShopBalance that = (ShopBalance) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "ShopBalance{" +
                "id=" + id +
                ", seller_id='" + seller_id + '\'' +
                ", bill_id='" + bill_id + '\'' +
                ", act_type=" + act_type +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", change_money=" + change_money +
                ", before_money=" + before_money +
                ", after_money=" + after_money +
                ", opt_desc='" + opt_desc + '\'' +
                ", create_time='" + create_time + '\'' +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
