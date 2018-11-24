package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.SelectSubProperty;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface SelectSubPropertyMapper extends BaseMapper {
    @Select("select * from tb_good_sub_selected_spec where select_pro_id =#{proprytyId}")
    List<SelectSubProperty> getGoodSubPropertysByProprytyId(@Param("proprytyId") String proprytyId);
}
