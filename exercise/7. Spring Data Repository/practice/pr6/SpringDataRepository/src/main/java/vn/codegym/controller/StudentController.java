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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public String showStudentList(Model model) {
        model.addAttribute("studentList", studentService.findAll());
        return "student";
    }


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
