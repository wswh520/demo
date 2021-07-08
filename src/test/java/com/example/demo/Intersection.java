package com.example.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {

    /**
     * 测试简单交集
     */
    public static void main(String[] args) {
        String str1 = "a,b,c";
        String[] arr1 = str1.split(",");
        List<String> list1 = Arrays.asList(arr1);
        Set<String> set1 = new HashSet<>();
        for(String value : list1){
            set1.add(value);
        }

        String str2 = "c,d,e";
        String[] arr2 = str2.split(",");
        List<String> list2 = Arrays.asList(arr2);
        Set<String> set2 = new HashSet<>();
        for(String value:list2){
            set2.add(value);
        }


        //交集
//        set1.retainAll(set2);
        set1.removeAll(set2);
        System.out.println("交集是 " + set1);  //交集是 [c]
        System.out.println(Arrays.asList(set1.toString()));
    }
}
