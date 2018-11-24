package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.Goods;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/4.
 */
public interface GoodsMapper extends BaseMapper {
        //商品搜索
    @Select("select * from tb_goods_detail where goodsname like #{content} and online=1 order by ${type} desc limit #{page},#{show}" )
    List<Goods> sarchgoods(@Param("content") String content,@Param("type") String type,@Param("page") int currentPage,@Param("show")int show);
    //goo 1000
    @Select("select * from tb_goods_detail where id =#{goodId} and online=1")
    Goods getGoodByGoodId(@Param("goodId") int  goodId);
    @Select("select * from tb_goods_detail where id =#{id}")
    Goods getGoodById(@Param("id") int id);

    @Select("select count(1) from tb_goods_detail where shopid=#{shopid} and online=1")
    int getShopGoodsNum(@Param("shopid") int shopid);

    @Select("select * from tb_goods_detail where shopid=#{shopid} and online=1 order by ${orderby} limit #{page},#{show}")
    List<Goods> shopproducts(@Param("shopid") int shopid,@Param("orderby") String orderby,@Param("page") int currentPage,@Param("show")int show);


    @Select("select * from tb_goods_detail where goodsname like #{content} and online=1 and shopid=#{shopid} limit #{page},#{show}")
    List<Goods> shopsearch(@Param("content") String content,@Param("shopid") int shopid,@Param("page") int page,@Param("show")int show);

    //点击导航查询分类商品
    @Select("select * from tb_goods_detail where t_id=#{t_id} order by num desc")
    List<Goods> daohang(@Param("t_id") int t_id);



}
