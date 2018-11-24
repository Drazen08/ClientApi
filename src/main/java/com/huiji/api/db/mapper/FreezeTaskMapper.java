package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.FreezeTask;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Jingxiang on 2016/9/2.
 */
public interface FreezeTaskMapper extends BaseMapper {
    @Select("select * from tb_task_freeze  where order_id=#{order_id} and DATE_SUB(CURDATE(), INTERVAL 3 DAY) <= date(create_time); ")
    FreezeTask getfreezeInfo(@Param("order_id") String order_id);

    @Update("update tb_task_freeze " +
            "set" +
            " state=5000,start_time='1990-10-10 12:00:00',opt_num=opt_num+1, " +
            " opt_desc=#{opt_desc},opt_time=now() " +
            "where order_id=#{order_id}")
    int UpdateInThreeDay(@Param("opt_desc") String opt_desc, @Param("order_id") String order_id);
    //(String seller_id, String order_id, Long price, Integer state, Integer opt_num, String opt_desc,
    // String opt_time, String create_time, String start_time, String str_year, String str_month,
    // String str_day)

    @Insert("insert into tb_task_freeze " +
            " (seller_id,order_id,price,state,opt_num,opt_desc,opt_time,create_time, " +
            " start_time,str_year,str_month,str_day) " +
            " values " +
            " (#{seller_id},#{order_id},#{price},#{state} " +
            " ,#{opt_num},#{opt_desc},#{opt_time},#{create_time} " +
            " ,#{start_time},#{str_year},#{str_month},#{str_day}) ")
    int saveFreezeTask(FreezeTask freezeTask);
}
