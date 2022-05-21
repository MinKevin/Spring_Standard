package com.spring.fastcampus.controller.No13;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //Servlet이 초기화될 때 자동 호출되는 Method
        //1. Servlet의 초기화 작업 담당
        System.out.println("[HelloServlet] init() is called");
    }

    //새로고침시에 init은 다시 호출되지 않고, service만 호출됨
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 입력
        //2. 처리
        //3. 출력
        System.out.println("[HelloServlet] service() is called!");
        System.out.println("/");
    }

    @Override
    public void destroy() {
        //3. Servlet이 Memory에서 제거될 때 Servlet Container에 의해서 자동 호출
        System.out.println("[HelloServlet] destroy() is called!");
    }
}
