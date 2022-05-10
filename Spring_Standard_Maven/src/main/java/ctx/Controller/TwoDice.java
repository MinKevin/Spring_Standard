package ctx.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//random 함수를 사용하였으므로 실행 시 마다 결과가 변하는 동적 리소스
//image 같은 경우는 정적 리소스
@Controller
public class TwoDice {
    @RequestMapping("rollDice")
    public void main(HttpServletResponse response) throws IOException {
        int idx1 = (int) (Math.random() * 6) + 1;
        int idx2 = (int) (Math.random() * 6) + 1;

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='dice" + idx1 + ".jpg'>");
        out.println("<img src='dice" + idx2 + ".jpg'>");
        out.println("</body>");
        out.println("</html>");

    }
}
