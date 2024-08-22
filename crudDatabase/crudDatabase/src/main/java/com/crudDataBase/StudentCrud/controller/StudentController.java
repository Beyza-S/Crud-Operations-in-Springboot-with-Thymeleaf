package com.crudDataBase.StudentCrud.controller;

import java.util.List;

import com.crudDataBase.StudentCrud.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.crudDataBase.StudentCrud.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService theStudentService) {
        studentService = theStudentService;
    }


    @GetMapping("/list")
    public String listStudent(Model theModel) {

        List<Student> theStudent = studentService.findAll();

        theModel.addAttribute("student", theStudent);

        return "student/list-student";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {


        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        return "student/student-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId")int theId, Model theModel) {
        Student theStudent = studentService.findById(theId);
        theModel.addAttribute("student",theStudent);
        return "student/student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student theStudent) {

        studentService.save(theStudent);


        return "redirect:/student/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId")int theId) {

        studentService.deleteById(theId);

        return "redirect:/student/list";
    }

}
