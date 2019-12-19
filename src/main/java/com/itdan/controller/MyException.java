package com.itdan.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义异常处理类
 */
@ControllerAdvice
public class MyException {

    /**
     * 文件上传异常拦截
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public void myException(MaxUploadSizeExceededException e, HttpServletResponse response){
        response.setContentType("test/html:charset=UTF-8");
        try {
            PrintWriter printWriter= response.getWriter();
            printWriter.write("文件太大");
            printWriter.flush();
            printWriter.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
