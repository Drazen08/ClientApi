package com.huiji.api.db.mapper;

import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Jingxiang on 2016/8/12.
 */
public interface TaskUserBankMapper extends BaseMapper {
    /* `id` int(11) NOT NULL,
  `uid` varchar(45) DEFAULT NULL,
  `bill_id` varchar(45) DEFAULT NULL COMMENT '提现订单号',
  `card_id` varchar(45) DEFAULT NULL,
  `money` bigint(20) DEFAULT '0',
  `name` varchar(45) DEFAULT NULL,
  `userphone` varchar(45) DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '默认 0 成功10 失败20',
  `create_time` datetime DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
  `bank_name` varchar(45) DEFAULT NULL,*/


    @Insert("insert into tb_task_user_get_money" +
            " (uid,money,bank_id,card_num,state,bill_id," +
            "bankmaster,create_time,str_day,str_month,str_year)" +
            " values" +
            " (#{uid},#{money},#{bank_id},#{card_num},#{state},#{bill_id}," +
            "#{bankmaster},now(),#{str_day},#{str_month},#{str_year})")
    int usergetmoney(@Param("uid") String uid,@Param("money") long money,@Param("bank_id") int bank_id,@Param("card_num") String card_num,@Param("state")int state,@Param("bill_id")String bill_id,@Param("bankmaster") String bankmaster,@Param("str_day")String str_day,@Param("str_month")String str_month,@Param("str_year")String str_year);

  @Insert("insert into tb_user_get_money" +
          " (uid,bill_id,card_id,money,name,userphone," +
          " state,create_time,str_day,str_month,str_year )" +
          " values" +
          " (#{uid},#{bill_id},#{card_id},#{money},#{name},#{userphone}," +
          "#{state},now(),#{str_day},#{str_month},#{str_year})")
  int addGetMoney(@Param("uid") String uid,@Param("bill_id") String bill_id,@Param("card_id")String card_id,@Param("money")long money,@Param("name")String name,@Param("userphone")String userphone,@Param("state")int state,@Param("str_day")String str_day,@Param("str_month")String str_month,@Param("str_year")String str_year);
}
