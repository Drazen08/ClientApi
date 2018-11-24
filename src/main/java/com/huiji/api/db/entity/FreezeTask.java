package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/9/1 0001.
 */
public class FreezeTask extends AbstractBaseEntity {//商户从不可提转成可提
    /*
    `id` int(11) NOT NULL,
  `seller_id` int(11) NOT NULL COMMENT '商户的id',
  `order_id` int(11) NOT NULL COMMENT '订单id',
  `price` bigint(45) NOT NULL COMMENT '要转的金额',
  `state` int(11) NOT NULL COMMENT '1000',
  `opt_num` int(11) NOT NULL,
  `opt_desc` varchar(45) DEFAULT NULL COMMENT '操作描述    这个地方可以写退货停止运行',
  `opt_time` datetime DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `start_time` datetime NOT NULL,
  `str_year` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
     */

    private Integer id;
    private String seller_id;
    private String order_id;
    private Long    price;
    private Integer state;
    private Integer opt_num;
    private String  opt_desc;
    private String  opt_time;
    private String  create_time;
    private String  start_time;
    private String  str_year;
    private String  str_month;
    private String  str_day;
    public FreezeTask(){}
    public FreezeTask(Integer id, String seller_id, String order_id, Long price, Integer state, Integer opt_num, String opt_desc, String opt_time, String create_time, String start_time, String str_year, String str_month, String str_day) {
        this.id = id;
        this.seller_id = seller_id;
        this.order_id = order_id;
        this.price = price;
        this.state = state;
        this.opt_num = opt_num;
        this.opt_desc = opt_desc;
        this.opt_time = opt_time;
        this.create_time = create_time;
        this.start_time = start_time;
        this.str_year = str_year;
        this.str_month = str_month;
        this.str_day = str_day;
    }

    public FreezeTask(String seller_id, String order_id, Long price, Integer state, Integer opt_num, String opt_desc, String opt_time, String create_time, String start_time, String str_year, String str_month, String str_day) {
        this.seller_id = seller_id;
        this.order_id = order_id;
        this.price = price;
        this.state = state;
        this.opt_num = opt_num;
        this.opt_desc = opt_desc;
        this.opt_time = opt_time;
        this.create_time = create_time;
        this.start_time = start_time;
        this.str_year = str_year;
        this.str_month = str_month;
        this.str_day = str_day;
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

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOpt_num() {
        return opt_num;
    }

    public void setOpt_num(Integer opt_num) {
        this.opt_num = opt_num;
    }

    public String getOpt_desc() {
        return opt_desc;
    }

    public void setOpt_desc(String opt_desc) {
        this.opt_desc = opt_desc;
    }

    public String getOpt_time() {
        return opt_time;
    }

    public void setOpt_time(String opt_time) {
        this.opt_time = opt_time;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getStr_year() {
        return str_year;
    }

    public void setStr_year(String str_year) {
        this.str_year = str_year;
    }

    public String getStr_month() {
        return str_month;
    }

    public void setStr_month(String str_month) {
        this.str_month = str_month;
    }

    public String getStr_day() {
        return str_day;
    }

    public void setStr_day(String str_day) {
        this.str_day = str_day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FreezeTask)) return false;

        FreezeTask that = (FreezeTask) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "FreezeTask{" +
                "id=" + id +
                ", seller_id=" + seller_id +
                ", order_id=" + order_id +
                ", price=" + price +
                ", state=" + state +
                ", opt_num=" + opt_num +
                ", opt_desc='" + opt_desc + '\'' +
                ", opt_time='" + opt_time + '\'' +
                ", create_time='" + create_time + '\'' +
                ", start_time='" + start_time + '\'' +
                ", str_year='" + str_year + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_day='" + str_day + '\'' +
                '}';
    }
}
