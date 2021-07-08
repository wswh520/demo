package com.example.demo.User.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.FastJson.TestUser;
import com.example.demo.User.model.FormDataUser;
import com.example.demo.User.model.User;
import com.example.demo.User.model.UserVo;
import com.example.demo.User.service.ImportExcel;
import com.example.demo.User.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("queryAll")
    public List<User> queryAll(){
        return userService.queryAll();
    }

    @RequestMapping(value="upload")
    @ResponseBody
    public String  upload(MultipartFile file){
        try {
             String fileName = file.getOriginalFilename();
             // 获取上传文件的输入流
             InputStream inputStream = file.getInputStream();
             // 调用工具类中方法，读取excel文件中数据
             List<Map<String, Object>> sourceList = ImportExcel.readExcel(fileName, inputStream);
             // 将对象先转为json格式字符串，然后再转为List<SysUser> 对象
             ObjectMapper objMapper = new ObjectMapper();
             String infos = objMapper.writeValueAsString(sourceList);
             // json字符串转对象
             List<User> list = objMapper.readValue(infos, new TypeReference<List<User>>() {});
             // 批量添加
             userService.addUsers(list);
             return "success";
         } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
             return e.getMessage();
         }
    }

    /**
     * FormData接收数组（实体）
     * @param user
     * @return
     */
    @RequestMapping("/formDataModel")
    public String formDataModel(@RequestBody User user){
        System.out.println("111111=====================11111111");
        List<User> list = new ArrayList<>();
        list.add(user);
        userService.addUsers(list);
        return "OK";
    }

    /**
     * FormData接收数组（实体+文件）
     * @param user
     * @return
     */
    @RequestMapping("/formDataModelAndFile")
    public String formDataModelAndFile(User user){
        System.out.println("111111=====================11111111");
        return "OK";
    }

    /**
     * FormData接收数组（数组中实体包含文件）
     * @param request
     * @param userForm
     * @return
     */
    @RequestMapping("/FormDataUser")
    public String testFormData(HttpServletRequest request,@ModelAttribute("userForm") UserVo userForm){
        System.out.println("111111=====================11111111");
        return "OK";
    }

    /**
     * JSON数组接收参数
     * @param list
     */
    @RequestMapping("testJson")
    public void testFast(@RequestBody List<User> list){
        System.out.println("===================");
    }

}
