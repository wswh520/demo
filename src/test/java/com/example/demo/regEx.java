package com.example.demo;

public class regEx {

    public static void main(String[] args) {
        String regEx="[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
        String str = "${原字符串}";
        String newString = str.replaceAll(regEx,"");//不想保留原来的字符串可以直接写成 “str = str.replaceAll(regEX,aa);”
        System.out.println(newString);
    }
}
