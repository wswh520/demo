package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTest {

//    public static void main(String[] args) {
//        // 当前日期
//
//        // 当月的【次月需求征集截止日期】
//
//    }
//    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(2);
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Integer integer = iterator.next()
//            if (integer == 2)
//                list.remove(integer);
//        }
//    }

//    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date startTime = df.parse(testTime("yyyy-MM-dd ") + testTime("HH:mm:ss"));
//        System.out.println(df.format(startTime));
//    }
//
//    public static String testTime(String str){
//        Date now = new Date();
//        SimpleDateFormat ds = new SimpleDateFormat(str);
//        return ds.format(now);
//    }

//    public static void main(String[] args) {
//        String str = "sdf    sdjf`        " +
//                "";
//        String regx =  "\\s*|\t|\r|\n";
//        System.out.println(str.replaceAll(regx,""));
//    }

    public static void main(String[] args)
            throws ParseException
    {
        SimpleDateFormat sj = new SimpleDateFormat("yyyy-MM-dd");
        String today = "2015-11-30";
        Date d = sj.parse(today);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, 1);
        System.out.println("明天：" +      sj.format(calendar.getTime()));
        //此时日期变为2015-12-01 ，所以下面的-2，
        //理论上讲应该是2015-11-29
        calendar.add(calendar.DATE, -2);
        System.out.println("前天：" + sj.format(calendar.getTime()));
    }
}

