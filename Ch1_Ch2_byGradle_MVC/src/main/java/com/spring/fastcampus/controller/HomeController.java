package com.spring.fastcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(){
        return "home"; // 응답으로 /WEB-INF/views/home.jsp 를 보냄
    }
}