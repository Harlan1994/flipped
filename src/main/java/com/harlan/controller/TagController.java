package com.harlan.controller;

import com.harlan.domain.Tag;
import com.harlan.domain.TagRepository;
import com.harlan.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/tags")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping(value = "/")
    public String index(Model model) {
        List<Tag> tags = tagService.getAllTags();
        model.addAttribute(tags);
        return "tag";
    }
}
