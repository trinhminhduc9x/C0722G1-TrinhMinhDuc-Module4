package com.spring_boot.controller;


import com.spring_boot.model.Blog;
import com.spring_boot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/blogRest")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;

    @GetMapping(" ")
    public ResponseEntity<Page<Blog>> goPage(@PageableDefault(10) Pageable pageable,
                                             @RequestParam Optional<String> name) {

        String keyName = name.orElse("");
        Page<Blog> blogPage = blogService.findAllNamw(pageable, keyName);
        if (blogPage==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Blog>> goPage() {


        List<Blog> blogPage = blogService.findAll();
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }



    @GetMapping("/view/{id}")
    public ResponseEntity<Blog> goDetail(@PathVariable Integer id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Page<Void>> save(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}