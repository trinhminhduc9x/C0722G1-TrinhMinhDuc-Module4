package com.example.controller;

import com.example.model.Book;
import com.example.model.OrderacsAndPayacs;
import com.example.service.IBookService;
import com.example.service.IOandPservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Random;


@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOandPservice oandPservice;

    @GetMapping("")
    public String Home() {
        return "home";
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<Book> bookList = bookService.findListAll();
        model.addAttribute("bookList", bookList);
        return "book/list";
    }


    @GetMapping("/create")
    public String create(Model model) {
        oandPservice.save(oandPservice.ramdom());
        model.addAttribute("OrderacsAndPayacs", oandPservice.ramdom());
        model.addAttribute("book", new Book());
        return "/book/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        book.getOrdersssAndPaysss().setPayasc(book.getAmount());
        bookService.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("/oder")
    public String oder(@RequestParam(name = "id") int id) throws Exception {
        Book book = bookService.findById(id);
        OrderacsAndPayacs orderacsAndPayacs = oandPservice.findById(id);
        bookService.oandP(book, orderacsAndPayacs);
        return "redirect:/book/list";
    }

    @GetMapping("/{id}/pay")
    public String showPay(@PathVariable int id, Model model) {
        model.addAttribute("OrderacsAndPayacs", oandPservice.findById(id));
        return "/book/pay";
    }

    @PostMapping("/{name}/pay")
    public String pay(@ModelAttribute OrderacsAndPayacs orderacsAndPayacs, @RequestParam(name = "passBook") int passBook)  {
        int id = orderacsAndPayacs.getId();
        OrderacsAndPayacs o = oandPservice.findById(id);
        Book book = bookService.findById(id);
        bookService.pay(book,o,passBook,id);
        return "redirect:/book/list";
    }
}