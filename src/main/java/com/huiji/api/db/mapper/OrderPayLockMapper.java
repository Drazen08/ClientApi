package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.OrderPayLock;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */
public interface OrderPayLockMapper extends BaseMapper {
    /*
    private Integer id;
    private String  order_id;
    private Integer type;
    private Date create_time;
     */

    @Insert(" insert into tb_pay_lock " +
            " (order_id,type,create_time) " +
            " values " +
            " (#{order_id},#{type},#{create_time}) ")
    int saveOrderPayLock(OrderPayLock orderPayLock);




    @Update("update tb_pay_lock set type=1 where type=0 and order_id ${order_id}")
    int updateOrderPaying(@Param("order_id")String orders);

    @Select("select * from tb_pay_lock where type=1 and order_id ${order_id}")
    List<OrderPayLock> getPayLock(@Param("order_id")String order);


    @Update("update tb_pay_lock set type=2 where order_id=#{order_id}")
    int updateOrderPayed(@Param("order_id")String orders);


}
