package com.capgemini.CourseManagementSysstem.controller;

import com.capgemini.CourseManagementSysstem.entity.CourseDetails;
import com.capgemini.CourseManagementSysstem.service.CourseDetailsService;
import com.capgemini.CourseManagementSysstem.service.CourseDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coursedetails")
@RequiredArgsConstructor
public class CourseDetailsController {
    private final CourseDetailsService courseDetailsService;

    @PostMapping("/add")
    public ResponseEntity<CourseDetails> addCourseDetails(@RequestBody @Valid CourseDetails CourseDetails){
        return ResponseEntity.ok(courseDetailsService.addCourseDetails(CourseDetails));
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<CourseDetails> updateCourseDetails(@PathVariable Long id , @RequestBody @Valid CourseDetails CourseDetails){
        return ResponseEntity.ok(courseDetailsService.updateCourseDetails(id,CourseDetails));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourseDetails(@PathVariable Long id){
        return courseDetailsService.deleteCourseDetails(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CourseDetails>> getAllCourseDetails(){
        List<CourseDetails> list = courseDetailsService.getAllCourseDetails();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CourseDetails> getCourseDetailsById(@PathVariable Long id){

        return ResponseEntity.ok(courseDetailsService.getCourseDetailsById(id));
    }
}
