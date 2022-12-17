package householdmanagement.controller;

import householdmanagement.dto.HouseholDto;
import householdmanagement.dtoView.HouseholView;
import householdmanagement.model.Househol;
import householdmanagement.model.Member;
import householdmanagement.service.IHouseholService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/househol")
public class HouseholController {
    @Autowired
    private IHouseholService iHouseholService;


    @ModelAttribute("MemberList")
    public List<Member> getListContract() {
        return iHouseholService.nameMemBer();
    }


    @GetMapping("/list")
    public String showPage(Model model,
                           @PageableDefault(size =3) Pageable pageable) {
        Page<HouseholView> householViewPage = iHouseholService.fildPageAll(pageable);
        model.addAttribute("householViewPage", householViewPage);
        return "househol/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("householDto", new HouseholDto());
        return "/househol/create";
    }

    @PostMapping("/save")
    public String save(@Validated
                       @ModelAttribute("householDto") HouseholDto householDto
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        new HouseholDto().validate(householDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/househol/create";
        } else {
            Househol househol = new Househol();
            BeanUtils.copyProperties(householDto, househol);
            iHouseholService.save(househol);
            redirectAttributes.addFlashAttribute("msg", " Create form "  + " ok ");
            return "redirect:/househol/list";
        }
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("householDto", iHouseholService.findById(id));
        return "/househol/update";
    }

    @PostMapping("/update")
    public String update(@Validated
                         @ModelAttribute("householDto") HouseholDto householDto
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes ) {
        new HouseholDto().validate(householDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/househol/update";
        } else {
            Househol househol = new Househol();
            BeanUtils.copyProperties(householDto, househol);
            iHouseholService.save(househol);
            redirectAttributes.addFlashAttribute("msg", " update form " + " ok ");
            return "redirect:/househol/list";
        }
    }
}
