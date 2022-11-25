package codegym.blog.controller;

import codegym.blog.model.Blog;
import codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;


    @GetMapping("/list")
    public String showStudentList(Model model) {
        model.addAttribute("productList", blogService.findAll());

        return "blog/list";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("blog",new Blog());

        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "save new success");
        return "redirect:blog/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog,RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("success", "update new success");
        return "redirect:blog/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        blogService.remove(id);
        redirect.addFlashAttribute("success", "Delete new success");
        return "redirect:blog/list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", blogService.findById(id));
        return "blog/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam int id, Model model) {
        model.addAttribute("products", blogService.findById(id));
        return "blog/list";
    }


}