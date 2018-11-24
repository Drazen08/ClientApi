package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.RollbackMoney;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Administrator on 2016/9/13.
 */
public interface RollbackMoneyMapper extends BaseMapper {
    /*
     private String  bill_id;
    private String  relative_id;
    private String  relative_type;
    private Long    change_money;
    private String  rollback_reason;
    private String  create_time;
    private String  str_day;
    private String  str_month ;
    private String  str_year;
     */


    @Insert(" insert into tb_rollback_money " +
            " (uid,bill_id,relative_id,relative_type," +
            "change_money,rollback_reason,create_time,str_day,str_month,str_year) " +
            " values " +
            " (#{uid},#{bill_id},#{relative_id},#{relative_type},#{change_money}" +
            " ,#{rollback_reason},#{create_time},#{str_day},#{str_month},#{str_year}) ")
    int saveRollbackMoney(RollbackMoney rollbackMoney);
}
