package com.spring.fastcampus.controller.No27;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;

//ExceptionController2를 ExceptionHandling
@ControllerAdvice("com.spring.fastcampus.controller.No27")
public class GlobalCatcher {
    @ExceptionHandler({Exception.class, FileNotFoundException.class})
    public String catcher(Exception ex, Model m) {
        m.addAttribute("ex", ex);
        return "/No27/error";
    }

    @ExceptionHandler(NullPointerException.class)
    public String catcher2(Exception ex, Model m) {
        m.addAttribute("ex", ex);
        return "/No27/error";
    }
}
