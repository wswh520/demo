package com.example.demo.Aspect;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @RequestMapping("/doNormal")
    public String doNormal(String name, String age) {
        log.info("【执行方法】：doNormal");
        return "doNormal";
    }

    @RequestMapping("/doWithException")
    public String doWithException(String name, String age) {
        log.info("【执行方法】：doWithException");
        int a = 1 / 0;
        return "doWithException";
    }

}
