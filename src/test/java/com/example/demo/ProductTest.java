package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ProductTest {

    public static void main(String[] args) {
        getDate("2020-03-02");
//        System.out.println(getWeekOfDate("2020-10-25"));
    }

    /**
     * 传参池
     * @return
     */
    public static List getParmPoll(){
        int[] arr = {2, 5};
        List<Integer> listPoll = Arrays.stream(arr).boxed().collect(Collectors.toList());
        //数组排序
        Collections.sort(listPoll);
        return listPoll;
    }

    /**
     * 根据周几获取上一个投产日期
     * @param dayOfweek 投产日期
     * @return
     */
    public static String getDate(String dayOfweek){
        System.out.println("投产日期："+dayOfweek);
        //投产日期中的周几
        String prodDate = getWeekOfDate(dayOfweek);
        System.out.println("投产日期中的周几："+prodDate);
        //传参日期池
        List<Integer> parmPoll = getParmPoll();
        System.out.println("传参日期池:"+parmPoll);

        Integer proI = getNumberThree(parmPoll,Integer.parseInt(prodDate));
//        Integer proI = Search1(parmPoll, Integer.parseInt(prodDate));
        System.out.println("在传参池中日期:"+proI);

        return prodDate;
    }

    /**
     * 根据日期 找到对应日期的 星期
     */
    public static String getDayOfWeekByDate(String date) {
        String dayOfweek = "-1";
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = myFormatter.parse(date);
            SimpleDateFormat formatter = new SimpleDateFormat("E");
            String str = formatter.format(myDate);
            dayOfweek = str;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dayOfweek;
    }

    /**
     * 获取当前日期是星期几<br>
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(String paramDate) {
        String[] weekDays = null;
        int w = 0;
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = myFormatter.parse(paramDate);
            weekDays = new String[]{"7", "1", "2", "3", "4", "5", "6"};
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return weekDays[w];
    }


    public static Integer getNumberThree(List<Integer> intarray,Integer number){
        int index = Math.abs(number-intarray.get(0));
        int result = intarray.get(0);
        for (int i : intarray) {
            int abs = Math.abs(number-i);
            if(abs <= index){
                index = abs;
                result = i;
            }
        }
        return result;
    }
}
