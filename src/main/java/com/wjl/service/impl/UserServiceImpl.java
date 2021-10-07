package com.wjl.service.impl;

import com.wjl.entity.User;
import com.wjl.repository.UserRepository;
import com.wjl.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wjl
 * @date: 2021/10/7 15:14
 * @version: v1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<String> findUsername() {
        List<String> usernames = new ArrayList<>();
        List<User> users = findAll();
        for (User user : users) {
            usernames.add(user.getUsername());
        }
        return usernames;
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findUserByUsernameAndPassword(username, password);
    }

    @Override
    public User findByToken(String token) {
        return userRepository.findUserByToken(token);
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

}
