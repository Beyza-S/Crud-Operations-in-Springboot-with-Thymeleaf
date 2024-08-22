package com.crudDataBase.StudentCrud.dao;

import com.crudDataBase.StudentCrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // that's it ... no need to write any code

    public List<Student>findAllByOrderByLastNameAsc();

}

