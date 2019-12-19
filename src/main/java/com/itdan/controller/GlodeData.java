package com.itdan.controller;

import com.itdan.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * 定义全局数据
 */
@ControllerAdvice
public class GlodeData {

    /**
     * 在所有controller层中都可以获取到以下的数据
     * @return
     */
    @ModelAttribute("/info")
    public Map<String ,Object> getGlodeData(){
        HashMap<String ,Object> map=new HashMap<>();
        map.put("name","xiaoming");
        map.put("user",new User());
        map.put("user_token",UUID.randomUUID().toString());
        return map;
    }

    /**
     * 获取全局数据
     * @param model
     * @return
     */
    @GetMapping("/getdata")
    public String getData(Model model){
       Map<String ,Object> map=model.asMap();
       Set<String > keys= map.keySet();
       for (String s:keys){
           System.out.println(s);
       }
     return "index.html";
    }

}
