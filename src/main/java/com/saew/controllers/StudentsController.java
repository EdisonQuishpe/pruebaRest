package com.saew.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saew.dto.Student;

@RestController
@RequestMapping("/students")
public class StudentsController {
    
    
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }
    

    
    public List<Student> getStudentByName(String name) {    
        return studentRepository.findByName(name);
    }
       

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Optional<Student> optStudent = studentRepository.findById(Integer.parseInt(id));

        if(optStudent.isPresent()){
         // return optProdcut.get();
         return ResponseEntity.ok(optStudent.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentRepository.save(student);
      return ResponseEntity.ok(student);
    }



    @PatchMapping
    public ResponseEntity<Student> updateProduct(@RequestBody Student student) {
         studentRepository.save(student);
      return ResponseEntity.ok(student);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable String id) {
       studentRepository.deleteById(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).build();  
    }

    

    
}
