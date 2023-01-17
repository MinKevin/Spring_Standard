package com.spring.fastcampus.controller.No28;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;

//ExceptionController2를 ExceptionHandling
@ControllerAdvice("com.spring.fastcampus.controller.No28")
public class GlobalCatcher_2 {
    @ExceptionHandler({Exception.class, FileNotFoundException.class})
    public String catcher(Exception ex, Model m) {
        System.out.println("catcher");
        m.addAttribute("ex", ex);
        return "/No28/error";
    }

    @ExceptionHandler(NullPointerException.class)
    public String catcher2(Exception ex, Model m) {
        System.out.println("catcher2");
        m.addAttribute("ex", ex);
        return "/No28/error";
    }
}
