package base.main.java.com.example.restservice.web;

import javax.servlet.http.HttpServletRequest;

import base.main.java.com.example.restservice.service.StudentService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String showfirstpage() {
        return "index";
    }


    @RequestMapping("/student")
    public String userlist() {
        return "student";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

}
