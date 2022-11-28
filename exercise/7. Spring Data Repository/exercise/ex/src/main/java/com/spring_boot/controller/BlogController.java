package com.spring_boot.controller;

import com.spring_boot.model.Blog;
import com.spring_boot.model.Category;
import com.spring_boot.service.ICategoryService;
import com.spring_boot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping("/list")
    public String goPage(Model model,
                         @PageableDefault(3) Pageable pageable,
                         @RequestParam Optional<String> name,
                         @RequestParam(required = false, defaultValue = "") String note) throws Exception {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }
        String keyName = name.orElse("");
        Page<Blog> blogPage = blogService.findAll(pageable, keyName, note);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("name", keyName);
        model.addAttribute("note", note);


        if (blogPage.isEmpty()) {
            throw new Exception();
        } else {
            return "blog/list";
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        blogService.update(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Integer id) {
        blogService.remove(id);
        return "redirect:/blog/list";
    }

    @ExceptionHandler(value = Exception.class)
    public String error() {
        return "/error";
    }

}