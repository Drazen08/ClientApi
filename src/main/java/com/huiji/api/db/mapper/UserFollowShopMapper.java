package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.UserFollowShop;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.*;

/**
 * Created by Jingxiang on 2016/8/9.
 */
public interface UserFollowShopMapper extends BaseMapper {
    @Select("select * from tb_user_followshop where uid=#{uid} and shop_id=#{shop_id} and state=1 ")
    UserFollowShop userfollow(@Param("uid") String uid,@Param("shop_id") String shop_id);
    @Select("select * from tb_user_followshop where uid=#{uid} and shop_id=#{shop_id}  ")
    UserFollowShop userfollow1(@Param("uid") String uid,@Param("shop_id") String shop_id);
    @Insert("insert into tb_user_followshop(uid,shop_id,state) values(#{uid},#{shop_id},1)")
    int followshop(@Param("uid") String uid,@Param("shop_id") String shop_id);

/*
    @Delete("delete from tb_user_followshop where uid=#{uid} and shop_id=#{shop_id}")
    int dontfollowShop(@Param("uid") String uid,@Param("shop_id") String shop_id);
*/
    @Update("update tb_user_followshop set state=#{state} where uid=#{uid} and shop_id=#{shop_id}")
    int notFollow(@Param("state")int state,@Param("uid")String uid,@Param("shop_id") String shop_id);
    @Update("update tb_shop set listener_num=${listener_num} where id=#{shop_id}")
    int changeFollow(@Param("listener_num")String listener_num,@Param("shop_id") String shop_id);


}
