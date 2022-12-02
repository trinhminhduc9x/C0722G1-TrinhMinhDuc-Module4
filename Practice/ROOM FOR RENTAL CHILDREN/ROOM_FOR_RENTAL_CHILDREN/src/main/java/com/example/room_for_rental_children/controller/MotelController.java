package com.example.room_for_rental_children.controller;

import com.example.room_for_rental_children.model.MotelRoom;
import com.example.room_for_rental_children.service.IMotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/motelRoom")
public class MotelController {

    @Autowired
    IMotelRoomService iMotelRoomService;

//    hiện thị list với phân trang và ko phân trang

//    @RequestMapping("/list")
//    private String showList(Model model,@PageableDefault(page = 0,size = 1) Pageable pageable){
//    hiển thị list
////        model.addAttribute("motelRoom",iMotelRoomService.findListAll());
//    phân trang list
//        model.addAttribute("motelRoom",iMotelRoomService.findPageAll(pageable));
//        return "MotelRoom/list";
//    }


//    hiển thị list với phan trang

    @RequestMapping("/list")
    private String showList(Model model,@PageableDefault(page = 0,size = 1) Pageable pageable){
        model.addAttribute("motelRoom",iMotelRoomService.findPageAll(pageable));
        return "MotelRoom/list";
    }
    //    hiển thị list với câu tìm kiếm
    @GetMapping("/list")
    public String goPage(Model model,
                         @PageableDefault(6) Pageable pageable,
                         @RequestParam Optional<String> name,
                         @RequestParam(required = false, defaultValue = "") String email,
                         @RequestParam(required = false, defaultValue = "") String CustomerTypeID) {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }
        String keyName = name.orElse("");

        Page<MotelRoom> motelRooms = iMotelRoomService.findPageNameEmailType(pageable, keyName, email, CustomerTypeID);

        List<CustomerType> customerTypeList = customerTypeService.findListAll();


        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("CustomerTypeID", CustomerTypeID);
        model.addAttribute("name", keyName);
        model.addAttribute("email", email);
    }
}
