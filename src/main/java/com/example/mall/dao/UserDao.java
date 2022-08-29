package com.example.mall.dao;

import com.example.mall.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from users")
    public List<UserInfo> selectUsers();

    @Insert("insert into users (userId,password) VALUES (#{userId},#{password})")
    public Integer addUser(String userId, String password);

    @Delete("delete from users where id = #{id}")
    public Integer deleteUser(Integer id);

    @Select(" select  * from users where userId = #{userId} and password = #{password} limit 1")
    UserInfo login(String userId, String password);

    @Select("select * from user where id=#{id}")
    public UserInfo selectOneUser(Integer id);

    @Update(" update users set password = #{password} where id = #{id} ")
    public Integer updatePassword(Integer id, String password);

}
