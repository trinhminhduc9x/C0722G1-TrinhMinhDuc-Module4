package form.controller;

import form.dto.FormDto;
import form.model.Form;
import form.service.IFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(" ")
public class FormController {

    @Autowired
    private IFormService formService;

    @GetMapping(" ")
    public String showFormList(Model model) {
        model.addAttribute("formDto", new FormDto());
        return "/form";
    }

    @PostMapping("/")
    public String checkValidation(@Validated
                                  @ModelAttribute("formDto") FormDto formDto
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes
            , Model model) {
        new FormDto().validate(formDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/form";
        } else {
            Form form = new Form();
            BeanUtils.copyProperties(formDto, form);
            formService.save(form);
            redirectAttributes.addFlashAttribute("message", "Create form" + form.getFirstName() + "ok");
            return "/form";
        }
    }
}
