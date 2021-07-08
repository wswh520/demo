package com.example.demo.calendar;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class CalendarInfoController {

    @Autowired
    private CalendarInfoMapper calendarInfoMapper;

    @RequestMapping("/calendarInfo")
    public void test(){
        Calendar c_begin = new GregorianCalendar();
        Calendar c_end = new GregorianCalendar();
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] weeks = dfs.getWeekdays();
        c_begin.set(2022, 0, 0); // Calendar的月从0-11，所以4月是3.
        c_end.set(2023, 0, 0); // Calendar的月从0-11，所以5月是4.
        int count = 1;
        /*
         * cal1.add(Calendar.DAY_OF_MONTH,1); cal1.add(Calendar.DAY_OF_YEAR,1);
         * cal1.add(Calendar.DATE,1); 就单纯的add操作结果都一样，因为都是将日期+1,区别就是在月的日期中加1还是年的日期中加1
         * 但是Calendar设置DAY_OF_MONTH和DAY_OF_YEAR的目的不是用来+1
         * 将日期加1，这通过cal1.add(Calendar.DATE,1)就可以实现
         * DAY_OF_MONTH的主要作用是cal.get(DAY_OF_MONTH)，用来获得这一天在是这个月的第多少天
         * Calendar.DAY_OF_YEAR的主要作用是cal.get(DAY_OF_YEAR)，用来获得这一天在是这个年的第多少天。
         * DAY_OF_WEEK，用来获得当前日期是一周的第几天
         */
        c_end.add(Calendar.DAY_OF_YEAR, 1); // 结束日期下滚一天是为了包含最后一天
        List<CalendarInfo> entityList = new ArrayList<>();
        while (c_begin.before(c_end)) {
            CalendarInfo c = new CalendarInfo();
            System.out.println("第" + count + "周  日期：" + new java.sql.Date(c_begin.getTime().getTime()) + ","
                    + weeks[c_begin.get(Calendar.DAY_OF_WEEK)]);
            c.setDateInfo(new java.sql.Date(c_begin.getTime().getTime()));
            c.setDayOfWeek(weeks[c_begin.get(Calendar.DAY_OF_WEEK)]);
//            c.setWeekOfYear("第" + count + "周");
            SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
            String httpArg = f.format(c.getDateInfo());
            String jsonResult = Holiday.request(httpArg);
            c.setDateFlag(jsonResult);
            if (c_begin.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                count++;
            }
            c_begin.add(Calendar.DAY_OF_YEAR, 1);
            entityList.add(c);
        }
        calendarInfoMapper.insertList(entityList);
    }


}
