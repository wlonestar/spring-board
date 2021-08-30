package com.wjl.mapper;

import com.wjl.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    // 注册成功，插入一条数据
    @Insert("insert into user(username,password,token) values (#{username},#{password},#{token})")
    void add(User user);

    // 检验注册的username是否已经存在数据库中，传进username进行与数据库比较
    @Select("select * from user where username = #{username}")
    User findByUsername(@Param("username") String username);

    //登录用：检验账号密码是否正确
    @Select("select * from user where username = #{username} and password = #{password}")
    User findByUsername_login(@Param("username") String username,
                              @Param("password") String password);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select username from user where username=#{username}")
    List<String> exitUsername();

    @Select("select * from user where username = #{username}")
    User username_to_setToken(@Param("username") String username);

}
