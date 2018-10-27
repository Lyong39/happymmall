package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;


public interface IFileService {
    //图片、富文本上传
    String upload(MultipartFile file, String path);
}
