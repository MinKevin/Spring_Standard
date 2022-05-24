package com.spring.fastcampus.controller.No19;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


public class RegisterController {
    @RequestMapping("/register/add")
    public String register(){
        return "/No19/registerForm";
    }

    @RequestMapping("/register/save")
    public String save(){
        return "/No19/registerInfo";
    }
}
