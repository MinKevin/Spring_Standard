package com.spring.fastcampus.controller.No13;

import org.springframework.http.server.ServerHttpResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/rollDice_JspToServlet")
public class TwoDice_Servlet extends HttpServlet {
    int getRandomInt(int range){
        return new Random().nextInt(range) + 1;
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int idx1 = getRandomInt(6);
        int idx2 = getRandomInt(6);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>twoDice.jsp</title>");
        //...
    }
}
