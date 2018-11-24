package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.ChangeBalanceUrl;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 孙文剑 on 2016/8/11 0011.
 */
public interface ChangeBalanceUrlMapper extends BaseMapper {
    @Select("select * from tb_change_balance_url where type=#{type}")
    ChangeBalanceUrl getUrlByType(@Param("type") int type);
}
