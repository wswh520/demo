package com.example.demo.Redis;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("testFile")
    public void testFile(MultipartFile mf){
        byte[] bytes = ByteUtil.object2Bytes(mf);
        Map<String,Object> map = new HashMap<>();
//        String base64File = Base64.encodeBase64String(bytes);
        String key = "file:wh";
        map.put("filename","wwww");
        map.put("content",bytes);
//        if (StringUtils.isNotEmpty(base64File)) {
            redisUtil.set(key,map);
//        }
//        return "ok";
    }

    @RequestMapping("getFile")
    public String getFile() throws FileNotFoundException {
//        byte[] byteKey = SerializationUtils.serialize("file:wh");
//        Object  file = redisUtil.get("file:wh");
        File file = new File("");
        BufferedReader br = new BufferedReader(new FileReader(file));

//        byte[] buffer = Base64.decodeBase64(file);
        return JSONObject.toJSONString((Map<String,Object>)file);
    }

}
