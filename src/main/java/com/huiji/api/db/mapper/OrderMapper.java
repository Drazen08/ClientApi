package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.Order;
import com.huiji.api.db.entity.OrderPayLock;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Jingxiang on 2016/8/6.
 */
public interface OrderMapper extends BaseMapper {
   //用户订单-查询列表
    @Select("select * from tb_order_detail " +
            " where uid=#{uid} and type in ${type} "+
            " and tuitype in ${tuitype} "+
            " and pay_type in ${pay_type} "+
            " and send_type in ${send_type} "+
            " and delete_type=0 " +
            " and pid is null order by create_time desc limit #{pages},#{show}")
    List<Order> searchOrdList(@Param("uid") String uid,@Param("type") String type,@Param("tuitype")String tuitype,@Param("pay_type") String pay_type,@Param("send_type")String send_type,@Param("pages") int pages,@Param("show")int show);

    //用户订单-查询列表
    @Select("select goodsname from tb_goods_detail where id=#{id}")
    String goodsname(@Param("id")int id);
    @Select("select goods_spec_desc from tb_goods_spec where id=#{id} ")
    String goodDesc(@Param("id") int id);

    @Select("select name from tb_shop where id=#{id} ")
    String shopname(@Param("id") int id);

    @Insert("insert into tb_order_detail" +
            "(order_id,uid,type,send_type,pay_type,tuitype,delete_type,type_desc,seller_address ," +
            " shop_id,goods_id,goods_pro,goods_url,goods_pid,price,postprice,endprice,balance,goodprice,costprice,leavewords ," +
            "num,pid,sendid,payid,create_time,pay_time,closing_time,payback_time,send_time,getdell_time,str_day ," +
            "str_month,str_year,pay_expired_time,seller_id)" +
            "values" +
            "(#{order_id},#{uid},#{type},#{send_type},#{pay_type},#{tuitype},#{delete_type},#{type_desc},#{seller_address},#{shop_id},#{goods_id},#{goods_pro},#{goods_url},#{goods_pid},#{price},#{postprice}" +
            ",#{endprice},#{balance},#{goodprice},#{costprice},#{leavewords},#{num},#{pid},#{sendid},#{payid},#{create_time},#{pay_time},#{closing_time},#{payback_time},#{send_time},#{getdell_time}" +
            ",#{str_day},#{str_month},#{str_year},#{pay_expired_time},#{seller_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveOrder(Order order);

    @Select("select * from tb_order_detail where order_id =#{orderId}")
    Order getOrderByOrderId(@Param("orderId") String orderId);

    @Select("select * from tb_order_detail where pay_type=10 and order_id ${order_id}")
    List<Order> getOrderPaySuccess(@Param("order_id")String order);



//    @Insert("<script>"+
//            "insert into table(column1, column3, column2) "
//            + "values "
//            + "<foreach collection =\"useridList\" item=\"userid\" index= \"index\" separator =\",\"> "
//            + "(#{userid},#{message.title},#{message.content},#{message.type},0,0,NOW()) "
//            + "</foreach > "
//            + "</script>")

    @Select("select * from tb_order_detail where pid =#{orderId} and delete_type=0")
    List<Order> getSubOrderByOrderId(@Param("orderId") String orderId);

    //删除订单
    @Update("update tb_order_detail set delete_type=1 where order_id=#{orderId}")
    int updateStatusForDeleteType(@Param("orderId") String orderId);
    @Update("update tb_order_detail set delete_type=1 where pid=#{orderId}")
    int updateStatusForDeleteTypeYi(@Param("orderId") String orderId);

    @Update("update tb_order_detail " +
            " set " +
            " pay_type=#{pay_type},type_desc=#{type_desc},pay_expired_time='2099-12-28 12:00:00'," +
            " endprice=#{endprice},balance=#{balance},pay_time=#{paytime},payid=#{payid},pid=null " +
            " where " +
            " order_id=#{order_id} and pay_type=0")
    int updateOrderStauts1(Map<String,Object> map);


//    @Select("select ifnull(count(1),0) from tb_order_detail where order_id ${order_id} and pay_type=30")
//    int getOrderPayingNum(@Param("order_id") String order_id);
//    @Update("update tb_order_detail " +
//            " set " +
//            " pay_type=30,type_desc='支付进行中'"+
//            " where " +
//            " order_id ${order_id}")
//    int updateOrderPaing(@Param("order_id") String order_id);
    /*
            map.put("type",2);
            map.put("send_type",2);
            map.put("pay_type",1);
            map.put("type_desc","订单付款成功，等待商家发货");
            map.put("endprice",0);
            map.put("balance",balance);
            map.put("paytime", DateUtil.dateToString(new Date()));
            map.put("payid",1);
            map.put("send_time",DateUtil.dateToString(new Date()));
            map.put("getdell_time",DateUtil.dateToString(new Date()));
     */
   @Update("update tb_order_detail " +
           "set" +
           " type=#{type},send_type=#{send_type},pay_type=#{pay_type}," +
           "endprice=#{endprice},pay_time=#{paytime},payid=#{payid}," +
           "send_time=#{send_time},type_desc=#{type_desc},balance=#{balance}" +
           " where" +
           " order_id=#{order_id}")
    int updateOrderStauts2(Map<String,Object> map);


    @Update(" update tb_order_detail " +
            " set " +
            " payid=#{payid},endprice=#{endprice},balance=#{balance},pay_time=#{pay_time} " +
            " where " +
            " order_id=#{order_id}")
    int restoreStatus(Map<String,Object> map);

    @Update(" update tb_order_detail set " +
            " tuitype=#{tuitype} " +
            " where order_id=#{order_id} ")
    int updateRejectedStatus(@Param("order_id") String order_id,@Param("tuitype") int tuitype);

    //取消订单/关闭订单
    @Update("update tb_order_detail set type='40',esc_reason=#{esc_reason},closing_time=now(),type_desc='订单已关闭' where order_id=#{order_id} and pay_type in ('0','90')")
    int closeordeer(@Param("order_id") String order_id,@Param("esc_reason")String esc_reason);

    @Select("select pid from tb_order_detail where order_id=#{order_id}")
    String pid(@Param("order_id")String order_id);
    @Update("update tb_order_detail set type=20,send_type=20,tuitype=#{tuitype},type_desc='用户发起退款申请' where order_id=#{order_id} ")
    int tui(@Param("tuitype") String tuitype,@Param("order_id") String order_id);

    @Insert("insert into tb_order_rejected " +
            " (order_id,reject_type,reject_cause,reject_price, " +
            " note,money,create_time,str_day,str_month,str_year) " +
            " values " +
            " (#{order_id},#{reject_type},#{reject_cause},#{reject_price}," +
            " #{note},#{money},now(),#{str_day},#{str_month},#{str_year})")
    int tuitype(@Param("order_id") String order_id,@Param("reject_type") String reject_type,@Param("reject_cause") int reject_cause,@Param("reject_price") long reject_price,@Param("note") String note,@Param("money")long money,@Param("str_day")String str_day,@Param("str_month")String str_month,@Param("str_year")String str_year);

    @Insert("insert into tb_order_rejected " +
            " (order_id,reject_type,reject_price,pid," +
            " money,create_time,str_day,str_month,str_year) " +
            " values " +
            " (#{order_id},#{reject_type},#{reject_price},#{pid} ," +
            " #{money},now(),#{str_day},#{str_month},#{str_year})")
    int unordinary(@Param("order_id") String order_id,@Param("reject_type") int reject_type,@Param("reject_price") long reject_price,@Param("pid")String pid,@Param("money")long money,@Param("str_day")String str_day,@Param("str_month")String str_month,@Param("str_year")String str_year);


    /*
    `type` varchar(45) DEFAULT NULL COMMENT '订单总状态',20
    `send_type` varchar(45) DEFAULT NULL COMMENT '发货状态',20
    `type_desc` varchar(45) DEFAULT NULL,”用户已确认收货“
    `getdell_time` varchar(45) DEFAULT NULL COMMENT '成交时间',now()
     */
    @Update("update tb_order_detail" +
            " set " +
            " type=#{type} , send_type=#{send_type} ,type_desc=#{type_desc}," +
            " getdell_time=#{getdell_time} " +
            " where " +
            " order_id=#{order_id}")
    int updateState(Map<String,Object> map);



//修改评价状态
    @Update("update tb_order_detail set type=30 where order_id=#{order_id}")
    int updateevaulte(@Param("order_id")String order_id);


    @Update(" update tb_order_detail " +
            " set " +
            " type=#{type} ," +
            " type_desc=#{type_desc} ," +
            " closing_time=#{closing_time} " +
            " where " +
            " order_id=#{order_id} ")
    int closeOrder(Map<String,Object> map);

    @Select("select count(1) from tb_order_detail where pid =#{pid} and uid=#{uid}")
    int getNum(@Param("uid") String uid,@Param("pid") String pid);

    @Update("update tb_order_detail set send_type=5 where order_id=#{order_id}")
    int updateSendType(@Param("order_id")String order_id);

    @Update("update tb_order_detail set pay_time=now() ,pay_type=#{pay_type} ,type_desc=#{type_desc}," +
            " payid=#{payid} where order_id ${order_id}")
    int updatePaystate(Map<String,Object> mapOredr);

    @Update("update tb_order_detail set pay_time=null ,pay_type=0 ,type_desc=null," +
            " payid=null where order_id =#{order_id} and payid=1")
    int goBackPaystate(@Param("order_id")String order_id);



    @Select("select ifnull(sum(price),0) from tb_order_detail where uid=#{uid} and order_id ${order_id}")
    int getOrderPriceSum(@Param("order_id")String order_id,@Param("uid") String uid);

    @Select("select ifnull(sum(pay_price),0) from tb_user_bill_detail where order_id ${order_id} and type=3 and state=10 and  uid=#{uid}")
    long getOrderZfbPrice(@Param("order_id")String order_id,@Param("uid") String uid);


}
