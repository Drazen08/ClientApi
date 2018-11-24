package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.OrderLogistics;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Administrator on 2016/10/31.
 */
public interface OrderLogisticsMapper extends BaseMapper {
    /*
     private Integer id;
    private String  order_id;
    private String  logistic_name;
    private String  logistic_num;
    private String  return_remarks;
    private Date    create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;
     */
    @Insert(" insert into tb_order_logistics " +
            " (order_id,logistic_name,logistic_num,return_remarks,create_time,str_day,str_month,str_year) " +
            " values " +
            " (#{order_id},#{logistic_name},#{logistic_num}," +
            " #{return_remarks},#{create_time},#{str_day}," +
            " #{str_month},#{str_year}) ")
    int saveOrderLogistics(OrderLogistics orderLogistics);
}
