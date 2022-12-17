package moviemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.GeneratedValue;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("")
    private String home(){
        return "home";
    }
}
