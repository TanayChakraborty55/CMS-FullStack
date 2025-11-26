package com.capgemini.CourseManagementSysstem.service;

import com.capgemini.CourseManagementSysstem.dto.CourseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICourseService {

    CourseDto addCourse(Long insId, CourseDto courseDto);

    CourseDto updateCourse(Long id, CourseDto courseDto);

    ResponseEntity<String> deleteCourse(Long id);

    CourseDto getCourseById(Long id);

    List<CourseDto> getAllCourses();
}
