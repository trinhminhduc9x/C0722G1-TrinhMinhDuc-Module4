package ex2.controller;

import ex2.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping()
public class CalculatorController {
    double kq = 0;
    String result = "";
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public String home() {
        return "list";
    }

    @PostMapping ("/calculator")
    public String vnd(@RequestParam("first-operand") String firstOperand,
                      @RequestParam("second-operand") String secondOperand,
                      @RequestParam("operator") String operator, Model model) {
        result = this.calculatorService.calculate(firstOperand, secondOperand, operator) + "";
        model.addAttribute("result", result);
        model.addAttribute("firstOperand", firstOperand);
        model.addAttribute("secondOperand", secondOperand);
        return "list";
    }

}
