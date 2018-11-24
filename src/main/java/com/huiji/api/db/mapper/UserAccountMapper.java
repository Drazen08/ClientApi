package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.UserAccount;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/8 0008.
 */
public interface UserAccountMapper extends BaseMapper {
    @Select("select * from tb_user_account where uid =#{uid}")
    List<UserAccount> getBalance1(@Param("uid") String uid);

    @Select("select * from tb_user_account where uid =#{uid} and type=1000")
    UserAccount getUserAccountByUserIdWith1000(@Param("uid") String uid);

    @Update("update tb_user_account set balance=#{balance} where uid =#{uid} and type=1000")
    int updateUserAccountBalanceWith1000(@Param("uid") String uid,@Param("balance") Long balance);

    @Select("select * from tb_user_account where uid =#{uid} and type=2000")
    UserAccount getUsetAccountByUserIdWith2000(@Param("uid") String uid);

    @Update("update tb_user_account set balance=#{balance} where uid =#{uid} and type=2000")
    int updateUserAccountBalanceWith2000(@Param("uid") String uid,@Param("balance") Long balance);
    @Insert("insert into tb_user_account values(null,#{uid},'0',1000,now(),#{str_day},#{str_month},#{str_year})")
    int createUserAccount1000(@Param("uid")String uid,@Param("str_day")String str_day,@Param("str_month")String str_month,@Param("str_year")String str_year);
    @Insert("insert into tb_user_account values(null,#{uid},'0',2000,now(),#{str_day},#{str_month},#{str_year})")
    int createUserAccount2000(@Param("uid")String uid,@Param("str_day")String str_day,@Param("str_month")String str_month,@Param("str_year")String str_year);




    @Update("update tb_user_account set balance=balance+#{balance} where uid =#{uid} and type=1000")
    int rollBackUserAccountBalanceWith1000(@Param("uid") String uid,@Param("balance") Long balance);


    @Update("update tb_user_account set balance=balance+#{balance} where uid =#{uid} and type=2000")
    int rollBackUserAccountBalanceWith2000(@Param("uid") String uid,@Param("balance") Long balance);
}
