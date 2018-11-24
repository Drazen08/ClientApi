package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.DicNavType;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/7/18 0018.
 */
public interface DicNavTypeMapper extends BaseMapper {
    @Select("select * from tb_shop_class where pid=#{id} ")
    List<DicNavType> searchLevel1(@Param("id") Integer id);
    @Select("select * from tb_shop_class where pid='0'")
    List<DicNavType> searchRoots();
}
