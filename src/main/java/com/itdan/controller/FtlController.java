package com.itdan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 *默认会去找resources下的templates子文件夹下的.ftl格式的文件
 */
@Controller
public class FtlController {

    @RequestMapping("/ftlIndex")
    public  String ftlIndex(Map<String,Object> map){
        //向ftl文件传递参数
        map.put("name","小明");
        map.put("age","18");
        map.put("sex","0");
        map.put("addr","王府井");
      return "ftlIndex";
    }
}
