package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.service.HomeService;



@Controller
@RequestMapping()
public class HomeController {
    @Autowired
    public HomeService homeServiceIplm;

    @GetMapping(value = "/")
    public String home() {
        return "home";
    }

    @PostMapping(value = "/validate")
    public String user(@RequestParam("email") String email, ModelMap modelMap) {
        homeServiceIplm.HomeController();
        boolean isValid = this.homeServiceIplm.validate(email);
        if (!isValid) {
            modelMap.addAttribute("message", "Email is invalid");
            return "home";
        }
        modelMap.addAttribute("email", email);
        return "success";
    }


}
