package com.harlan.controller;

import com.harlan.domain.Post;
import com.harlan.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/archives")
public class ArchiveController {

    @Autowired
    PostService postService;

    @GetMapping(value = "/")
    public String index(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute(posts);
        return "tag";
    }
}
