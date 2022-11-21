package ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
public class SpiceDisplayController {


    @GetMapping
    public String home() {
        return "/list";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String[] name, Model model) {
        model.addAttribute("result", Arrays.toString(name));
        return "/list";
    }
}
