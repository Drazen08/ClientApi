package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.PayTaskForSeller;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by 孙文剑 on 2016/8/11 0011.
 */
public interface PayTaskForSellerMapper extends BaseMapper {


    @Select("select * from tb_pay_task_for_seller where order_id=#{order_id}")
    PayTaskForSeller getPayTaskForSellerByOrderId(@Param("order_id") String order_id);

    /*
     (String pay_code_id, String order_id, String uid, Long pay_price, String state, Integer type,
     Integer oper_num, String oper_time, String create_time, String str_day, String str_month, String str_year)
                 */

    @Insert("insert into tb_pay_task_for_seller" +
            "(pay_code_id,order_id,uid,pay_price,state,type," +
            "oper_num,oper_time,create_time,str_day,str_month,str_year)" +
            "values" +
            "(#{pay_code_id},#{order_id},#{uid},#{pay_price},#{state}" +
            ",#{type},#{oper_num},#{oper_time},#{create_time},#{str_day}" +
            ",#{str_month},#{str_year})")
    int savePayTaskForSeller(PayTaskForSeller payTaskForSeller);

    @Update("update tb_pay_task_for_seller" +
            " set" +
            " oper_num=#{oper_num} " +
            " where order_id=#{order_id}")
    int updateOperNum(@Param("order_id") String order_id,@Param("oper_num") Integer oper_num);




}
