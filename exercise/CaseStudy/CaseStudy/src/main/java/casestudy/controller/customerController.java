package casestudy.controller;

import casestudy.dto.CustomerDto;
import casestudy.model.customer.Customer;
import casestudy.model.customer.CustomerType;
import casestudy.service.customer.ICustomerService;
import casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class customerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/list")
    public String showPage(Model model,
                           @PageableDefault(size = 6) Pageable pageable,
                           @RequestParam(required = false, defaultValue = "") String name,
                           @RequestParam(required = false, defaultValue = "") String dataOfBirth,
                           @RequestParam(required = false, defaultValue = "") String CustomerTypeID) {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }
        Page<Customer> customerPage = iCustomerService.fildPageAll(pageable, name, dataOfBirth, CustomerTypeID);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("name", name);
        model.addAttribute("dataOfBirth", dataOfBirth);
        model.addAttribute("CustomerTypeID", CustomerTypeID);
        model.addAttribute("CustomerTypeList", iCustomerTypeService.fildListAll());
        return "customer/list";
    }


    @GetMapping("/create")
    public String create(Model model) {

        List<CustomerType> customerTypeList = iCustomerTypeService.fildListAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDto", new CustomerDto());

        return "/customer/create";
    }

    @PostMapping("/save")
    public String save(@Validated
                       @ModelAttribute("customerDto") CustomerDto customerDto
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("msg", " Create form " + customer.getName() + " ok ");
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        model.addAttribute("customerTypeList", iCustomerTypeService.fildListAll());
        return "/customer/update";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/customer/list";
    }

    @PostMapping ("/delete")
    public String delete(@RequestParam(name = "id") Integer id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", " Delete form " + iCustomerService.findById(id).getName() + " ok ");
        iCustomerService.remove(id);
        return "redirect:/customer/list";
    }
}
