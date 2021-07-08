package com.example.demo.ftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.*;

import java.io.*;

/**
 * Created by jlm on 2019-09-17 17:44
 */
public class FtpUtils {

    /**
     * 利用JSch包实现SFTP上传文件
     * @param bytes 文件字节流
     * @param fileName 文件名
     * @param ip 服务器ip地址
     * @param user 用户名
     * @param password 密码
     * @param port 服务器端口 默认22
     * @param path 上传文件到指定服务器的指定目录
     * @throws Exception
     */
    public static void sshSftp(byte[] bytes,String fileName,String ip,String user,
                               String password,int port,String path) throws Exception{
        Channel channel = null;
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, ip ,port);
        //如果服务器连接不上，则抛出异常
        if (session == null) {
            throw new Exception("session is null");
        }
        //设置登陆主机的密码
        session.setPassword(password);//设置密码
        //设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.setConfig("StrictHostKeyChecking", "no");
        //设置登陆超时时间
        session.connect(30000);
        OutputStream outstream = null;
        try {
            //创建sftp通信通道
            channel = (Channel) session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;
            //进入服务器指定的文件夹
            sftp.cd(path);
            //列出服务器指定的文件列表
            //以下代码实现从本地上传一个文件到服务器，如果要实现下载，对换以下流就可以了
            outstream = sftp.put(fileName);
            outstream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关流操作
            if(outstream != null){
                outstream.flush();
                outstream.close();
            }
            if(session != null){
                session.disconnect();
            }
            if(channel != null){
                channel.disconnect();
            }
        }
    }

}