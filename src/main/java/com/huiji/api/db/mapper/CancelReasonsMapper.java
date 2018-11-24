package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.CancelReasons;
import com.huiji.api.db.entity.RejectedReasons;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
public interface CancelReasonsMapper extends BaseMapper {
    @Select("select * from tb_order_cancel_reasons")
    List<CancelReasons> getCancelReasons();
}
