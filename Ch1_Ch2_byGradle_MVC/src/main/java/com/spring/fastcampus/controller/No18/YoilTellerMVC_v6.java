package com.spring.fastcampus.controller.No18;

import com.spring.fastcampus.dto.No17.MyDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Calendar;

//3.WebBinder
@Controller
public class YoilTellerMVC_v6 {
    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, BindingResult result){
        System.out.println("result = " + result);
        FieldError error = result.getFieldError();

        System.out.println("code = " + error.getCode());
        System.out.println("field = " + error.getField());
        System.out.println("msg = " + error.getDefaultMessage());

        ex.printStackTrace();
        return "No17/yoilError";
    }
    //의도적 오류 생성 시 결과
//    result = org.springframework.validation.BindException: org.springframework.validation.BeanPropertyBindingResult: 1 errors
//    Field error in object 'myDate' on field 'day': rejected value [abc]; codes [typeMismatch.myDate.day,typeMismatch.day
//    ,typeMismatch.int,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable:
//    codes [myDate.day,day]; arguments []; default message [day]]; default message [Failed to convert property value of type
//    'java.lang.String' to required type 'int' for property 'day'; nested exception is java.lang.NumberFormatException:
//    For input string: "abc"]
//    code = typeMismatch
//    field = day
//    msg = Failed to convert property value of type 'java.lang.String' to required type 'int' for property 'day';
//    nested exception is java.lang.NumberFormatException: For input string: "abc"


    @RequestMapping("/getYoilMVC_v6") // http://localhost:8085/ch2/getYoilMVC_v6?year=2021&month=10&day=abc
    //    public static void main(String[] args) {
    //public String main(@ModelAttribute("myDate") MyDate date, Model model) throws IOException { //아래와 동일
    public String main(MyDate date, BindingResult result) throws IOException {
        System.out.println("result = " + result);

        //*1. 유효성 검사
        if(!isValid(date))
            return "No17/yoilError";

        return "No17/yoil";
    }

    private boolean isValid(MyDate date) {

        return isValid(date.getYear(), date.getMonth(), date.getDay());
    }

    private boolean isValid(int year, int month, int day) {
        if(year==-1 || month==-1 || day==-1)
            return false;

        return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크
    }

    private @ModelAttribute("yoil") char getYoil(MyDate date) {
        return getYoil(date.getYear(), date.getMonth(), date.getDay());
    }

    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }
}
