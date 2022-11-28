package demo.demo.controller;


import demo.demo.model.Customer;
import demo.demo.model.Province;
import demo.demo.service.ICustomerService;
import demo.demo.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @GetMapping(value = "/list")
    public String showStudentList(Model model) {
        model.addAttribute("customersList", customerService.findAll());
        return "/customer/list";
    }


    @GetMapping("/create")
    public String showCreatePage(Model model) {

        model.addAttribute("customersList", customerService.findAll());


        model.addAttribute("provincesList", provinceService.findAll());

        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Customer customer,
                                RedirectAttributes redirectAttributes) {

        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message",
                "Create student: " + customer.getFirstName() + " OK!");
        return "redirect:/list";
    }

    @GetMapping("/delete-customer/{id}")
    public String detelet(@PathVariable int id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("new", "delte new success");
        return "redirect:/list";

    }

    @GetMapping("/edit-customer/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {

        List<Province> provinceList = provinceService.findAll();

        model.addAttribute("customer", customerService.findById(id));

        model.addAttribute("provincesList", provinceList);


        return "/customer/edit";
    }

//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable int id, Model model) {
//        model.addAttribute("customer", customerService.findById(id));
//        model.addAttribute("provinces", provinceService.findById(id));
//        return "/customer/edit";
//    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }
}