package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.Area;
import com.huiji.api.db.entity.City;
import com.huiji.api.db.entity.DicNavType;
import com.huiji.api.db.entity.Province;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 王潇雨 on 2016/7/19.
 */
public interface ProvinceMapper extends BaseMapper {
    @Select("select * from tb_dic_province ")
    List<Province> searchPro();
    @Select("select * from tb_dic_city where pid=#{id}")
    List<City> searchCity(@Param("id") Integer id);
    @Select("select * from tb_dic_area where pid=#{id}")
    List<Area> searchArea(@Param("id") Integer id);

}
