package com.wjl.controller;

import com.wjl.entity.User;
import com.wjl.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/registerUser")
    public String register(User user, Map<String, Object> map) {
        user.setToken(UUID.randomUUID().toString());
        List<String> userList = userService.findUsername();
        if (userList.contains(user.getUsername())) {
            map.put("msg", "用户名[ "+user.getUsername()+" ]"+"已存在, 请重新注册");
            return "/register";
        } else {
            User userCheck = userService.findByUsername(user.getUsername());
            if (userCheck == null) {
                userService.add(user);
                return "/login";
            } else {
                return "redirect:/homePage";
            }
        }
    }

}
