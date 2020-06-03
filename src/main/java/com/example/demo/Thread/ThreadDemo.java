package com.example.demo.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ThreadDemo {

    static CountDownLatch cdl;//这里的数字，开启几个线程就写几
    /**
     * 实现等待所有子线程结束后再执行一段代码
     * @param list
     * @throws InterruptedException
     */
    public void counter (List list) throws InterruptedException {
        cdl = new CountDownLatch(list.size());
        new Thread(new Runnable(){
            public void run() {
                // TODO Auto-generated method stub
                cdl.countDown();
            }
        }).start();
        cdl.await();//主线程等待子线程执行输出
    }

}
