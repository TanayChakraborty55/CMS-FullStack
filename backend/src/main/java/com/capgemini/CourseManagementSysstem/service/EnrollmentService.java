package com.capgemini.CourseManagementSysstem.service;

import com.capgemini.CourseManagementSysstem.entity.Course;
import com.capgemini.CourseManagementSysstem.entity.Enrollment;
import com.capgemini.CourseManagementSysstem.entity.Student;
import com.capgemini.CourseManagementSysstem.repository.CourseRepository;
import com.capgemini.CourseManagementSysstem.repository.EnrollementRepository;
import com.capgemini.CourseManagementSysstem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollementRepository enrollementRepository;


    public Enrollment addStudents(Long stuId,Long couId){

        Optional<Student> studentOptional = studentRepository.findById(stuId);
        Optional<Course> courseOptional = courseRepository.findById(couId);

        if(studentOptional.isPresent() && courseOptional.isPresent()){
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(studentOptional.get());
            enrollment.setCourse(courseOptional.get());
            return enrollementRepository.save(enrollment);
        }else{
            throw new RuntimeException("Student and course cannot be found :::: .....");
        }
    }
}
