package casestudy.controller;

import casestudy.dto.CustomerDto;
import casestudy.dto.FacilityDto;
import casestudy.model.customer.Customer;
import casestudy.model.customer.CustomerType;
import casestudy.model.facility.Facility;
import casestudy.model.facility.FacilityType;
import casestudy.model.facility.RentType;
import casestudy.service.customer.ICustomerService;
import casestudy.service.customer.ICustomerTypeService;
import casestudy.service.facility.IFacilityService;
import casestudy.service.facility.IFacilityTypeService;
import casestudy.service.facility.IRentTypeService;
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
@RequestMapping("/facility")
public class facilityController {
    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;


    @GetMapping("/list")
    public String showPage(Model model,
                           @PageableDefault(size = 6) Pageable pageable,
                           @RequestParam(required = false, defaultValue = "") String name,
                           @RequestParam(required = false, defaultValue = "") String facilityTypeID) {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }
        Page<Facility> facilityPage = iFacilityService.fildPageAll(pageable, name, facilityTypeID);
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("name", name);
        model.addAttribute("facilityTypeID", facilityTypeID);
        model.addAttribute("facilityTypeList", iFacilityTypeService.findListAll());
        model.addAttribute("iRentTypeList", iRentTypeService.findListAll());
        return "facility/list";
    }

    @GetMapping("/create")
    public String create(Model model) {

        List<FacilityType> facilityTypes = iFacilityTypeService.findListAll();
        List<RentType> rentTypeList = iRentTypeService.findListAll();
        model.addAttribute("facilityTypes", facilityTypes);
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("facilityDto", new FacilityDto());

        return "/facility/create";
    }

    @PostMapping("/save")
    public String save(@Validated
                       @ModelAttribute("facilityDto") FacilityDto facilityDto
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/facility/create";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            iFacilityService.save(facility);
            redirectAttributes.addFlashAttribute("msg", " Create form " + facility.getName() + " ok ");
            return "redirect:/facility/list";
        }
    }

}
