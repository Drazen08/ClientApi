package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.OrderAddress;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 孙文剑 on 2016/8/31 0031.
 */
public interface OrderAddressMapper extends BaseMapper {
    /*
    private Integer id;
    private String order_id;
    private String name;
    private String phone;
    private String uid;
    private String province;
    private String city;
    private String area;
    private String street;
    private String zipCode;
    private String address;
    private String create_time;
    private String str_day;
    private String str_month;
    private String str_year;
     */

    @Insert(" insert into tb_order_address " +
            " (order_id,name,phone,uid,province," +
            " city,area,street,zipCode,address," +
            " create_time,str_day,str_month,str_year)" +
            " values" +
            " (#{order_id},#{name},#{phone},#{uid}" +
            " ,#{province},#{city},#{area},#{street}" +
            " ,#{zipCode},#{address},#{create_time},#{str_day}" +
            " ,#{str_month},#{str_year})")
    int saveOrderAddress(OrderAddress orderAddress);

    @Select("select * from tb_order_address where order_id=#{order_id}")
    OrderAddress getOrderAddressByOrderId(@Param("order_id") String order_id);

}
