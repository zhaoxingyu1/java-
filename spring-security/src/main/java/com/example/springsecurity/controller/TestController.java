package com.example.springsecurity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxy
 * @Classname TestController
 * @Date 2022/5/14 15:33
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    @PostAuthorize("hasAnyAuthority('admin,user')")
    public String login(){
        System.out.println("@PostAuthorize输出 ");
        return "hello";
    }

    @GetMapping("/index")
    @PreAuthorize("hasAnyAuthority('admin,user')")
    public String index(){

        return "index";
    }

    @GetMapping("/h1")
    @Secured({"ROLE_admin","ROLE_user"})
    public String h1(){
        return "h1";
    }

}
