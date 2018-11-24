package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.GoodEvaluate;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public interface GoodEvaluateMapper extends BaseMapper {
    @Select("select * from tb_good_evaluate where good_id =#{good_id}")
    List<GoodEvaluate> getGoodEvaluatesByGoodId(@Param("good_id") int good_id);


    @Select("select * from tb_good_evaluate where good_id =#{good_id} and good_star between #{good_mix} and #{good_max} limit #{page},#{show}")
    List<GoodEvaluate> getGoodEvaluates(@Param("good_id") int goodId,@Param("good_mix") int good_mix,@Param("good_max") int good_max,@Param("page")int page,@Param("show")int show);

    @Insert("insert into tb_good_evaluate values(null,#{good_id},#{order_id},#{good_star},#{good_content},now(),#{str_day},#{str_month},#{str_year})")
    int goodsEve(@Param("good_id") int good_id,@Param("order_id") String order_id,@Param("good_star")int good_star,@Param("good_content") String good_content,@Param("str_day")String str_day,@Param("str_month")String str_month,@Param("str_year")String str_year);


}

