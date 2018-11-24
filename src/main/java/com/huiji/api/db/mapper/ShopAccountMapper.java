package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.ShopAccount;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by 孙文剑 on 2016/8/18 0018.
 */
public interface ShopAccountMapper extends BaseMapper {

    /*
    `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` varchar(45) NOT NULL,
  `balance` bigint(45) DEFAULT '0' COMMENT '店家账户余额',
  `get_money` bigint(45) DEFAULT '0' COMMENT '可提现金额',
  `account_type` int(11) DEFAULT NULL COMMENT '帐户类型  1000 资金帐户',
  `create_time` datetime DEFAULT NULL,
  `str_day` varchar(45) DEFAULT NULL,
  `str_month` varchar(45) DEFAULT NULL,
  `str_year` varchar(45) DEFAULT NULL,
     */
    @Update("update tb_shop_account " +
            " set " +
            " balance=#{balance} " +
            " where seller_id=#{seller_id} and account_type=#{account_type}")
    int updateShopAccount(@Param("seller_id") String seller_id,@Param("account_type") int account_type,@Param("balance") Long balance);

    @Select("select * from tb_shop_account where seller_id=#{seller_id} and account_type=#{account_type}")
    ShopAccount getShopAccount(@Param("seller_id") String seller_id,@Param("account_type") int account_type);

}
