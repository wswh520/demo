package com.example.demo.FastJson;

import com.example.demo.User.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastJsonDemo {

    @RequestMapping("testFast")
    public void testFast(@RequestBody TestUser user){
        System.out.println("===================");
    }
}
