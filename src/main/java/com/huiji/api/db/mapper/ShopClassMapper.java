package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.ShopClass;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 孙文剑 on 2016/8/5 0005.
 */
public interface ShopClassMapper  extends BaseMapper {
    @Select("select * from tb_shop_class where id=#{shopClassId}")
    ShopClass getShopClassByClassId(@Param("shopClassId") int shopClassId );


    @Select("select class_name from tb_shop_class where id=#{id}")
    String getshopClass(@Param("id") int id);
}
