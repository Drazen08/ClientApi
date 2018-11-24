package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.OrderPaySuccess;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/21.
 */
public interface OrderPaySuccessMapper extends BaseMapper {
    /*
     private String  order_id;
    private Date    pay_success_time;
    private Integer state;
    private Date    create_time;
     */
    @Insert(" insert into tb_order_pay_success " +
            " (uid,bill_id,order_id,pay_price,cash_pirce,pay_success_time,state,pay_type,create_time) " +
            " values " +
            " (#{uid},#{bill_id},#{order_id},#{pay_price},#{cash_pirce},#{pay_success_time},#{state},#{pay_type},#{create_time}) ")
    int saveOrderPaySuccess(OrderPaySuccess orderPaySuccess);



    @Select("select order_id ,count(1) num from tb_order_pay_success where state =1 GROUP BY order_id HAVING num >1;")
    List<Map<String,Object>> findPayedOrders();


    @Select("select * from tb_order_pay_success where order_id =#{order_id} and state =1 ORDER BY pay_success_time ,pay_price desc ;")
    List<OrderPaySuccess> getOrdersByOrderId(@Param("order_id") String order_id);


    @Update("update tb_order_pay_success set state=2 where id ${id}")
    int updateOrderState(@Param("id") String order_id);

}
