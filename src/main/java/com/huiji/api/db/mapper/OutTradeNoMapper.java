package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.OutTradeNo;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2016/10/18.
 */
public interface OutTradeNoMapper extends BaseMapper {
    /*
     private Integer id;
    private String  order_id;
    private String  out_trade_no;
    private String  sub_order_id;
    private Integer type;
    private Date    create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;
     */

    @Insert(" insert into tb_out_trade_no " +
            " (order_id,out_trade_no,sub_order_id,type,create_time,str_day,str_month,str_year) " +
            " values " +
            " (#{order_id},#{out_trade_no},#{sub_order_id},#{type}" +
            " ,#{create_time},#{str_day},#{str_month},#{str_year})")
    int saveOutTradeNo(OutTradeNo outTradeNo);
    @Select("select * from tb_out_trade_no where sub_order_id=#{sub_order_id}")
    OutTradeNo getOutTradeNoBySubOrderId(String orderId);
}
