package ch2.section01to10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Calendar;


//연월일을 입력시 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC {
    @RequestMapping("/getYoilMVC")
    //main의 반환 타입을 void로 지정 시, 반환타입이 없으므로, mapping된 URL과 같은 이름의 반환값이 있다고 가정하고 mapping
    public String main(int year, int month, int day, Model model) throws IOException {
        if (!isValid(year, month, day)){
            return "yoilError";
        }
        //2.작업
        char yoil = getYoil(year, month, day);

        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);
        //3.출력
        return "yoil";
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
