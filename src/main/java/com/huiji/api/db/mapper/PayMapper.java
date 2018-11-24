package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.Pay;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/8 0008.
 */
public interface PayMapper extends BaseMapper {
    @Select("select * from tb_pay limit 1,2")
    List<Pay> getPays();

}
