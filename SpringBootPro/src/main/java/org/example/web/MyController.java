package org.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

//@Controller
@RestController//如果使用这个下面就不需要写 @ResponseBody 响应服务器
public class MyController {

    //使用注解的方式把配置注入进来
    @Autowired
    private DataSource dataSource;

    @RequestMapping("/hello")//设置路径
//    @ResponseBody//响应浏览器
    public String hello(){
        System.out.println(dataSource);
        return "hello SpringBoot";
    }
}
