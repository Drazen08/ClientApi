package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.Market;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public interface MarketMapper extends BaseMapper {
    @Select("select * from tb_market_shop  where city_id=#{city_id} limit 0,4")
    List<Market> getmarkets(@Param("city_id") int city_id);
}
