package com.example.demo.calendar;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Holiday {

    public static String request(String httpArg) {
        String url = "https://tool.bitefu.net/jiari/?d=" + httpArg;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> res = restTemplate.getForEntity(url, Integer.class);
        String body = String.valueOf(res.getBody());
        try {
            Thread.sleep(500);
            if ("0".equals(body)) {
                body = "0";
            } else {
                body = "1";
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return body;
    }
}
