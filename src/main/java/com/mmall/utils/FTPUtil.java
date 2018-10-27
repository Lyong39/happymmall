package com.mmall.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class FTPUtil {

    private static final Logger logger = LoggerFactory.getLogger(FTPUtil.class);

    private static String ftpIp = PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser = PropertiesUtil.getProperty("ftp.user");
    private static String ftpPass = PropertiesUtil.getProperty("ftp.pass");

    public FTPUtil(String ip, int port, String user, String pwd) {
        this.ip = ip;
        //端口(用户)
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }

    //暴露出来的上传文件方法(其实就是把逻辑方法私有只是提供出来接口)
    public static Boolean uploadFile(List<File> fileList) throws IOException {
        //固定端口21
        FTPUtil ftpUtil = new FTPUtil(ftpIp, 21, ftpUser, ftpPass);
        logger.info("开始连接ftp服务器");
        //remotePath这里已经写死了 "img"
        Boolean result =ftpUtil.uploadFile("img", fileList);
        logger.info("开始连接ftp服务器,结束上传,上传结果:{}");
        return result;
    }

    //私有的上传文件方法  远程文件路径remotePath
    private Boolean uploadFile(String remotePath, List<File> fileList) throws IOException {
        boolean uploaded = true;
        FileInputStream fis = null;
        //连接FTP服务器
        if (connectServer(this.ip, this.port, this.user, this.pwd)) {
            try {
                //更改工作目录,(需不需要切换文件夹，如果传空参数不切换 即切换不了)
                ftpClient.changeWorkingDirectory(remotePath);
                //设置缓冲区
                ftpClient.setBufferSize(1024);
                //设置encoding为UTF-8
                ftpClient.setControlEncoding("UTF-8");
                //文件类型设置成二进制类型防止乱码问题
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //打开本地的被动模式
                ftpClient.enterLocalPassiveMode();
                //传文件
                for (File fileItem : fileList) {
                    fis = new FileInputStream(fileItem);
                    //存储文件
                    ftpClient.storeFile(fileItem.getName(),fis);
                }
            } catch (IOException e) {
                logger.error("上传文件异常", e);
                uploaded = false;
                e.printStackTrace();
            }finally {
                //释放连接
                ftpClient.disconnect();
                fis.close();
            }
        }
        return uploaded;

    }
    //私有的连接ftp服务器的方法
    private Boolean connectServer(String ip, int port, String user, String pwd) {
        Boolean isSuccess = false;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess = ftpClient.login(user, pwd);
        } catch (IOException e) {
            logger.error("连接FTP服务器异常", e);
        }
        return isSuccess;
    }


    private String ip;
    private int port;       //端口(用户)
    private String user;
    private String pwd;
    private FTPClient ftpClient;    //ftp服务器

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }
}
