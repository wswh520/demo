package com.example.demo.User.Controller;

import com.example.demo.User.model.User;
import com.example.demo.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("queryAll")
    public List<User> queryAll(){
        return userService.queryAll();
    }
}
