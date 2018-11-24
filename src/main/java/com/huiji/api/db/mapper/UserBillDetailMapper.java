package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.UserBillDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by 孙文剑 on 2016/8/13 0013.
 */
public interface UserBillDetailMapper {
    /*
     `id` int(11) NOT NULL,
  `uid` varchar(45) NOT NULL,
  `pay_code_id` varchar(45) NOT NULL,
  `order_id` varchar(45) NOT NULL,
  `pay_price` bigint(45) NOT NULL COMMENT '际实支付金额',
  `pay_balance` bigint(45) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '此次账单的状态',
  `create_time` datetime NOT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `srt_year` varchar(45) DEFAULT NULL,
     */
    @Insert("insert into tb_user_bill_detail " +
            " (out_trade_no,running_number,uid,bill_id,order_id,order_price,pay_price,pay_balance,blance1000,blance2000,type,state,create_time,str_day,str_month,srt_year) " +
            " values " +
            " (#{out_trade_no},#{running_number},#{uid},#{bill_id},#{order_id},#{order_price},#{pay_price},#{pay_balance}" +
            ",#{blance1000},#{blance2000},#{type},#{state},#{create_time},#{str_day},#{str_month},#{srt_year}) " )
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveUserBillDetail(UserBillDetail userBillDetail);

    @Select(" select ifnull(count(1),0) from tb_user_bill_detail where out_trade_no=#{out_trade_no} and state=10")
    int findOrderSuccess(@Param("out_trade_no") String out_trade_no);

    @Select(" select ifnull(count(1),0) from tb_user_bill_detail where out_trade_no=#{out_trade_no} and state in(10,20)")
    int findOrderPayResult(@Param("out_trade_no") String out_trade_no);


    @Delete("delete from tb_user_bill_detail where id = #{id}")
    int  delUserBillDetail(@Param("id") int id);


    @Select("select * from tb_user_bill_detail where order_id=#{order_id} and uid=#{uid} and state =10;")
    List<UserBillDetail> searchSeccessPayDetail(@Param("order_id") String order,@Param("uid") String uid);


    @Select("select Count(1) from tb_user_bill_detail where type=1  and order_id=#{order_id}")
    int findZFBPayNum(@Param("order_id") String order_id);

    @Select("select Count(1) from tb_user_bill_detail where type=2  and order_id=#{order_id}")
    int findWXPayNum(@Param("order_id") String order_id);

    @Select("select * from tb_user_bill_detail where uid=#{uid} and order_id =#{order_id} and type=3 and  state=10;")
    UserBillDetail searOldchYuePay(@Param("uid") String uid,@Param("order_id") String order_id);


    @Update("update tb_user_bill_detail set state=50 where uid=#{uid} and order_id =#{order_id} ")
   int updateBillDetailState(@Param("uid") String uid,@Param("order_id") String order_id);


    @Update("update tb_user_bill_detail set state=50 where uid=#{uid} and out_trade_no =#{out_trade_no} and type=1 and order_id =#{order_id}")
    int updateBillDetailStateByout_trade_noZFB(@Param("uid") String uid,@Param("out_trade_no") String out_trade_no,@Param("order_id") String order_id);

    @Update("update tb_user_bill_detail set state=50 where uid=#{uid} and out_trade_no =#{out_trade_no} and type=2 and order_id =#{order_id}")
    int updateBillDetailStateByout_trade_noWX(@Param("uid") String uid,@Param("out_trade_no") String out_trade_no,@Param("order_id") String order_id);





    @Update("update tb_user_bill_detail set state=20 where uid=#{uid} and id =#{id} ")
    int updateBillDetailStateFail(@Param("uid") String uid,@Param("id") int id);



    //支付宝支付所用
    @Select("select COUNT(1) from tb_user_bill_detail " +
            " where running_number=#{running_number} " +
            "  and state in (10,20) and type =1")
    int findHavedPayResultOrderWithMisId(@Param("running_number") String running_number);

    //支付宝支付所用
    @Select("select * from tb_user_bill_detail where running_number=#{running_number}" +
            " and state=0 and type=1")
    List<UserBillDetail> findUserBillDetailsByMsgId(@Param("running_number") String running_number);
    //支付宝支付所用
    @Update("update tb_user_bill_detail set state=#{state},pay_result_time=NOW() where running_number=#{running_number} and state=0 and type=1" )
    int updateStates(@Param("running_number") String running_number,@Param("state") int state);
    //支付宝支付所用
    @Select("select * from tb_user_bill_detail where running_number=#{running_number}" +
            " and type=3 and order_id ${order_id} and state=10")
    List<UserBillDetail> findYeForBack(@Param("running_number") String running_number,@Param("order_id") String order_id);
    //支付宝支付所用
    @Update("update tb_user_bill_detail set state=50 where running_number=#{running_number}" +
            " and type=3  and state=10")
    int updateYePayState(@Param("running_number") String running_number,@Param("order_id") String order_id);
    @Select("select count(1) from tb_user_bill_detail where running_number=#{running_number}")
    int findMsgId(@Param("running_number") String running_number);

    @Select("select DISTINCT(order_id) from tb_user_bill_detail t where t.running_number =#{running_number} ")
    List<String> getOrdersByMsgId(@Param("running_number") String running_number);

    //select * from tb_user_bill_detail where uid=#{uid} and order_id =#{order_id} and type=3 and  state=10;
    // and t.state=10
    @Select("select * from tb_user_bill_detail t where  t.running_number=#{running_number} and t.type=3 and t.order_id =#{order_id}  ")
    UserBillDetail getUserBillDetailByOrderIdWithYue(@Param("running_number") String running_number,@Param("order_id") String order_id);
    //and state=0
    @Select("select * from tb_user_bill_detail where running_number=#{running_number}" +
            " and type=1 and order_id =#{order_id} ")
    UserBillDetail getUserBillDetailByOrderIdWithPay(@Param("running_number") String running_number,@Param("order_id") String order_id);



    @Select("select IFNULL(sum(blance1000),0) used1000, IFNULL(sum(blance2000),0) used2000 from tb_user_bill_detail t where t.running_number =#{running_number} and type=3 and state=10;")
    Map<String,Long> getUsedBalance(@Param("running_number") String running_number);



    @Select("select DISTINCT(order_id )from tb_user_bill_detail t where t.pay_price=0 and t.running_number=#{running_number} and t.type=3 and t.state=10")
    List<String> getYuePaySuccess(@Param("running_number") String running_number);

}
