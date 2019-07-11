package com.pinyougou.shop.controller;

import com.sun.org.apache.xpath.internal.SourceTree;
import entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import util.FastDFSClient;


@RestController
public class UploadController {

    @Value("${FILE_SERVER_URL}")
    private String file_server_url;


    @RequestMapping("/upload.do")
    public Result upload(MultipartFile file){
        //获取图片名称
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf("." )+ 1);
        //文件上传
        System.out.println(file_server_url);
        try {
            //读取配置文件信息,获取ip
            util.FastDFSClient client=new FastDFSClient("classpath:config/fdfs_client.conf");
            String path = client.uploadFile(file.getBytes(), extName);
            String url = file_server_url + path;
            return new Result(true,url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }
    }

}
