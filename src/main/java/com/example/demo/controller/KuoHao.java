package com.example.demo.controller;

import java.util.ArrayList;

public class KuoHao {
    public static void addParen(ArrayList<String> list,int leftRem,int rightRem,char[] str,int count){
        if(leftRem<0||leftRem>rightRem)
            return;
        if(leftRem==0&&rightRem==0){
            String s=String.valueOf(str);
            list.add(s);
        }else{
            if(leftRem>0){
                str[count]='(';
                addParen(list, leftRem-1, rightRem, str, count+1);
            }
            if(rightRem>leftRem){
                str[count]=')';
                addParen(list, leftRem, rightRem-1, str, count+1);
            }
        }
    }
    public static ArrayList<String>generateParens(int count){
        char[] str=new char[count*2];
        ArrayList<String>list=new ArrayList<>();
        addParen(list, count,count, str, 0);
        return list;
    }
    public static void main(String[] args) {
        ArrayList<String>list=generateParens(2);
        for(String i:list)
            System.out.println(i);
    }
}
