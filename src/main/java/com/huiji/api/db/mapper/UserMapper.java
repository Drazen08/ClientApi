package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.UserEntity;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by 王潇雨 on 2016/7/16.
 */
public interface UserMapper extends BaseMapper {
    @Select("SELECT * FROM tb_user where phone=#{phone}")
    UserEntity queryByPhone(@Param("phone") String phone);
    @Insert("INSERT INTO tb_user(uid,phone,username,pwd,create_time,str_day,str_month,str_year) VALUES(#{uid},#{phone},#{username},#{pwd},now(),#{str_day},#{str_month},#{str_year})")
    int insertUser(@Param("uid") String uid, @Param("phone") String phone, @Param("username") String username, @Param("pwd") String pwd,@Param("str_day")String str_day,@Param("str_month")String str_month,@Param("str_year")String str_year);
    @Update("UPDATE tb_user SET phone=#{phone},username=#{username} where uid=#{uuid}")
    int updatePhone(@Param("phone") String phone,@Param("username") String username,@Param("uuid") String uuid);
    @Update("UPDATE tb_user SET paypwd=#{payPassword} where uid=#{uid}")
    int updatePaypwd(@Param("payPassword") String payPassword,@Param("uid") String uid);
    //1001 登陆
    @Select("SELECT * from tb_user where phone=#{phone}")
    UserEntity login(@Param("phone") String phone);
    @Update("update tb_task_sms set uid=#{uid} where type='1' and phone=#{phone} ")
    int Send(@Param("uid") String uid,@Param("phone") String phone);
    @Select("select uid from tb_user where phone=#{phone}")
    String  searchUid(@Param("phone") String phone);
    @Select("select count(1) from tb_user where phone=#{phone}")
    int searchPhone(@Param("phone") String phone);
    @Update("update tb_user set pwd=#{newPw} where uid =#{uid}")
    int updateUserPw(@Param("newPw") String newPw,@Param("uid") String uid);
    @Select("SELECT * FROM tb_user where uid=#{uid}")
    UserEntity queryByUid(@Param("uid") String uid);
    @Update("update tb_user set nickname =#{nickname} where uid=#{uid} ")
    int updateNickName(@Param("nickname")String nickname,@Param("uid")String uid);



    //sho1001 判断用户是否关注该商品
}
