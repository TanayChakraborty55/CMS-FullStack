package com.capgemini.CourseManagementSysstem.controller;

import com.capgemini.CourseManagementSysstem.dto.CourseDto;
import com.capgemini.CourseManagementSysstem.entity.Course;
import com.capgemini.CourseManagementSysstem.entity.CourseDetails;
import com.capgemini.CourseManagementSysstem.repository.CourseDetailsRepository;
import com.capgemini.CourseManagementSysstem.service.CourseDetailsService;
import com.capgemini.CourseManagementSysstem.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/add/{insId}")
    public ResponseEntity<CourseDto> addCourse(@PathVariable Long insId, @RequestBody @Valid CourseDto course){
        return ResponseEntity.ok(courseService.addCourse(insId,course));
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Long id , @RequestBody @Valid CourseDto course){
        return ResponseEntity.ok(courseService.updateCourse(id,course));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CourseDto>> getAllCourse(){
        List<CourseDto> list = courseService.getAllCourses();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id){

        return ResponseEntity.ok(courseService.getCourseById(id));
    }
}
