package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.Shop;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/4 0004.
 */
public interface ShopMapper extends BaseMapper {                                           //shop_star
    @Select("select * from tb_shop where 1=1 and name like #{searchContent} and state=80 order by ${orderby} limit #{ignore},#{show}")
    List<Shop> getShopInfoAll(@Param("ignore") int ignore,@Param("show") int show,@Param("orderby") String orderby,@Param("searchContent") String searchContent);

    @Select("select * from tb_shop where id =#{shopId}")
    Shop getShopById(@Param("shopId") int shopId);

    @Update("update tb_shop set listener_num=listener_num+1 where id =#{shopId} ")
    int plusListenerNum(@Param("shopId") int shopId);

    @Select("select * from tb_shop where 1=1 and class_id1=#{class_id1} and state=80  order by ${orderby} desc limit #{ignore},#{show}")
    List<Shop> ShouyeDianji(@Param("class_id1")int class_id1,@Param("orderby") String orderby,@Param("ignore") int ignore,@Param("show") int show);


    @Update("update tb_shop set shop_star=#{shop_star} where id=#{shopId}")
    int updateShopStar(@Param("shopId") int shopId,@Param("shop_star") int shop_star);
}
