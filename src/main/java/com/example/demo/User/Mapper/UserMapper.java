package com.example.demo.User.Mapper;

import com.example.demo.User.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> queryAll();

}
