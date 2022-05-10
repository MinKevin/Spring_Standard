package ctx.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

//연월일을 입력시 요일을 알려주는 프로그램
@Controller
public class YoilTeller_remote {

    @RequestMapping("/getYoil")
    public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 입력

        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        //2.작업
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm - 1, dd);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        //1.일요일, 2.월요일...
        char yoil = " 일월화수목금토".charAt(dayOfWeek);
        //3.출력
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();//response 객체에서 브라우저로의 출력 스트림 획득
        out.println(year + "년 " + month + "월 " + day + "일은 ");
        out.println(yoil + "요일입니다.");

        System.out.println(year + "년 " + month + "월 " + day + "일은 ");
        System.out.println(yoil + "요일입니다.");
    }
}
