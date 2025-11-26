package com.capgemini.CourseManagementSysstem.controller;


import com.capgemini.CourseManagementSysstem.entity.Enrollment;
import com.capgemini.CourseManagementSysstem.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping("/add/{studId}/{couId}")
    public Enrollment addEnrollment(@PathVariable  Long studId,@PathVariable Long couId){
        return enrollmentService.addStudents(studId,couId);
    }
}
