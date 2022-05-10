package com.spring.fastcampus.controller.No10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

//10.관심사의 분리와 MVC패턴 - 실습
@Controller
public class YoilTellerMVC {
    @RequestMapping("/getYoilMVC") // http://localhost:8085/ch2/getYoilMVC?year=2021&month=10&day=1
    //    public static void main(String[] args) {
    public String main(int year, int month, int day, Model model) throws IOException {

        //*1. 유효성 검사
        if(!isValie(year, month, day))
            return "No10/yoilError";

        // 1. 입력
//        String year = args[0];
//        String month = args[1];
//        String day = args[2];
//        String year = request.getParameter("year");
//        String month = request.getParameter("month");
//        String day = request.getParameter("day");

//        int yyyy = Integer.parseInt(year);
//        int mm = Integer.parseInt(month);
//        int dd = Integer.parseInt(day);

        // 2. 처리 - *2. MVC과정에서 우클릭 - Refactor - Extract Method
        char yoil = getYoil(year, month, day);

        //*3. 계산한 결과를 model에 저장 (model은 view로 자동 전달)
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);

        // 3. 출력 - jsp파일 새로 생성하여 관심사 분리
////        System.out.println(year + "년 " + month + "월 " + day + "일은 ");
////        System.out.println(yoil + "요일입니다.");
//        response.setContentType("text/html");    // 응답의 형식을 html로 지정
//        response.setCharacterEncoding("utf-8");  // 응답의 인코딩을 utf-8로 지정
//        PrintWriter out = response.getWriter();  // 브라우저로의 출력 스트림(out)을 얻는다.
//        out.println("<html>");
//        out.println("<head>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println(year + "년 " + month + "월 " + day + "일은 ");
//        out.println(yoil + "요일입니다.");
//        out.println("</body>");
//        out.println("</html>");
//        out.close();

        //3. 출력 to MVC
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
