package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.OrderPayTask;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
public interface OrderPayTaskMapper  extends BaseMapper {
   @Select("select * from tb_task_user_pay where order_id=#{orderId} and type=2 order by id desc limit 1")
    OrderPayTask searchPayTaskWeiXin(@Param("orderId") String orderId);
    @Select( "select * from tb_task_user_pay where order_id=#{orderId} and type=1 order by id desc limit 1")//zhifubao  zhifu
    OrderPayTask searchPayTaskZhiFuBao(@Param("orderId") String orderId);
    @Select( "select * from tb_task_user_pay where order_id=#{orderId} and type=3")//zhifubao  zhifu
    OrderPayTask searchPayTaskYue(@Param("orderId") String orderId);

    @Insert("insert into tb_task_user_pay" +
            "(running_number,bill_id,uid,order_id,pay_price,pay_balance,state,type,opt_num,opt_time,create_time," +
            "str_day,str_month,str_year)" +
            "values" +
            "(#{running_number},#{bill_id},#{uid},#{order_id},#{pay_price},#{pay_balance}," +
            "#{state},#{type},#{opt_num},#{opt_time},#{create_time}," +
            "#{str_day},#{str_month},#{str_year})")
    int savePayTask(OrderPayTask orderPayTask);

    @Update("update tb_task_user_pay set oper_num=#{oper_num} ,execute='execute' where order_id=#{orderId} and type=1")
    int updateZhifuCount(@Param("orderId") String orderId,@Param("oper_num") int oper_num);

    @Update("update tb_task_user_pay set oper_num=#{oper_num},execute='execute' where order_id=#{orderId} and type=2")
    int updateWeiXinCount(@Param("orderId") String orderId,@Param("oper_num") int oper_num);

    @Update("update tb_task_user_pay set oper_num=#{oper_num},execute='execute' where order_id=#{orderId} and type=3")
    int updateYueCount(@Param("orderId") String orderId,@Param("oper_num") int oper_num);

    @Update("update tb_task_user_pay set state=5000 where order_id=#{orderId}")
    int updateState(@Param("orderId") String orderId);


    @Select( "select * from tb_task_user_pay where order_id=#{orderId} order by id desc limit 1")
    OrderPayTask getOderLastPayByOrderId(@Param("orderId") String orderId);

}
