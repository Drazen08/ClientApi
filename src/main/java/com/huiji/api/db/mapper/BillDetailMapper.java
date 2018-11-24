package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.BillDetail;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Jingxiang on 2016/8/22.
 */
public interface BillDetailMapper extends BaseMapper {
    @Select("select * from tb_user_bill_detail where order_id=#{order_id} and type=3 and state=10")
    BillDetail getbalanceBill(@Param("order_id") String order_id);
}
