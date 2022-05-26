package com.spring.fastcampus.controller.No28;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

//사용자 정의 예외
//@ResponseStatus(HttpStatus.BAD_REQUEST)//500 -> 400
class MyException extends RuntimeException{
    MyException(String msg){
        super(msg);
        System.out.println("MyException");
    }
    MyException(){
        this("");
    }
}

@Controller
public class ExceptionController2_2 {
    @RequestMapping("/No28/ex4")
    public String main() throws Exception {
        throw new MyException("예외가 발생했습니다.");
    }

    @RequestMapping("/No28/ex5")
    public String main2() throws Exception {
        throw new NullPointerException("예외가 발생했습니다.");
    }
}
