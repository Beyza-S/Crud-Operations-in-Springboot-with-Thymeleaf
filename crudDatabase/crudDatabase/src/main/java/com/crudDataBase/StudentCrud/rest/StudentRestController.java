package com.crudDataBase.StudentCrud.rest;

import com.crudDataBase.StudentCrud.entity.Student;
import com.crudDataBase.StudentCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    @GetMapping("/employees")
    public List<Student> findAll() {
        return studentService.findAll();
    }



    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        Student theStudent = studentService.findById(studentId);

        if (theStudent == null) {
            throw new RuntimeException("Employee id not found - " + studentId);
        }

        return theStudent;
    }



    @PostMapping("/student")
    public Student addStudent(@RequestBody Student theStudent) {



        theStudent.setId(0);

        Student dbStudent = studentService.save(theStudent);

        return dbStudent;
    }


    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student theStudent) {

        Student dbStudent = studentService.save(theStudent);

        return dbStudent;
    }



    @DeleteMapping("/student/{studentId}")
    public String deleteEmployee(@PathVariable int studentId) {

        Student tempStudent = studentService.findById(studentId);



        if (tempStudent == null) {
            throw new RuntimeException("Employee id not found - " + studentId);
        }

        studentService.deleteById(studentId);

        return "Deleted employee id - " + studentId;
    }

}
