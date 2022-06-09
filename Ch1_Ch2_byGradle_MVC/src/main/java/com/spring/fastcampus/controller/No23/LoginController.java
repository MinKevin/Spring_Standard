package com.spring.fastcampus.controller.No23;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/login")
    public String loginForm() {
        return "/No23/loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login/login";
    }

    @GetMapping("/index")
        public String indexPage(){
            return "/No23/index";
        }


        //@CookieValue("id") : 쿠키 중에 id라는 name을 가진 쿠키의 값을 파라미터에 전달
        //@CookieValue("JSESSIONID") : 세션정보도 전달 가능
    @PostMapping("/login")
    public String login(@CookieValue("id") String id, String pwd, Boolean rememberId, String toURL,
                        HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        System.out.println("id=" + id);
        System.out.println("pwd=" + pwd);
        System.out.println("rememberId=" + rememberId);
        //1. id와 pwd를 확인
        if (!loginCheck(id, pwd)) {
            String msg = URLEncoder.encode("id 또는 Pwd가 일치하지 않습니다.", "UTF-8");

            //2-1. 일치하지 않으면, loginForm으로 이동
            return "redirect:/login/login?msg=" + msg;
        }

        //2-2. id와 pwd가 일치하면, 홈으로 이동
        //      Session 객체에 아이디를 저장
        HttpSession session = request.getSession();
        session.setAttribute("id", id);

        if(rememberId != null){
            //  1. 쿠키를 생성
            Cookie cookie = new Cookie("id", id);//ctrl + shift + o 자동 import
            //  2. 응답에 저장
            response.addCookie(cookie);

        }else{
            //쿠키를 삭제
            //  1. 쿠키를 생성 (혹시 있을지도 모르는 쿠키를 삭제)
            Cookie cookie = new Cookie("id", id);
            cookie.setMaxAge(0);
            //  2. 응답에 저장
            response.addCookie(cookie);
        }

        //  1. 쿠키를 생성
        Cookie cookie = new Cookie("id", id);//ctrl + shift + o 자동 import
        //  2. 응답에 저장
        response.addCookie(cookie);
        //  3. 홈으로 이동
        //return "/No23/index";
        //아래는 안됨 : URL이 /No23/idex로 요청을 하기 때문, (redirect가 붙어 있기 때문에 viewResolver를 거치지 않고 client에게 반환
        //return "redirect:/No23/index";

        toURL = toURL == null || toURL.equals("") ? "/login/index" : toURL;

        return "redirect:" + toURL;
    }

    private boolean loginCheck(String id, String pwd) {
        return "asdf".equals(id) && "1234".equals(pwd);
    }
}

