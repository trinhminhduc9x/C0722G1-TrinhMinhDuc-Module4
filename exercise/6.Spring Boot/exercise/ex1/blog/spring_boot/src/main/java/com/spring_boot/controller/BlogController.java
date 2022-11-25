package com.spring_boot.controller;

import com.spring_boot.model.Blog;
import com.spring_boot.model.Category;
import com.spring_boot.service.ICategoryService;
import com.spring_boot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping("/list")
    public String showStudentList(Model model) {
        model.addAttribute("productList", blogService.findAll());

        return "/blog/index";
    }

    @GetMapping("/create")
    public String create(Model model) {

        List<Category> categoryList = categoryService.findAll();



        model.addAttribute("categoryList", categoryList);


        model.addAttribute("blog",new Blog());


        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, Model model) {



        model.addAttribute("product",new Blog());

        blogService.save(blog);


        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", blogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        blogService.update(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        blogService.remove(id);
        redirect.addFlashAttribute("success", "Delete new success");
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", blogService.findById(id));
        return "/blog/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam int id, Model model) {
        model.addAttribute("products", blogService.findById(id));
        return "/blog/list";
    }


}