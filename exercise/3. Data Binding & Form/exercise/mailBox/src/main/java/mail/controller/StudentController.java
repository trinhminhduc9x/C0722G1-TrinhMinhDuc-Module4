package mail.controller;

import mail.model.MailBox;
import mail.service.MailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/mailbox")
public class StudentController {

    @Qualifier("mailBoxServiceImpl")
    @Autowired
    private MailBoxService mailBoxService;

    @GetMapping
    public String showList(Model model) {
        List<MailBox> mailBoxList = mailBoxService.findAll();
        model.addAttribute("mailBoxList", mailBoxList);
        return "list";
    }


    @GetMapping("/search")
    public ModelAndView showListSearch(@RequestParam(value = "search",
            required = false, defaultValue = "") String search) {
        return new ModelAndView("list", "mailBoxList", mailBoxService.findByName(search));
    }

    @GetMapping("/create")
    public String showCreatPage(Model model) {
        model.addAttribute("MailBox", new MailBox());
        model.addAttribute("LanguagesListAll", mailBoxService.findLanguagesListAll());
        model.addAttribute("PageListAll", mailBoxService.findPageListAll());
        return "create";

    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute MailBox mailBox,
                                RedirectAttributes redirectAttributes) {
        mailBoxService.save(mailBox);
        redirectAttributes.addFlashAttribute("message", "createStudent : " + mailBox.getLanguages() + " da them moi OK");
        return "redirect:/mailbox";
    }
}
