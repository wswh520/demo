package com.example.demo.Order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
*@Description
*@Author wanghui
*@Date 2020/6/3
*@Time 21:05
*/
@Component
@Order(1)
public class BlackPersion implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("----BlackPersion----");
    }
}
