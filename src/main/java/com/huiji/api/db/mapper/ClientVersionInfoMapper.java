package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.ClientVersionInfo;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
public interface ClientVersionInfoMapper extends BaseMapper {
    @Select("select * from tb_client_version_info where product_id=#{product_id} and product_version =#{product_version} and channel_id =#{channel_id}")
    ClientVersionInfo searchVersionInfo(Map<String, String> map);
}
