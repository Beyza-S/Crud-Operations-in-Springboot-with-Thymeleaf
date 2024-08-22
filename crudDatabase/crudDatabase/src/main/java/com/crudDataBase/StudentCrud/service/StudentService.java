package com.crudDataBase.StudentCrud.service;

import com.crudDataBase.StudentCrud.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int theId);

    Student save(Student theEmployee);

    void deleteById(int theId);

}
