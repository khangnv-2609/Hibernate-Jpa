package com.example.selfgeneratedtextid.controller;

import com.example.selfgeneratedtextid.entity.User;
import com.example.selfgeneratedtextid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService ;
    @PostMapping("add")
    public User addU(@RequestBody User user){
        return userService.addUser(user);
    }
}
