package com.saew.repositories;

import java.util.List;

import com.saew.dto.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

    List<Student> findByName(String name);
   

    
}
