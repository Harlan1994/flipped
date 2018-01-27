package com.harlan.controller;

import com.harlan.domain.User;
import com.harlan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.findById(userId);
    }
}
