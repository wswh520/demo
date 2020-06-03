package com.example.demo.Order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
*@Description
*@Author wanghui
*@Date 2020/6/3
*@Time 21:07
*/
@Component
@Order(0)
public class YellowPersion implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("----YellowPersion----");
    }
}
