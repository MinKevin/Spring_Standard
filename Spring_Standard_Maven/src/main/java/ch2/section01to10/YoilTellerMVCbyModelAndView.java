package ch2.section01to10;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Calendar;


//연월일을 입력시 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVCbyModelAndView {
    @RequestMapping("/getYoilMVCbyMV")
    //main의 반환 타입을 void로 지정 시, 반환타입이 없으므로, mapping된 URL과 같은 이름의 반환값이 있다고 가정하고 mapping
    public ModelAndView main(int year, int month, int day) throws IOException {

        ModelAndView mv = new ModelAndView();
        //2.작업
        char yoil = getYoil(year, month, day);

        mv.addObject("year", year);
        mv.addObject("month", month);
        mv.addObject("day", day);
        mv.addObject("yoil", yoil);
        //3.출력
        mv.setViewName("yoil");
        return mv;
    }

    private static char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        //1.일요일, 2.월요일...
        return " 일월화수목금토".charAt(dayOfWeek);
    }

    private boolean isValid(int year, int month, int day) {
        return true;
    }
}
