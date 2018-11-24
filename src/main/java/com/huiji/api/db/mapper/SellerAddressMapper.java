package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.SellerAddress;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 孙文剑 on 2016/8/8 0008.
 */
public interface SellerAddressMapper extends BaseMapper {

    @Select("select * from tb_seller_address where sid =#{sid} and top =1 ")
    SellerAddress getSellerDufaultAddress(@Param("sid") String sid);
}
