package com.spring.fastcampus.controller.No18;

import com.spring.fastcampus.dto.No17.MyDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Calendar;

//10.관심사의 분리와 MVC패턴 - 실습
@Controller
public class YoilTellerMVC_v5 {
    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex){
        ex.printStackTrace();
        return "No17/yoilError";
    }

    @RequestMapping("/getYoilMVC_v5") // http://localhost:8085/ch2/getYoilMVC_v5?year=2021&month=10&day=1
    //    public static void main(String[] args) {
    //public String main(@ModelAttribute("myDate") MyDate date, Model model) throws IOException { //아래와 동일
    public String main(@ModelAttribute MyDate date, Model model) throws IOException {

        //*1. 유효성 검사
        if(!isValid(date))
            return "No17/yoilError";

        // 2. 처리 - *2. MVC과정에서 우클릭 - Refactor - Extract Method
        // 5.24.1 @ModelAttribute("yoil")을 사용하기 떄문에 getYoil호출 부분 필요 X
        //char yoil = getYoil(date);

        //*3. 계산한 결과를 model에 저장 (model은 view로 자동 전달)
        //5.24.2 @ModelAttribute가 Model에 값을 알아서 넣어줌
        //model.addAttribute("myDate", date);
        //model.addAttribute("yoil", yoil);
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
