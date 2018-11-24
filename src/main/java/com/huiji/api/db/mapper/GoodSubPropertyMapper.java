package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.GoodSubProperty;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public interface GoodSubPropertyMapper extends BaseMapper {
    @Select("select * from tb_good_sub_proertys where id in(select good_sub_property_id from tb_good_selected_spec where good_property_id =#{proprytyId});")
    List<GoodSubProperty> getGoodSubPropertysByProprytyId(@Param("proprytyId") String proprytyId);


    @Select("select * from tb_good_sub_proertys where good_property_id =#{proprytyId}")
    GoodSubProperty getpp(@Param("proprytyId") String proprytyId);
}
