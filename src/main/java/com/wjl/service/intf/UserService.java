package com.wjl.service.intf;

import com.wjl.entity.User;

import java.util.List;

/**
 * @author: wjl
 * @date: 2021/10/7 15:13
 * @version: v1.0
 */
public interface UserService {

    List<User> findAll();

    List<String> findUsername();

    User findById(Integer id);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    User findByToken(String token);

    User add(User user);

}
