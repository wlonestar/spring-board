package com.wjl.controller;

import com.wjl.mapper.CommentMapper;
import com.wjl.mapper.UserMapper;
import com.wjl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.UUID;

@Controller
public class RegisterController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/registerUser")
    public String register(User user, Map<String, Object> map) {
        user.setToken(UUID.randomUUID().toString());
        List<String> userList = userMapper.exitUsername();
        if (userList.contains(user.getUsername())) {
            map.put("msg", "用户名[ "+user.getUsername()+" ]"+"已存在, 请重新注册");
            return "/register";
        } else {
            User userCheck = userMapper.findByUsername(user.getUsername());
            if (userCheck == null) {
                userMapper.add(user);
                return "/login";
            } else {
                return "redirect:/homePage";
            }
        }
    }


}
