package ctx.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

//1. 원격 호출가능한 프로그램으로 등록
@Controller
public class Hello {
    int iv = 10;       //인스턴스 변수
    static int cv = 20;//static 변수
    @Autowired
    ServletContext servletContext;
    //2. URL과 메서드를 연결
    @RequestMapping(value="/hello")

  private String main(){
        System.out.println("class Hello -> Method private main");

        System.out.println(cv);//OK
        System.out.println(iv);//OK
        System.out.println(servletContext.getRealPath("/resources/img/dice1.jpg"));
        return "index";
    }

    public static void main2(){ //static 메서드
        System.out.println(cv);//OK
//        System.out.println(iv);//에러
    }
}
