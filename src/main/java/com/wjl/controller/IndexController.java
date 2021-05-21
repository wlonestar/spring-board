package com.wjl.controller;

import com.wjl.mapper.CommentMapper;
import com.wjl.mapper.UserMapper;
import com.wjl.model.Comment;
import com.wjl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Random;

import static org.ictclas4j.utility.GFCommon.random;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommentMapper commentMapper;

    @ModelAttribute
    Comment setComment() {
        return new Comment();
    }

    @GetMapping("/homePage")
    public String index(Model model) {
        Comment comment = new Comment();
        model.addAttribute("list", commentMapper.showAllComment());
        return "index";
    }

    @PostMapping("/homePage")
    public String listCommentByName(Model model) {
        model.addAttribute("list", commentMapper.showAllComment());
        return "index";
    }

    @GetMapping("/update")
    public String toUpdate(Model model) {
        Comment comment = new Comment();
        model.addAttribute("comment", comment);
        return "index";
    }

    @PostMapping("/add")
    public String addComment(Comment comment, HttpServletRequest request, RedirectAttributes attributes) {
        // 通过 token 获取用户名
        User user = new User();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                user = userMapper.findByToken(token);
                break;
            }
        }

        comment.setUsername(user.getUsername());
        Date date = new Date(System.currentTimeMillis());
        comment.setTime(date);
        String[] url = {"/image/90.png",
                "/image/91.png",
                "/image/92.png",
                "/image/93.png",
                "/image/94.png",
                "/image/95.png",
                "/image/96.png",
                "/image/97.png",
                "/image/98.png"};
//        comment.setPhoto(url[random(0,8)]);
        comment.setPhoto(url[1]);
        commentMapper.addComment(comment);
        return "redirect:/homePage#comment";

    }

}
