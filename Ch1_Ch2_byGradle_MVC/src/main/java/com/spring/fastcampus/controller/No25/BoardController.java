package com.spring.fastcampus.controller.No25;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//No23의 LoginController와 view의 No23같이 사용
@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/list")
    public String list(HttpServletRequest request){
        if (!loginCheck(request)){
            return "redirect:/login/login?toURL="+request.getRequestURL();
        }
        return "No25/boardList";
    }

    private boolean loginCheck(HttpServletRequest request) {
        //1. 세션 획득
        HttpSession session = request.getSession();

        //2. 세션에 id가 있는지 확인
        return session.getAttribute("id") != null;

    }
}
