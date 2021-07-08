package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Iterator;
//import net.sf.json.JSONObject;


@SpringBootTest
public class HashSetDemo {
    @Test
    void test() {
        // TODO 自动生成的方法存根
        HashSet hs = new HashSet();
        Person p1 = new Person("张三","21");
        Person p2 = new Person("李四","21");
        Person p3 = new Person("王五","21");
        Person p4 = new Person("六六","21");
        Person p5 = new Person("六六","21");
        Person p6 = new Person("六六","21");
        hs.add(p1);
        hs.add(p2);
        hs.add(p3);
        hs.add(p4);
        hs.add(p5);
        hs.add(p6);
        System.out.println("==========================================================");
        System.out.println(JSONObject.toJSONString(hs));
    }
}
