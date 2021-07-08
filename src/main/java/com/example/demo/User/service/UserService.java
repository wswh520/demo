package com.example.demo.User.service;

import com.example.demo.User.Mapper.UserMapper;
import com.example.demo.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryAll(){
        return userMapper.queryAll();
    }

    public void addUsers(List<User> list){
        userMapper.addUsers(list);
    }

    /**

     * 查询指定目录中电子表格中所有的数据
     * @param file
     * 文件完整路径
     * @return
     */
    public String  readExcelFile(MultipartFile file) {
        String result ="";
        //创建处理EXCEL的类
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取上传的事件单
        List<User> useList = readExcel.getExcelInfo(file);
        //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
        //和你具体业务有关,这里不做具体的示范
        if(useList != null && !useList.isEmpty()){
            result = "success";
        }else{
            result = "error";
        }
        return result;
    }


}
