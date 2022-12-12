package casestudy.controller;

import casestudy.service.customer.ICustomerService;
import casestudy.service.employee.IEmployeeService;
import casestudy.service.impl.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class employeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("employee",iEmployeeService.findListAll());
        return "/employee/list";
    }
}
