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
        model.addAttribute("facilityTypeList", iFacilityTypeService.fildListAll());
        model.addAttribute("iRentTypeList", iRentTypeService.fildListAll());
        return "facility/list";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("facilityTypes", iFacilityTypeService.fildListAll());
        model.addAttribute("rentTypeList", iRentTypeService.fildListAll());
        model.addAttribute("facilityDto", new FacilityDto());

        return "/facility/create";
    }

    @PostMapping("/save")
    public String save(@Validated
                       @ModelAttribute("facilityDto") FacilityDto facilityDto
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes
            , Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityTypes", iFacilityTypeService.fildListAll());
            model.addAttribute("rentTypeList", iRentTypeService.fildListAll());
            return "/facility/create";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            iFacilityService.save(facility);
            redirectAttributes.addFlashAttribute("msg", " Create form " + facility.getName() + " ok ");
            return "redirect:/facility/list";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("facilityDto", iFacilityService.findById(id));
        model.addAttribute("facilityTypes", iFacilityTypeService.fildListAll());
        model.addAttribute("rentTypeList", iRentTypeService.fildListAll());
        return "/facility/update";
    }

    @PostMapping("/update")
    public String update(@Validated
                         @ModelAttribute("facilityDto") FacilityDto facilityDto
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes
            , Model model) {
        new CustomerDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityTypes", iFacilityTypeService.fildListAll());
            model.addAttribute("rentTypeList", iRentTypeService.fildListAll());
            return "/facility/update";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            iFacilityService.save(facility);
            redirectAttributes.addFlashAttribute("msg", " Create form " + facility.getName() + " ok ");
            return "redirect:/facility/list";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "id") Integer id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", " Delete form " + iFacilityService.findById(id).getName() + " ok ");
        iFacilityService.remove(id);
        return "redirect:/facility/list";
    }
}
