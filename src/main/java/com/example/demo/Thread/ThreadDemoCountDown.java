package com.example.demo.Thread;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
@RestController
@RequestMapping
public class ThreadDemoCountDown {

    static CountDownLatch cdl;//这里的数字，开启几个线程就写几


    /**
     * 实现等待所有子线程结束后再执行一段代码
     * @throws InterruptedException
     */
    @RequestMapping("threadDemo/test")
    public static void counter() throws InterruptedException {
        // 将RequestAttributes对象设置为子线程共享
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        RequestContextHolder.setRequestAttributes(sra, true);

        String token = getCurrentRequestInfo().getHeader("token");
        System.out.println(token);
        cdl = new CountDownLatch(1);
        new Thread(new Runnable(){
            @SneakyThrows
            public void run() {
                Thread.sleep(1000);                 //1000 毫秒，也就是bai1秒.
                String token1 = getCurrentRequestInfo().getHeader("token");
                System.out.println(token1);
                // TODO Auto-generated method stub
                cdl.countDown();
            }
        }).start();
        cdl.await();//主线程等待子线程执行输出
    }

    public static HttpServletRequest getCurrentRequestInfo() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes.getRequest();
    }
}
