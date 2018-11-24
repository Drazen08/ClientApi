package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.UserEntity;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by 孙文剑 on 2016/7/17 0017.
 */
public interface UserSessionMapper extends BaseMapper {
    @Select("select u.token from tb_user_session s join tb_user_token u on s.uid=u.uid where s.sid=#{sid} and now()<s.expired_time")
    String searchTokenBySid(@Param("sid") String sid);
    @Select("select s.* from tb_user_session s where s.sid =#{sid} and now()<s.expired_time")
    UserSession searchUserSessionBySid(@Param("sid") String sid);

    @Select("select uid from tb_user_session where sid=#{sid}")
    String loginuid(@Param("sid") String sid);

    //1001 非首次登陆的登录
    @Update("update tb_user_session set sid=#{sid},expired_time=#{expired_time} where uid=#{uid} and product_id=#{product_id}")
    int login(@Param("sid") String sid,@Param("expired_time") String expired_time,@Param("uid") String uid,@Param("product_id") String product_id);
    //1001 首次登陆
    @Insert("insert tb_user_session(uid,sid,product_id,expired_time,create_time,str_day,str_month,str_year) values (#{uid},#{sid},#{product_id},#{expired_time},now(),#{str_day},#{str_month},#{str_year})")
    int loginFirst(@Param("uid") String uid,@Param("sid") String sid,@Param("product_id") String product_id,@Param("expired_time") String expired_time,@Param("str_day")String str_day,@Param("str_month")String str_month,@Param("str_year")String str_year);
    //1001 查询是否为首次登录
    @Select("select product_id from tb_user_session where uid=#{uid} and product_id=#{product_id}")
    UserSession searchProductId(@Param("uid") String uid,@Param("product_id") String product_id);

    //1016 登出
    @Update("update tb_user_session set sid='',expired_time=#{expired_time} where sid=#{sid} and product_id=#{product_id}")
    int logout(@Param("product_id") String product_id,@Param("expired_time") String expired_time,@Param("sid") String sid);


    @Select("select u.* from tb_user_session s join tb_user u on s.uid=u.uid where s.sid=#{sid} and now()<s.expired_time")
    UserEntity searchUserBySid(@Param("sid") String sid);
    /*@Select("select u.token from tb_user_session s join tb_user_token u on s.uid=u.uid where s.sid=#{sid} and now()<s.expired_time")
    String searchTokenBySid(@Param("sid") String sid);
    @Select("select s.* from tb_user_session s where s.sid =#{sid} and now()<s.expired_time")
    UserSession searchUserSessionBySid(@Param("sid") String sid);*/



    //Test
    @Update("update tb_user_session set create_time='2016-10-09' where uid=#{uid}")
    int updateTime1(@Param("uid") String uid);


    @Update("update tb_user_session set str='2016' where uid=#{uid}")
    int updateTime2(@Param("uid") String uid);
}
