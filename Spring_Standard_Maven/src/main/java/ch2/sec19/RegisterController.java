package ch2.sec19;

import ch2.sec20.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller//ctrl+shift+o => 자동 import
public class RegisterController {
    //@RequestMapping("/register/add")
    @GetMapping("/register/add")
    public String register(){
        return "registerForm";//WEB-INF/views/registerForm.jsp
    }

    //@RequestMapping(value="/register/save", method={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("register/save") //spring 4.3부터 생김
    public String save(User user, Model m) throws UnsupportedEncodingException {
        //1. 유효성 검사
        if(!isValid(user)){
            String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");

            /**@NOTE 14/06/2023
             *  m.addAttribute("msg", msg);
             *  return "redirect:/register/add";
             *
             *  redirect의 경우 model을 전달할 수 없으므로, 결국에는 이를 Spring이 자체적으로
             *  return "redirect:/register/add?msg=" + msg;
             *  와 같은 형태로 변환해서 전송해준다.
             */
            m.addAttribute("msg", msg);
            return "redirect:/register/add";
//            return "redirect:/register/add?msg=" + msg;//URL 재작성
        }

        //2. DB에 신규 회원 정보를 저장
        return "registerInfo";
    }

    private boolean isValid(User user) {
        return true;
    }

}
