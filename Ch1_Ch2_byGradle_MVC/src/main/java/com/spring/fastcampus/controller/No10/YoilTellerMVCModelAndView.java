package com.spring.fastcampus.controller.No10;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Calendar;

//10.관심사의 분리와 MVC패턴 - 실습
//ModelAndView 반환 (잘 안씀)
@Controller
public class YoilTellerMVCModelAndView {
    @RequestMapping("/getYoilMVCModelAndView") // http://localhost:8085/ch2/getYoilMVCModelAndView?year=2021&month=10&day=1
    //    public static void main(String[] args) {
//    public String main(int year, int month, int day, Model model) throws IOException {
    public ModelAndView main(int year, int month, int day) throws IOException {
        //1. ModelAndView를 생성하고, 기본 뷰를 지정
        ModelAndView mv = new ModelAndView();

        //2. 유효성 검사
        if(!isValid(year, month, day)){
            return mv;
        }

        //3. 작업
        char yoil = getYoil(year, month, day);

        //4. ModelAndView에 작업한 결과를 저장
        mv.addObject("year", year);
        mv.addObject("month", month);
        mv.addObject("day", day);
        mv.addObject("yoil", yoil);

        //5. 작업 결과를 보여줄 뷰의 이름을 지정
        mv.setViewName("No10/yoil");

        //6. ModelAndView를 반환환
        return mv;
    }

    private boolean isValid(int year, int month, int day) {
        return true;
    }

    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }
}
