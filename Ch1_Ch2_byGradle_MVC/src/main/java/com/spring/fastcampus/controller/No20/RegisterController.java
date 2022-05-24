package com.spring.fastcampus.controller.No20;

import com.spring.fastcampus.dto.No20.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

//
@Controller
public class RegisterController {
    //@RequestMapping("/register/add")
//    @GetMapping("/register/add")
//    public String register(){
//        return "/No19/registerForm";
//    }

    //@RequestMapping(value="/register/save", method= RequestMethod.POST)
    @PostMapping("/register/save")//Spring 4.3부터
    public String save(@ModelAttribute User user, Model m) throws UnsupportedEncodingException {
        //1. 유효성 검사
        if(!isValid(user)){
            String msg = URLEncoder.encode("id를 잘못 입력하셨습니다", "utf-8");

            m.addAttribute("msg", msg);
            return "redirect:/register/add";

//            return "redirect:/register/add?msg="+msg;//URL재작성, urlRewriting
        }


        //2. DB에 신규회원 정보를 저장
        return "/No19/registerInfo";
    }

    private boolean isValid(User user) {
        return false;
    }
}
