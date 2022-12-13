package casestudy.controller;

import casestudy.dto.CustomerDto;
import casestudy.model.contract.AttachFacility;
import casestudy.model.contract.Contract;
import casestudy.model.contract.ContractDetail;
import casestudy.model.customer.Customer;
import casestudy.model.customer.CustomerType;
import casestudy.model.employee.Employee;
import casestudy.model.facility.Facility;
import casestudy.service.contract.IAttachFacilityService;
import casestudy.service.contract.IContractDetailService;
import casestudy.service.contract.IContractService;
import casestudy.service.customer.ICustomerService;
import casestudy.service.employee.IEmployeeService;
import casestudy.service.facility.IFacilityService;
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
@RequestMapping("/contract")
public class contractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IEmployeeService iEmployeeService;


    @ModelAttribute("contract")
    public List<Contract> getListContract() {
        return iContractService.findListAll();
    }

    @ModelAttribute("contractDetail")
    public List<ContractDetail> getListContractDetail() {
        return iContractDetailService.findListAll();
    }

    @ModelAttribute("attachFacilit")
    public List<AttachFacility> getListAttachFacility() {
        return iAttachFacilityService.findListAll();
    }


    @ModelAttribute("customer")
    public List<Customer> getListCustomer() {
        return iCustomerService.findListAll();
    }

    @ModelAttribute("facility")
    public List<Facility> getListFacility() {
        return iFacilityService.findListAll();
    }

    @ModelAttribute("employee")
    public List<Employee> getListEmployee() {
        return iEmployeeService.findListAll();
    }


    @GetMapping("/list")
    public String showPage(Model model,
                           @PageableDefault(size = 6) Pageable pageable) {
        Page<Contract> contractPage = iContractService.fildPageAll(pageable);
        model.addAttribute("contractPage", contractPage);
        return "contract/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("Contract", new Contract());
        return "/contract/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("contract") Contract contract
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes, Model model) {
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("msg", " Create form " + " ok ");
        return "redirect:/contract/list";
    }
}

