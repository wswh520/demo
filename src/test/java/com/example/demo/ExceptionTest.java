package com.example.demo;

public class ExceptionTest {

    public static void main(String[] args) {
        //代码2
        try{
            throw new Exception("参数越界");
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("异常后");//可以执行
    }
}
