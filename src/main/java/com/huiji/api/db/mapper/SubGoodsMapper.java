package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.SubGoods;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public interface SubGoodsMapper extends BaseMapper {
    @Select("select * from tb_goods_spec where goods_pid =#{goodId} and online=1 ")
    List<SubGoods> getSubGoodsByGoodId(@Param("goodId") String goodId);
    @Select("select * from tb_goods_spec where id=#{id} and online=1")
    SubGoods getSubGoodById(@Param("id") int id);
    @Select("select * from tb_goods_spec where id=#{id} and online<>1")
    SubGoods getSubGoodById0(@Param("id") int id);
    @Select("select * from tb_goods_spec where id=#{id}")
    SubGoods getSubGood(@Param("id") int id);

}
