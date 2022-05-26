package com.spring.fastcampus.controller.No27;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

//ExceptionHander는 Controller내부에서만 사용 가능
@Controller
public class ExceptionController {

    //class 내부에서 Exception이 발생하면 @ExceptionHandler가 받음
    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, Model m) {
        System.out.println("m=" + m);
        System.out.println("catcher() in ExceptionController");
        m.addAttribute("ex", ex);
        return "/No27/error";
    }

    @RequestMapping("/ex")
    public String main(Model m) throws Exception {
        m.addAttribute("msg", "message from ExceptionController.main()");
        throw new Exception("예외가 발생했습니다.");
    }

    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
    public String catcher2(Exception ex, Model m){
        System.out.println("catcher2() in ExceptionController");
        m.addAttribute("ex", ex);
        return "/No27/error";
    }

    @RequestMapping("/ex2")
    public String main2() throws Exception {
        throw new NullPointerException("예외가 발생했습니다.");
    }

    @RequestMapping("/ex3")
    public String main3() throws Exception {
        throw new FileNotFoundException("예외가 발생했습니다.");
    }
}
