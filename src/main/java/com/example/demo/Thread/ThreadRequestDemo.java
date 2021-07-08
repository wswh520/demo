package com.example.demo.Thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Future;

@RestController
@Slf4j
public class ThreadRequestDemo {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public String taskExecute() {
        //将RequestAttributes对象设置为子线程共享,在调用线程或线程池之前设置
//        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        RequestContextHolder.setRequestAttributes(sra, true);
//        HttpServletRequest request = sra.getRequest();
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        String token = request.getHeader("token");
        log.info("==========={}",token);
        log.info("===========当前线程为 {}",Thread.currentThread().getName());
        try {
            new Thread(new Runnable(){
                @SneakyThrows
                public void run() {
                    log.info("当前线程为 {}",Thread.currentThread().getName());
                    Thread.sleep(1000);                 //1000 毫秒，也就是bai1秒.
                    Future<String> r1 = taskService.doTaskOne();
                    Future<String> r2 = taskService.doTaskTwo();
                    Future<String> r3 = taskService.doTaskThree();
                    while (true) {
                        if (r1.isDone() && r2.isDone() && r3.isDone()) {
                            log.info("execute all tasks");
                            break;
                        }
                        Thread.sleep(200);
                    }
                    log.info("\n" + r1.get() + "\n" + r2.get() + "\n" + r3.get());
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error executing task for {}", e.getMessage());
        }
        return "ok";
    }

}
