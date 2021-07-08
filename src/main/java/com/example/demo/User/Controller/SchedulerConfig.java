package com.example.demo.User.Controller;

import com.example.demo.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Configuration
public class SchedulerConfig {

    @Autowired
    private UserService userService;
    private Integer scheduTag = 0;

    @PostConstruct
    public void configureTasks() {
//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//        // 参数：1、任务体 2、首次执行的延时时间
//        //      3、任务执行间隔 4、间隔时间单位
//        service.scheduleAtFixedRate(
//                ()->scheduTest(),
//                0, fingTime(), TimeUnit.SECONDS
//        );
    }

    /**
     * 获取间隔时间
     * @return
     */
//    public long fingTime(){
//        return userService.queryAll().get(0).getAge();
//    }

    /**
     * 处理任务
     */
    public void scheduTest(){
        if(scheduTag != 0){
            System.out.println(userService.queryAll());
        }else{
            scheduTag = 1;
        }

    }

}
