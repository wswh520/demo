package com.example.demo;

import com.example.demo.User.model.User;
//import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) throws IOException {
//        byte[] pdfFile = new byte[1024];
//        InputStream inputStream = new ByteArrayInputStream(pdfFile);
//        MultipartFile file = new MockMultipartFile("新文件名","原文件名", ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);

//        List<User> list = new ArrayList<>();
//        User user = new User();
//        user.setAge(18);
//        user.setUsername("wangh");
//        list.add(user);
//        User user1 = new User();
//        user1.setAge(20);
//        user1.setUsername("wangh");
//        list.add(user1);
//
//        List<User> studentDistinctList = list.stream()
//                .collect(Collectors.collectingAndThen
//                        (Collectors.toCollection(() ->
//                                        new TreeSet<>(Comparator.comparing(t -> t.getUsername()+";"+t.getAge()))),
//                                ArrayList::new
//                        )
//                );
//        System.out.println(studentDistinctList);
    }
    public static boolean isValidDate(String str) {
        boolean convertSuccess=true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess=false;
        }
        return convertSuccess;
    }
}
