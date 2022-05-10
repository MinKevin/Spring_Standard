package com.spring.fastcampus.controller.No11;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Calendar;

//10.관심사의 분리와 MVC패턴 - 실습
@Controller
public class YoilTeller {
    @RequestMapping("/No11/getYoil") // http://localhost:8085/ch2/No11/getYoil?year=2021&month=10&day=1
    //    public static void main(String[] args) {
    public String main(int year, int month, int day, Model model) throws IOException {

        //*1. 유효성 검사
        if(!isValie(year, month, day))
            return "No10/yoilError";

        // 2. 처리 - *2. MVC과정에서 우클릭 - Refactor - Extract Method
        char yoil = getYoil(year, month, day);

        //*3. 계산한 결과를 model에 저장 (model은 view로 자동 전달)
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);

        //*3. 출력 to MVC
        return "No10/yoil";
    }

    private boolean isValie(int year, int month, int day) {

        return true;
    }

    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }
}
