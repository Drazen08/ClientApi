package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.Post;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/8 0008.
 */
public interface PostMapper extends BaseMapper {
    @Select("select * from tb_post where ${bound}")
    List<Post> getPosts(@Param("bound") String bound);
}
