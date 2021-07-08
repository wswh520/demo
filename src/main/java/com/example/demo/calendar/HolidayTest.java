package com.example.demo.calendar;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;

import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import java.util.Map;

public class HolidayTest {

    public static int testHolidayGet(String time) {
        String url = "https://tool.bitefu.net/jiari/?d=" + time;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> res = restTemplate.getForEntity(url, Integer.class);
        return res.getBody();
    }

    public static void main(String[] args) {
        String time = "20210324";
        int body = testHolidayGet(time);
        System.out.println(body);
    }

}
