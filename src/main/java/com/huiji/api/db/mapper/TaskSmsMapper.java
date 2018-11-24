package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.TaskSms;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by 王潇雨 on 2016/7/16.
 */
public interface TaskSmsMapper extends BaseMapper {
    @Select("SELECT active_code AS activeCode  FROM tb_task_sms WHERE phone=#{phone} and type=#{type}  and NOW()<expired_time order by id desc limit 1")
    TaskSms queryByPhone(@Param("phone") String phone,@Param("type") int type);
    @Select("SELECT count(*) FROM tb_task_sms where active_code=#{activeCode} and type=#{type} and now()< expired_time ")
    int searchSameActiveCode(@Param("activeCode") int activeCode,@Param("type") int type);
    @Insert("INSERT INTO tb_task_sms(uid,phone,msg,active_code,state,create_time,expired_time,type,str_day,str_month,str_year) " +
            "VALUES(#{uid},#{phone},#{msg},#{activeCode},#{state},#{createTime},#{expiredTime},#{type},#{str_day},#{str_month},#{str_year})")
    int insert(TaskSms taskSms);
    @Update("update tb_task_sms set uid=#{uid} where type=#{type} and phone=#{phone}")
     int updateUid(@Param("uid") String uid,@Param("phone") String phone,@Param("type") int type);
    @Update("update tb_task_sms set expired_time='1999-10-10 23:11:00' where type=#{type} and  phone=#{phone} and now()<=expired_time")
    int updateExpiredTime(@Param("type") int type,@Param("phone") String phone);
    @Select("select phone from tb_task_sms where active_code =#{activeCode} and type=#{type} and now()<expired_time")
    String searchPhone (@Param("activeCode") String activeCode,@Param("type") int type);
}
