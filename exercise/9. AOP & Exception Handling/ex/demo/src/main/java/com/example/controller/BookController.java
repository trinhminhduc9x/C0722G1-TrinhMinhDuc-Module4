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

  public  OrderacsAndPayacs orderacsAndPayacs = new OrderacsAndPayacs();

    @GetMapping("/create")
    public String create(Model model) {
        Random generator = new Random();
        Integer pass = generator.nextInt((99999 - 0) + 1) + 0;
        orderacsAndPayacs.setPassBook(pass);
        orderacsAndPayacs.setPayasc(0);
        orderacsAndPayacs.setOrderasc(0);
        oandPservice.save(orderacsAndPayacs);
        model.addAttribute("OrderacsAndPayacs", orderacsAndPayacs);
        model.addAttribute("book", new Book());
        return "/book/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        System.out.println(orderacsAndPayacs);
        book.getOrdersssAndPaysss().setPayasc(book.getAmount());
        bookService.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("/oder")
    public String edit(@RequestParam(name = "id") int id) throws Exception {
        Book book = bookService.findById(id);
        OrderacsAndPayacs orderacsAndPayacs = oandPservice.findById(id);
        if ((orderacsAndPayacs.getPayasc() + orderacsAndPayacs.getOrderasc() == book.getAmount()) && orderacsAndPayacs.getOrderasc() < book.getAmount()) {
            Integer oder = book.getOrdersssAndPaysss().getOrderasc() + 1;
            Integer pay = book.getOrdersssAndPaysss().getPayasc() - 1;
            orderacsAndPayacs.setOrderasc(oder);
            orderacsAndPayacs.setPayasc(pay);
            oandPservice.save(orderacsAndPayacs);
        } else if (orderacsAndPayacs.getPayasc() + orderacsAndPayacs.getOrderasc() < book.getAmount()) {
            Integer oder = book.getOrdersssAndPaysss().getOrderasc() + 1;
            orderacsAndPayacs.setOrderasc(oder);
            oandPservice.save(orderacsAndPayacs);
        } else {
            throw new Exception();
        }
        return "redirect:/book/list";
    }

    @GetMapping("/{id}/pay")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("OrderacsAndPayacs", oandPservice.findById(id));
        return "/book/pay";
    }

    @PostMapping("/{name}/pay")
    public String pay(@ModelAttribute OrderacsAndPayacs orderacsAndPayacs, @RequestParam(name = "passBook") int passBook) throws Exception {
        int id = orderacsAndPayacs.getId();
        if (passBook == orderacsAndPayacs.getPassBook()) {
            Book book = bookService.findById(id);
            OrderacsAndPayacs o = oandPservice.findById(id);
            Integer pay = book.getOrdersssAndPaysss().getPayasc() + 1;
            o.setPayasc(pay);
            Integer oder = book.getOrdersssAndPaysss().getOrderasc() - 1;
            o.setOrderasc(oder);
            oandPservice.save(o);

        } else {
            throw new Exception();
        }
        return "redirect:/book/list";
    }
}