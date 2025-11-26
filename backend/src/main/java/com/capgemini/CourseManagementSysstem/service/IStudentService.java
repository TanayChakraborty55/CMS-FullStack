package com.capgemini.CourseManagementSysstem.service;



import com.capgemini.CourseManagementSysstem.dto.StudentDto;
import com.capgemini.CourseManagementSysstem.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentService {

    StudentDto addStudent(StudentDto student);

    StudentDto updateStudent(Long id, StudentDto student);

    ResponseEntity<String> deleteStudent(Long id);

    StudentDto getStudentById(Long id);

    List<StudentDto> getAllStudent();
}
