package com.example.demo.download;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/download")
public class fileFownload {

    @RequestMapping("/test")
    public HttpServletResponse download(MultipartFile mf, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
//            File file = new File(path);
            // 取得文件名。
            String filename = mf.getOriginalFilename();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
            Long length = mf.getSize();

            // 以流的形式下载文件。
            InputStream fis = mf.getInputStream();
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + length);
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;

    }
}
