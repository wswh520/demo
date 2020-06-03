package com.example.demo.IllegalArgument;
/**
*@Description
*@Author wanghui
*@Date 2020/6/3
*@Time 20:11
*/
public class IllegalArgument {

    public static void main(String[] args) {
        String text = "123456";
        String replacement = "two$two";
        replacement = replacement.replaceAll("\\$", "RDS_CHAR_DOLLAR");// encode replacement;
        String resultString = text.replaceAll("2", replacement);
        resultString = resultString.replaceAll("RDS_CHAR_DOLLAR", "\\$");// decode replacement;
        System.out.println(resultString);
    }
}
