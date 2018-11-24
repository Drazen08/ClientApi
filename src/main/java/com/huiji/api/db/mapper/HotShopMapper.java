package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.HotShop;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public interface HotShopMapper extends BaseMapper {
    @Select("select * from tb_hot_shop where city_id=#{city_id} limit 0,4")
    List<HotShop> gethotshop(@Param("city_id")int city_id);
}
