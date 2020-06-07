package com.example.demo.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
*@Description
*@Author wanghui
*@Date 2020/6/7
*@Time 12:19
*/
@RestController
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("test-set-string")
    public String testSetString(String key, String value) {
        redisUtil.set(key, value,60L);
        return "success set string";
    }

    @RequestMapping("test-get-string")
    public String testGetString(String key) {
        return redisUtil.getString(key);
    }

}
