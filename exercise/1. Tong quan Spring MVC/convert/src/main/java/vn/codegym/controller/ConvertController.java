package vn.codegym.controller;

import vn.codegym.service.IConvertService;
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
    private IConvertService iConvertService;

    @GetMapping
    public String home() {
        return "list";
    }

    @GetMapping("/convert")
    public String Return(Model model, @RequestParam(name = "rate") double rate, @RequestParam(name = "usd") double usd) {
        model.addAttribute("rate", rate);
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", this.iConvertService.convert(rate, usd));
        return "list";
    }


}
