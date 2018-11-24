package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.ShopEvalute;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Jingxiang on 2016/8/11.
 */
public interface ShopEvaluteMapper extends BaseMapper {
    @Insert("insert into tb_shop_evaluate values(null,#{shop_id},#{order_id},#{shop_star},null,now(),#{str_day},#{str_month},#{str_year})")
    int shopEve(@Param("shop_id") int shop_id,@Param("order_id") String order_id,@Param("shop_star")int shop_star,@Param("str_day")String str_day,@Param("str_month") String str_month,@Param("str_year")String str_year);


    @Select("SELECT AVG(shop_star) FROM tb_shop_evaluate where shop_id=#{shop_id};")
    Integer shopStar(@Param("shop_id") int shop_id);
}
