package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.RejectedReasons;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
public interface RejectedReasonsMapper extends BaseMapper {
    @Select("select * from tb_order_rejected_reasons")
    List<RejectedReasons> getRejectedReasons();
}
