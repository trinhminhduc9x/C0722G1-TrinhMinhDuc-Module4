package com.example.room_for_rental_children.controller;

import com.example.room_for_rental_children.model.MotelRoom;
import com.example.room_for_rental_children.service.IMotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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


//    hiển thị list với câu tìm kiếm

    @RequestMapping("/list")
    private String showList(Model model,@PageableDefault(page = 0,size = 1) Pageable pageable){
        model.addAttribute("motelRoom",iMotelRoomService.findPageAll(pageable));
        return "MotelRoom/list";
    }

}
