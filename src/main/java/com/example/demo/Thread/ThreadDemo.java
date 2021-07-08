package com.example.demo.Thread;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootTest
//@RunWith(SpringRunner.class)
@RestController
public class ThreadDemo {

    public static void main(String[] args) {
//        testThread();
//        runTesy();
    }

//    @Test
    public static void testThread(){
        Thread thread = new Thread(){
            public void run(){
                System.out.println("Thread Running");
            }
        };
        thread.start();
    }

    @RequestMapping("runTesy")
    public String runTesy(){
        Runnable myRunnable = new Runnable(){
            @SneakyThrows
            public void run(){
                System.out.println("Runnable running");
                Thread.sleep(2000);
                System.out.println("Runnable running==================");
            }
        };
        Thread thread = new Thread(myRunnable);
        thread.start();
        return "ok";
    }


}
