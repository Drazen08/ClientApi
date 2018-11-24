package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.SelectPorperty;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface SelectPorpertyMapper extends BaseMapper {
    @Select("select * from tb_good_selected_spec where good_id =#{goodId}")
    List<SelectPorperty> getGoodPropertysByGoodId(@Param("goodId") String goodId);
}
