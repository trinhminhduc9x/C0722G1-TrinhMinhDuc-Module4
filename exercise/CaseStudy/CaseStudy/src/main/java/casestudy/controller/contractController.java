package casestudy.controller;

import casestudy.model.contract.Contract;
import casestudy.model.customer.Customer;
import casestudy.service.contract.IContractService;
import casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contract")
public class contractController {
    @Autowired
    private IContractService iContractService;
    @GetMapping("/list")
    public String showPage(Model model,
                           @PageableDefault(size = 6) Pageable pageable) {

        Page<Contract> contractPage = iContractService.fildPageAll(pageable);
        model.addAttribute("contractPage", contractPage);

        return "contract/list";
    }
}
