package codegym.controller;

import codegym.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
public class ConvertController {


    @Autowired
    private TranslateService translateService;

    @GetMapping
    public String home() {
        return "list";
    }


    @GetMapping("/translate")
    public String vnd(@RequestParam String eng, Model model) {

        model.addAttribute("eng", eng);
        model.addAttribute("vie", this.translateService.translate(eng));
        return "list";

    }

}
