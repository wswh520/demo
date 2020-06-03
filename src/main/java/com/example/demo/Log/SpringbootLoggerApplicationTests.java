package com.example.demo.Log;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 王慧
 * @description 日志测试
 * @date 2020/1/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootLoggerApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void logger() {
        log.info("=====>>>>> logger()");
    }

}
