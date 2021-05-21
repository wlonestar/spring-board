package com.wjl.mapper;

import com.wjl.model.Comment;
import com.wjl.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    // 发布留言，插入数据库
    @Insert("insert into comment (username, comment, time) values (#{username}, #{comment}, #{time})")
    void addComment(Comment comment);

    // 寻找username,为“发布留言”功能提供 username
    @Select("select * from user where username = #{username}")
    User findByUsername(@Param("username") String username);

    // 展示所有留言
    @Select("select * from comment")
    List<Comment> showAllComment();

    @Select("select comment from comment")
    List<String> listAllComment();

}
