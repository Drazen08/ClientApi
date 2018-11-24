package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.LogisticsDetail;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */
public interface LogisticsDetailMapper extends BaseMapper {
    /*
     private Integer id;
    private String  logistic_name;
     */
    @Select("select * from tb_logistics_detail ")
    List<LogisticsDetail> getLogistics();
}
