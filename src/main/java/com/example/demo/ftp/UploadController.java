package com.example.demo.ftp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jlm on 2019-09-17 17:42
 */
@RestController
public class UploadController {

    private static String ip = "47.111.251.239";
    private static String user = "root";
    private static String password = "1qaz@WSXWH";
    private static int port = 22;
    private static String path = "/opt/whtest";

    @RequestMapping("file")
    public void upload(HttpServletRequest httpServletRequest, MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();
        FtpUtils.sshSftp(bytes,"1111.jpg",ip,user,password,port,path);

    }

}
