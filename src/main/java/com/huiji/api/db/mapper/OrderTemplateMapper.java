package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.OrderTemplate;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public interface OrderTemplateMapper extends BaseMapper {
    /*
    `template_id` varchar(45) NOT NULL,
  `good_id` int(11) NOT NULL COMMENT '商品共性的id',
  `sub_good_id` int(11) NOT NULL COMMENT '商品的子id',
  `buy_num` int(11) NOT NULL COMMENT '主商品的购买数量',
  `current_price` bigint(21) DEFAULT NULL COMMENT '商品的当前价格',
  `pid` int(11) NOT NULL COMMENT '意向购买指向确定购买的商品id',
  `yu_price` bigint(21) DEFAULT NULL,
  `create_time` varchar(45) DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    @Insert("insert into tb_order_template " +
            "(template_id ,shop_id,good_id,sub_good_id,good_pro,buy_num,current_price,marketPrice,postPrice,pid,yu_price,create_time,str_day,str_month,str_year) " +
            "values " +
            "(#{template_id},#{shop_id},#{good_id},#{sub_good_id},#{good_pro},#{buy_num},#{current_price},#{marketPrice},#{postPrice},#{pid},#{yu_price},#{create_time},#{str_day},#{str_month},#{str_year}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveOrderTemplate(OrderTemplate orderTemplate);
    @Select("select * from tb_order_template where template_id =#{provisionalId} and pid is null ")
    OrderTemplate getSureGood(@Param("provisionalId") String provisionalId,@Param("state") int state);
    @Select("select * from tb_order_template where template_id =#{provisionalId} and pid is not null")
    List<OrderTemplate> getCouldGoods(@Param("provisionalId") String provisionalId,@Param("state") int state);
    @Update("update tb_order_template set state=1 where template_id =#{provisionalId}")
    int updateState(@Param("provisionalId") String provisionalId);
    @Update("update tb_order_template set state=2 where template_id =#{provisionalId}")
    int updateState2(@Param("provisionalId") String provisionalId);

   @Delete("delete from tb_order_template where id=#{id}")
  int delTid(@Param("id") int id);
}
