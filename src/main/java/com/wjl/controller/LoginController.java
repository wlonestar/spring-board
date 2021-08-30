package com.wjl.controller;

import com.wjl.mapper.UserMapper;
import com.wjl.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index() {
        return "/login";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        return "/login";
    }

    @PostMapping("/loginUser")
    public String login(
            @Param("username") String username, @Param("password") String password,
            HttpServletResponse response, Map<String, Object> map) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User check_login = userMapper.findByUsername_login(username, password);

        if (check_login != null) {
            User user_token = userMapper.username_to_setToken(username);
            String token = user_token.getToken();
            response.addCookie(new Cookie("token", token));
            return "redirect:/homePage";
        } else {
            map.put("msg", "用户名或密码错误，请重新登录");
            return "/login";
        }

    }

}
