package com.zwy.sdj.controller;

import com.zwy.sdj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("save")
    public String save() {
        userService.save();
        return "save end";
    }
}
