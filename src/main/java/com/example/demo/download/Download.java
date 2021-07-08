package com.example.demo.download;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 生成指定文件并下载
 */
@RestController
public class Download {

    @RequestMapping("/download")
    public void download(String filename) throws UnsupportedEncodingException {
        HttpServletResponse response = getResponse();
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String((filename).getBytes(), "iso-8859-1"));
        try {
            OutputStreamWriter write = new OutputStreamWriter(response.getOutputStream(), "utf-8");
            BufferedWriter writer = new BufferedWriter(write);
            StringBuilder sql = new StringBuilder();
            sql.append("HELLO WORLD!");
            writer.write(sql + "\r\n");
            writer.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public HttpServletRequest getRequest(){
        return ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
    }
    public HttpServletResponse getResponse(){
        return ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getResponse();
    }
    @RequestMapping("/multipartFileName")
    public String  upload(String name){
//        MultipartFile file = new MultipartFile();
        return null;
    }
}
