package com.wjl.service.intf;

import com.wjl.entity.Comment;

import java.util.List;

/**
 * @author: wjl
 * @date: 2021/10/7 15:16
 * @version: v1.0
 */
public interface CommentService {

    List<Comment> findAll();

    Comment findById(Integer id);

    Comment findByUsername(String username);

    Comment add(Comment comment);

}
