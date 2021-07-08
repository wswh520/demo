package com.example.demo.Transaction;

import com.example.demo.User.Mapper.UserMapper;
import com.example.demo.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestTransactionService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void test1(){
        test2();
        if(1/0==1){

        }
    }

    public void test2(){
        List<User> list = new ArrayList<>();
        User user = new User();
        list.add(user);
        userMapper.addUsers(list);

    }
}
