package com.capgemini.CourseManagementSysstem.service;

import com.capgemini.CourseManagementSysstem.dto.CourseDto;
import com.capgemini.CourseManagementSysstem.entity.Course;
import com.capgemini.CourseManagementSysstem.entity.CourseDetails;
import com.capgemini.CourseManagementSysstem.entity.Instructor;
import com.capgemini.CourseManagementSysstem.entity.Student;
import com.capgemini.CourseManagementSysstem.exception.ResourceNotFoundException;
import com.capgemini.CourseManagementSysstem.repository.CourseDetailsRepository;
import com.capgemini.CourseManagementSysstem.repository.CourseRepository;
import com.capgemini.CourseManagementSysstem.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper mapper;
//    private final CourseDetailsRepository courseDetailsRepository;
    private final InstructorRepository instructorRepository;

    @Override
    public CourseDto addCourse(Long insId, CourseDto courseDto) {
        Instructor instructor = instructorRepository.findById(insId).orElseThrow(() -> new ResourceNotFoundException("Instructor Not found :  "+ insId));

        Course course = mapper.map(courseDto,Course.class);

        course.setInstructor(instructor);
        Course savedCourse = courseRepository.save(course);


//        if(CourseDto.getCourseDetails() != null){
//            CourseDto.getCourseDetails().setCourse(course);
//        }

//        Course course = mapper.map(courseDto, Course.class);
//        Course savedCourse = courseRepository.save(course);
        return mapper.map(savedCourse, CourseDto.class);
    }

    @Override
    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course can not be found : " + id));

        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());

        Course updatedCourse = courseRepository.save(course);
        return mapper.map(updatedCourse, CourseDto.class);
    }

    @Override
    public ResponseEntity<String> deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course can not be found : " + id));
        courseRepository.deleteById(id);

        return ResponseEntity.ok("Course removed with Id: " + id);
    }

    @Override
    public CourseDto getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course can not be found : " + id));
        return mapper.map(course, CourseDto.class);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(course -> mapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
    }
}