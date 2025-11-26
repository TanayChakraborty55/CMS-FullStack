package com.capgemini.CourseManagementSysstem.controller;


import com.capgemini.CourseManagementSysstem.dto.StudentDto;
import com.capgemini.CourseManagementSysstem.entity.Student;
import com.capgemini.CourseManagementSysstem.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentDto> addStudent(@RequestBody @Valid StudentDto student){
        return ResponseEntity.ok(studentService.addStudent(student));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id , @RequestBody @Valid StudentDto student){
        return ResponseEntity.ok(studentService.updateStudent(id,student));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        List<StudentDto> list = studentService.getAllStudent();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){

        return ResponseEntity.ok(studentService.getStudentById(id));
    }




}
