package sing.controller;


import org.springframework.web.bind.annotation.*;
import sing.dto.SingDto;
import sing.model.Sing;
import sing.service.ISingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping(" ")
public class SingController {


    @Autowired
    private ISingService singService;

    @GetMapping(" ")
    public String showList(Model model) {
        List<Sing> singList = singService.findAll();
        model.addAttribute("singList", singList);
        return "/list";
    }

    @GetMapping("/create")
    public String showFormList(Model model) {
        model.addAttribute("SingDto", new SingDto());
        return "create";
    }

    @PostMapping("/save")
    public String create(@Valid
                         @ModelAttribute("SingDto") SingDto singDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        new SingDto().validate(singDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Sing sing = new Sing();
        BeanUtils.copyProperties(singDto, sing);
        singService.save(sing);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String showUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("sing", singService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Valid
                         @ModelAttribute("sing") SingDto singDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        new SingDto().validate(singDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Sing sing = new Sing();
        BeanUtils.copyProperties(singDto, sing);
        model.addAttribute("SingDto", singDto);
        singService.save(sing);
        redirectAttributes.addFlashAttribute("msg","Register successfully!");
        return "list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirect) {
        singService.remove(id);
        redirect.addFlashAttribute("success", "Delete new success");
        return "redirect:/";
    }
}
