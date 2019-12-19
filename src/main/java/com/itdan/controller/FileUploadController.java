package com.itdan.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

    /**
     * 文件上传功能
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload-file")
    public String uploadFile(MultipartFile file, HttpServletRequest request){

        //获取当前时间
        String format= simpleDateFormat.format(new Date());
        //获取当前路径
        String realPath=request.getServletContext().getRealPath("/img")+format;
        File file1=new File(realPath);
        if(!file1.exists()){
            //如果文件夹不存在，就创建一个
            file1.mkdirs();
        }
         //获取传入的文件名
         String oldName= file.getOriginalFilename();
         //生成新的文件名
        String newName= UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
        try {
            //讲文件存储到新的文件夹
             file.transferTo(new File(file1,newName));
             String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/img/"+format+newName;
              return url;
        }catch (IOException e){
            e.printStackTrace();
        }
         return "error";
    }


    /**
     * 上传多个文件
     * @param files
     * @param request
     * @return
     */
    @PostMapping("/upload-files")
    public String uploadFiles(MultipartFile[] files, HttpServletRequest request){

        //获取当前时间
        String format= simpleDateFormat.format(new Date());
        //获取当前路径
        String realPath=request.getServletContext().getRealPath("/img")+format;
        File file1=new File(realPath);
        if(!file1.exists()){
            //如果文件夹不存在，就创建一个
            file1.mkdirs();
        }
        //获取传入的文件名
        for (MultipartFile file:files){
        String oldName= file.getOriginalFilename();
        //生成新的文件名
        String newName= UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
        try {
            //讲文件存储到新的文件夹
            file.transferTo(new File(file1, newName));
            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/" + format + newName;
            System.out.println(url);
        }catch (IOException e){
            e.printStackTrace();
        }
        }
        return "success";
    }
}
