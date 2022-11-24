package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/product"})
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "/list",
            method = RequestMethod.GET)

    public ModelAndView showStudentList() {
        return new ModelAndView("student",
                "studentList", studentService.findAll());
    }

    @PostMapping("/list")
    public ModelAndView showStudentList1() {
        return new ModelAndView("student",
                "studentList", studentService.findAll());
    }


//    @PostMapping("/create")
//    public String createStudent(@ModelAttribute Student student,
//                                RedirectAttributes redirectAttributes) {
//        System.out.println(student);
//        studentService.save(student);
//        redirectAttributes.addFlashAttribute("message",
//                "Create student: " + student.getName() + " OK!")
//        return "redirect:/student/list";
//    }


}
