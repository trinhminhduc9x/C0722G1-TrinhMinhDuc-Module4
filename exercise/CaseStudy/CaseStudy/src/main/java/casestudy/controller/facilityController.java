package casestudy.controller;

import casestudy.dto.CustomerDto;
import casestudy.dto.FacilityDto;
import casestudy.model.facility.Facility;
import casestudy.model.facility.FacilityType;
import casestudy.model.facility.RentType;
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

    @ModelAttribute("facilityTypeList")
    public List<FacilityType> getListFacilityType() {
        return iFacilityTypeService.fildListAll();
    }
    @ModelAttribute("iRentTypeList")
    public List<RentType> getListRentTypeType() {
        return iRentTypeService.fildListAll();
    }



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
        return "facility/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
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
