package com.wjl.repository;

import com.wjl.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: wjl
 * @date: 2021/10/7 15:12
 * @version: v1.0
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Comment findCommentByUsername(String username);

}
