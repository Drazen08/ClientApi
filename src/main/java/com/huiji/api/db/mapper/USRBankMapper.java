package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.UserBank;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/4 0004.
 */
public interface USRBankMapper extends BaseMapper {

    //查詢用戶綁定銀行卡列表
    @Select("select id,cardid,banktype from tb_user_bank where uid=#{uid}")
    List<UserBank> getUserBanks(@Param("uid") String uid);

    @Select("select * from tb_user_bank where cardid=#{cardId}")
    UserBank getUserBankByCardId(@Param("cardId") String cardId);
    /*
    `uid` varchar(45) DEFAULT NULL,
  `cardid` varchar(45) DEFAULT NULL COMMENT '卡号',
  `banktype` varchar(45) DEFAULT NULL COMMENT '银行名称',
  `name` varchar(45) DEFAULT NULL COMMENT '持卡人',
  `userphone` varchar(45) DEFAULT NULL COMMENT '开户人手机号',
  `create_time` varchar(45) DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */

    @Insert(" insert into tb_user_bank " +
            " (uid,cardid,banktype,name,userphone, " +
            " create_time,str_day,str_month,str_year) " +
            " values " +
            " (#{uid},#{cardid},#{banktype},#{name},#{userphone}, " +
            " #{create_time},#{str_day},#{str_month},#{str_year})")
    int saveUserBank(UserBank userBank);

    @Select("select phone from tb_user where uid=#{uid}")
    String phone(@Param("uid") String uid);
    @Select("select username from tb_user where uid=#{uid}")
    String username(@Param("uid") String uid);
    @Select("select cardid from tb_user_bank where id=#{id}")
    String cardNum(@Param("id") int id);

}
