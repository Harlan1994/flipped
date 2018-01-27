package com.harlan.controller;

import com.harlan.domain.Post;
import com.harlan.service.PostService;
import com.harlan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

/**
 * Created by Harlan1994 on 2017/11/21.
 */
@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    HttpSession httpSession;

    @Autowired
    PostService postService;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        Page<Post> posts = postService.getPosts(0, 10);
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping(value = "/posts/page/{page}")
    public String page(Model model, @PathVariable Integer page) {
        Page<Post> posts = postService.getPosts(page, 10);
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping(value = "/post/{id}")
    public String post(Model model, @PathVariable Long id) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    /**
     * 登出
     *
     * @return
     */
    @GetMapping(value = "/logout")
    public String logout() {
        httpSession.removeAttribute("user");
        return "login";
    }

    /**
     * 登陆失败重新
     *
     * @return
     */
    @GetMapping(value = "/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
