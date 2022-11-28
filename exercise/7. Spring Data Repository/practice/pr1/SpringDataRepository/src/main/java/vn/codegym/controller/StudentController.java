package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Student;
import vn.codegym.service.IClassRoomService;
import vn.codegym.service.ICourseService;
import vn.codegym.service.IStudentService;


import java.util.Date;
@Controller
@RequestMapping({"/student", "/home"})
public class StudentController {

    @Autowired
    private IClassRoomService classRoomService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ICourseService iCourseService;

    @GetMapping(value = "/list")
    public ModelAndView showStudentList(
            @PageableDefault(value = 1) Pageable pageable) {
        Page<Student> students = studentService.finAllGood(pageable);
        return new ModelAndView("student","studentList",studentService.finAllGood(pageable));
    }

//    @GetMapping("/customers")
//    public ModelAndView listCustomers(Pageable pageable){
//        Page<Customer> customers = customerService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {

        model.addAttribute("classRoomList", classRoomService.findAll());
        model.addAttribute("courseList", iCourseService.findAll());


        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student,
                                RedirectAttributes redirectAttributes) {

        student.getAccount().setDateCreate(new Date(System.currentTimeMillis()));
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message",
                "Create student: " + student.getName() + " OK!");
        return "redirect:/student/list";
    }

}
