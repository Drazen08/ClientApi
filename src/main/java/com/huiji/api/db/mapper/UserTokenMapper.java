package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.UserToken;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by 孙文剑 on 2016/7/17 0017.
 */
public interface UserTokenMapper extends BaseMapper {
    /*
    private String   uid;
    private String   token;
    private String   expired_time;
    private Integer  state;
     */
    @Select("select count(1) from tb_user_token where token=#{tokenCode}")
    int SearchSameTokenCode(String tokenCode);
    @Insert("insert into tb_user_token (uid,token,expired_time,state) values(#{uid},#{token},#{expired_time},#{state})")
    int save(UserToken userToken);
    @Update("update tb_user_token set expired_time='1999-10-10 23:11:00' where uid=#{uid} and now()<expired_time and state='1'")
    int updateTokenExpired_time(String uid);
    @Select("select * from tb_user_token where token=#{tokenCode} and now()<expired_time")
    UserToken SearchSameToken(String tokenCode);
    @Update("update tb_user_token set state='2' where token=#{token}")
    int updateTokenType(String token);

}
