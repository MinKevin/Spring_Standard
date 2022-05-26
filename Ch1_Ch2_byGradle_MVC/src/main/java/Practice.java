import org.springframework.test.context.TestExecutionListeners;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Practice {
    @GetMapping("/register/add")
//    @RequestMapping(value="/register/add", method=RequestMethod.GET)
    public String register(){
        return "registerForm";

    }
}
