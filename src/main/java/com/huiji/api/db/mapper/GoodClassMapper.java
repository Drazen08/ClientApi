package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.GoodClass;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/13.
 */
public interface GoodClassMapper extends BaseMapper {
    //二级分类的首页快捷导航
    @Select("select * from tb_goods_class where pid =0")
    List<GoodClass> dic1002();
}
