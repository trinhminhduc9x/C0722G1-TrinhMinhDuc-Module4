package com.example.room_for_rental_children.controller;

import com.example.room_for_rental_children.model.MotelRoom;
import com.example.room_for_rental_children.model.PeopleHouseHold;
import com.example.room_for_rental_children.service.IMotelRoomService;
import com.example.room_for_rental_children.service.IPayService;
import com.example.room_for_rental_children.service.IPeopleHouseHoldService;
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
@RequestMapping("/motelRoom")
public class MotelController {

    @Autowired
    IMotelRoomService iMotelRoomService;
    @Autowired
    IPeopleHouseHoldService iPeopleHouseHoldService;

    @Autowired
    IPayService iPayService;

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
    //    @RequestMapping("/list")
//    private String showList(Model model,@PageableDefault(page = 0,size = 3) Pageable pageable){
//        model.addAttribute("motelRoom",iMotelRoomService.findPageAll(pageable));
//        return "MotelRoom/list";
//    }

    //    hiển thị list với câu tìm kiếm
    @GetMapping("/list")
    public String showList(Model model,
                           @PageableDefault(page = 0, size = 6) Pageable pageable,
                           @RequestParam(required = false, defaultValue = "") String dateStart,
                           @RequestParam(required = false, defaultValue = "") String dateEnd) {
        for (Sort.Order order : pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }

        Page<MotelRoom> motelRooms = iMotelRoomService.findPageSearchAll(pageable, dateStart, dateEnd);

        model.addAttribute("motelRoom", motelRooms);
        model.addAttribute("dateStart", dateStart);
        model.addAttribute("dateEnd", dateEnd);
        return "MotelRoom/list";
    }

    //    thêm mới đối tượng vào list
    @GetMapping("/create")
    public String Create(Model model) {
        model.addAttribute("motelRoom", new MotelRoom());
        model.addAttribute("payList",iPayService.PAY_MONY_LIST());
        return "MotelRoom/create";
    }

    //    Lưu đối tượng vào list
    @PostMapping ("/create")
    public String save (@ModelAttribute("motelRoom") MotelRoom motelRoom,RedirectAttributes redirectAttributes){
        iPeopleHouseHoldService.save(motelRoom.getPeopleHouseHold());
        iMotelRoomService.save(motelRoom);
        redirectAttributes.addFlashAttribute("msg", "thêm mới đã thành công");
        return "redirect:/motelRoom/list";
    }
    //    Xóa đối tượng vào list
    @PostMapping ("/remove")
    public String remove(@RequestParam(name = "id") Integer id, RedirectAttributes redirectAttributes) {
        iMotelRoomService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "delete thành công");
        return "redirect:/motelRoom/list";
    }
}
