package com.example.demo.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

/**
 *java 事务回滚操作
 *
 **/
@RestController
public class TestTransactionController {

    @Autowired
    private TestTransactionService testTransactionService;

    @RequestMapping("/testsss")
    public void testsss(){
        testTransactionService.test1();
    }


}