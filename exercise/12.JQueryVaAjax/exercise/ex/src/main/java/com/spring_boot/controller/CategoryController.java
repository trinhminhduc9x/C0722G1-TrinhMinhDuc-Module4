package com.spring_boot.controller;

import com.spring_boot.model.Blog;
import com.spring_boot.model.Category;
import com.spring_boot.service.IBlogService;
import com.spring_boot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {



    @Autowired
    private ICategoryService categoryService;




    @GetMapping("/list")
    public String goPage(Model model,
                         @PageableDefault(10) Pageable pageable,
                         @RequestParam Optional<String> name,
                         @RequestParam(required = false, defaultValue = "") String note) {
        for (Sort.Order order: pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }
        String keyName = name.orElse("");
        Page<Category> categoryPage = categoryService.findAll(pageable,keyName);
        model.addAttribute("categoryPage", categoryPage);
        model.addAttribute("name", keyName);
        return "category/index";
    }

    @GetMapping("/create")
    public String create(Model model) {

        List<Category> categoryList = categoryService.findAll();


        model.addAttribute("category", new Category());


        return "/category/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category) {

        categoryService.save(category);

        return "redirect:/category/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category/edit";
    }

    @PostMapping("/update")
    public String update(Category category) {
        categoryService.update(category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        categoryService.remove(id);
        return "redirect:/category/list";
    }


    @GetMapping("/search")
    public String search(@RequestParam int id, Model model) {
        model.addAttribute("products", categoryService.findById(id));
        return "/category/index";
    }


}
