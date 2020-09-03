package com.lujieni.vue.controller;

import com.lujieni.vue.bean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther lujieni
 * @Date 2020/6/16
 */
@RestController
public class HelloController {

    /**
     * get请求也可以用对象接!!! 这里的对象就是Person
     * @param request
     * @param person
     * @param name
     * @return
     */
    @GetMapping("/hello")
    public String hello(HttpServletRequest request,HttpServletResponse response,Person person,String name){
        System.out.println(request.getHeader("token"));
        Cookie cookie = new Cookie("inner-token","lujieni");
        /*
            cookie.setDomain("lujieni.com");
            setDomain有效的前提是请求request的域名是以.lujieni.com结尾的
            如http://hello.lujieni.com不设置domain的话默认会存储到
            hello.lujieni.com;设置domain的话,cookie存储到lujieni.com站点下
         */
        cookie.setPath("/");
        response.addCookie(cookie);
        System.out.println(person);
        return "hello lujieni";
    }

    @PostMapping("/bye")
    public String bye( @RequestBody Person person,HttpServletRequest request){
        String token = request.getHeader("token");
        System.out.println(token);
        System.out.println(person);
        return "bye lujieni";
    }

    /**
     * 导出数据
     * post提交的数据不一定都要用@RequestBody接受,除非它是以json格式提交的!!!
     * @param name
     * @param age
     */
    @PostMapping("/export")
    public void bye(String name,Integer age){
        System.out.println(name);
        System.out.println(age);
    }
}
