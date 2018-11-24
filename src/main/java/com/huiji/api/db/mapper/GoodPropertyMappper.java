package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.GoodProperty;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public interface GoodPropertyMappper extends BaseMapper {
    @Select("select * from tb_good_propertys where id in (select good_property_id from tb_good_selected_spec where good_id=#{goodId} group by good_property_id);")
    //@Select("select * from tb_good_selected_spec where good_id =#{goodId}")
    List<GoodProperty> getGoodPropertysByGoodId(@Param("goodId") String goodId);
}
