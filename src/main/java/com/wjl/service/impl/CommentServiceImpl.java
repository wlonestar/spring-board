package com.wjl.service.impl;

import com.wjl.entity.Comment;
import com.wjl.repository.CommentRepository;
import com.wjl.service.intf.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wjl
 * @date: 2021/10/7 15:17
 * @version: v1.0
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Integer id) {
        return commentRepository.findById(id).orElseThrow();
    }

    @Override
    public Comment findByUsername(String username) {
        return commentRepository.findCommentByUsername(username);
    }

    @Override
    public Comment add(Comment comment) {
        return commentRepository.save(comment);
    }

}
