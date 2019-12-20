package com.itdan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * session共享
 */
@RestController
@ConfigurationProperties("classpath:application.properties")
public class SessionController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/setsession")
    public String set(HttpSession session){
        session.setAttribute("name-session","bbb");
        return port.toString();
    }

    @RequestMapping("/getsession")
    public String get(HttpSession session){
         String name=(String) session.getAttribute("name-session");
          return port+name;
    }


}
