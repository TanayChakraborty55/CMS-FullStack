package com.capgemini.CourseManagementSysstem.service;

import com.capgemini.CourseManagementSysstem.dto.StudentDto;
import com.capgemini.CourseManagementSysstem.entity.Student;
import com.capgemini.CourseManagementSysstem.exception.ResourceNotFoundException;
import com.capgemini.CourseManagementSysstem.repository.CourseRepository;
import com.capgemini.CourseManagementSysstem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
//    private final CourseRepository courseRepository;
    private final ModelMapper mapper;

    public StudentDto addStudent(StudentDto studentDto) {
        // Convert DTO to Entity
        Student student = mapper.map(studentDto, Student.class);

        // Save Entity
        Student savedStudent = studentRepository.save(student);

        // Convert back to DTO
        return mapper.map(savedStudent, StudentDto.class);
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        existingStudent.setSname(studentDto.getSname());
        existingStudent.setEmail(studentDto.getEmail());

        Student updatedStudent = studentRepository.save(existingStudent);
        return mapper.map(updatedStudent, StudentDto.class);
    }

    public ResponseEntity<String> deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        studentRepository.deleteById(id);
        return ResponseEntity.ok("Student removed with Id: " + id);
    }

    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        return mapper.map(student, StudentDto.class);
    }



    public List<StudentDto> getAllStudent() {
        return studentRepository.findAll().stream()
                .map(student -> mapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

}
