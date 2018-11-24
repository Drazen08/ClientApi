package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.UserAddress;
import com.huiji.api.db.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 孙旌翔 on 2016/7/20.
 */
public interface UserAddressMapper extends BaseMapper {


    //1012 获取用户地址列表
    @Select("select * from tb_user_address where uid=#{uid} order by top desc")
    List<UserAddress> getuserAddress(@Param("uid") String uid);
    //1013  增加用户收货地址
    @Insert("insert into tb_user_address(name,phone,uid,province,city,area,street,zipcode,address) values(#{name},#{phone},#{uid},#{province},#{city},#{area},#{street},#{zipcode},#{address})")
    int insertAddress(@Param("name") String name, @Param("phone") String phone, @Param("uid") String uid, @Param("province") String province, @Param("city") String city, @Param("area") String area, @Param("street") String street, @Param("zipcode") String zipcode, @Param("address") String address);
    //1014  修改用户收货地址
    @Update("update tb_user_address set name=#{name},phone=#{phone},province=#{province},city=#{city},area=#{area},street=#{street},zipcode=#{zipcode},address=#{address} where id=#{id} and uid=#{uid}")
    int updateAddress(@Param("id") int id, @Param("name") String name, @Param("phone") String phone, @Param("province") String province, @Param("city") String city, @Param("area") String area, @Param("street") String street, @Param("zipcode") String zipcode, @Param("address") String address,@Param("uid") String uid);
    //1015  删除用户收货地址
    @Delete("delete from tb_user_address where id=#{id}")
    int deleteAddress(@Param("id") int id);
    @Update("update tb_user_address set top=1 where uid=#{uid} and id=#{id}")
    int updateAdminTopById(@Param("uid")String uid,@Param("id")int id);
    @Update("update tb_user_address set top=0 where top=1 and uid=#{uid}")
    int updateTopToZero(@Param("uid")String uid);
    @Select("select * from tb_user_address where uid =#{uid} and top =1 ")
    UserAddress getUserDufaultAddress(@Param("uid") String uid);
    @Select("select * from tb_user_address where id=#{id}")
    UserAddress getUserAddressById(@Param("id") int id);
    @Select("select * from tb_user_address where uid =#{uid}")
    List<UserAddress> getUserAddress(@Param("uid") String uid);
}
