package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.ShopBalance;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 孙文剑 on 2016/8/18 0018.
 */
public interface ShopBalanceMapper extends BaseMapper {
    @Select("select * from tb_shop_balance where seller_id=#{seller_id} order by id desc limit 1 ")
    ShopBalance searchLastBalance(@Param("seller_id") String seller_id);
    /*
     private Integer id;
    private String  seller_id;
    private String  bill_id;
    private Integer act_type;
    private String  url;
    private String  type;
    private Long    change_money;
    private Long    before_money;
    private Long    after_money;
    private String  opt_desc;
    private String  create_time;
    private String  str_day;
    private String  str_month;
    private String  str_year;
     */
    @Insert("insert into tb_shop_balance " +
            " (" +
            "  seller_id, bill_id, act_type ," +
            "  url, type ,change_money,before_money, " +
            "  after_money ,opt_desc,create_time,str_day ," +
            "  str_month,str_year" +
            "  ) " +
            " values " +
            " (" +
            "  #{seller_id},#{bill_id},#{act_type},#{url}, " +
            "  #{type},#{change_money},#{before_money},#{after_money}, " +
            "  #{opt_desc},#{create_time},#{str_day},#{str_month},#{str_year} " +
            " ) ")
    int saveNewShopBalance(ShopBalance shopBalance);

}
