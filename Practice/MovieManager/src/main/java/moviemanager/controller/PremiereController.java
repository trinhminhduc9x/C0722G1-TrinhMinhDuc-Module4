package moviemanager.controller;

import moviemanager.service.IPremiereService;
import moviemanager.service.PremiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/premiere")
public class PremiereController {
    @Autowired
    IPremiereService iPremiereService;

    @GetMapping("/list")
    private String showerList(@PageableDefault(size = 3) Pageable pageable, Model model) {
        model.addAttribute("premierePage", iPremiereService.fildPage(pageable));
        return "/premiere/list";
    }

    @PostMapping("/delete")
    private String delete(@RequestParam(name = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        iPremiereService.remove(id);
        redirectAttributes.addFlashAttribute("msg","xóa thành công");
        return "redirect:/premiere/list";
    }

}
