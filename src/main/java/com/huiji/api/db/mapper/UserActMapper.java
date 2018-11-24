package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.UserAct;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/5.
 */
public interface UserActMapper extends BaseMapper {
   /* //用户账户查询(全部)
    @Select("select * from tb_user_balance where uid=#{uid} and order by create_time desc limit #{currentPage},#{show}")
    List<UserAct> userbalance(@Param("uid") String uid,@Param("currentPage") int currentPage,@Param("show")int show);
*/
    //用户账户查询（充值/退款）
    @Select("select * from tb_user_balance where uid=#{uid} and act_type in ${act_type} and substr(create_time,1,7)=#{str_month} order by create_time desc limit #{currentPage},#{show}")

    List<UserAct> userbalance(@Param("uid") String uid,@Param("act_type") String act_type,@Param("str_month") String str_month,@Param("currentPage") int currentPage,@Param("show")int show);

    @Select("select * from tb_user_balance where uid=#{uid}")
    List<UserAct> getUserChangeBalanceByUserId(@Param("uid") String uid);


    /*`id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(45) NOT NULL,
  `bill_id` varchar(45) DEFAULT NULL COMMENT '关联的单号',
  `act_type` int(11) DEFAULT NULL COMMENT '支付宝充值1-\r\n微信充值2-\r\n退款3-\r\n余额支付4-\r\n提现5',
  `url` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL COMMENT '+ -',
  `change_money` bigint(45) DEFAULT '0' COMMENT '变动金额',
  `before_money` bigint(45) DEFAULT '0' COMMENT '变动前金额',
  `after_money` bigint(45) DEFAULT '0' COMMENT '变动后金额',
  `balance1000` bigint(45) DEFAULT '0' COMMENT '可提现的变动数目',
  `balance2000` bigint(45) DEFAULT '0' COMMENT '不可提现的变动数目',
  `opt_desc` varchar(45) DEFAULT NULL COMMENT '变动描述',
  `create_time` datetime DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,*/
    @Insert("insert into tb_user_balance " +
            "(uid,bill_id,act_type,bill_id_type,url,type,change_money,before_money" +
            ",after_money,balance1000,balance2000,opt_desc,create_time,str_day,str_month,str_year)" +
            "values" +
            "(#{uid},#{bill_id},#{act_type},#{bill_id_type},#{url},#{type},#{change_money},#{before_money},#{after_money}" +
            ",#{balance1000},#{balance2000},#{opt_desc},#{create_time},#{str_day},#{str_month},#{str_year})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveChangeBalance( UserAct userAct);

    @Delete("delete from tb_user_balance where id = #{id}")
     int delUserBalance(@Param("id") int id);

    @Select("select * from tb_user_balance where uid=#{uid} order by id desc limit 1")
    UserAct getLastAfterMoneyByUserID(@Param("uid") String uid);


    @Select("select * from tb_user_balance where bill_id=#{bill_id} ")
    UserAct getbalancechange(@Param("bill_id")String bill_id);

    @Update("update tb_user_balance set bill_id=#{bill_id} where bill_id=#{old_bill_id}")
    int updateBlandeBillId(@Param("bill_id")String bill_id,@Param("old_bill_id") String old_bill_id);

}
