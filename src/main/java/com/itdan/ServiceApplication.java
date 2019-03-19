package com.itdan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* SpringBoot一般把静态资源（js.css.images）都存放在resources的static子文件夹下，
*
* */


@SpringBootApplication
// @SpringBootApplication 等同于@EnableAutoConfiguration+@ComponentScan
//会去扫com.itdan下的所有子包加载注解
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class,args);
    }
}
