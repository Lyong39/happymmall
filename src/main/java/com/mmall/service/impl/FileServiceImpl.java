package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.utils.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Lwei on 2018/9/21.
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    //上传文件，返回值为上传文件的文件名
    public String upload(MultipartFile file, String path) {
        //获取文件的原始文件名
        String filename = file.getOriginalFilename();
        //拿到文件的扩展名，abc.jpg  上传的文件的名字通过拼接随机数设置新的上传名字(为避免AB两个人传相同的文件名而覆盖掉)
        String fileExtensionName = filename.substring(filename.lastIndexOf(".") + 1);
        //为保证上传的文件名都不一样采用UUID随机数加入前缀命名文件名
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名{},上传的路径{},新文件名{}", filename, path, uploadFileName);
        //这个是通过文件绝对路径获得相应文件夹
        File fileDir = new File(path);
        //判断文件夹是否存在 (.exists()方法),不存在就创建文件夹
        if (!fileDir.exists()) {
            //赋予文件夹可写入的权限
            fileDir.setWritable(true);
            //mkdirs()可以建立多级文件夹
            fileDir.mkdirs();
        }
        //创建文件夹下的新的文件(把文件扔到绝对路径path里)
        File targetFile = new File(path, uploadFileName);
        try {
            //下面这个操作后文件上传成功(即开始文件上传)
            file.transferTo(targetFile);
            //把文件上传到ftp服务器上
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //上传完后,删除upload下面的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常", e);
        }
        return targetFile.getName();
    }
}
