package com.itdan.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
// @RestController =@Controller+@RequestBody
//@EnableAutoConfiguration:自动配置启动的作用
//@ComponentScan("com.itdan.controller"):扫包范围
public class DemoController {

    @RequestMapping("/hello")
    public String demo(){
        return "hello word";
    }
}
