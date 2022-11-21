package ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpiceDisplayController {


    @GetMapping
    public String home() {
        return "/list";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String[] name, Model model) {
        model.addAttribute("name", name);
        return "/list";
    }
}
