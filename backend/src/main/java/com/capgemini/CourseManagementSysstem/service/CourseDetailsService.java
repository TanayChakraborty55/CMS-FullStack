package com.capgemini.CourseManagementSysstem.service;



import com.capgemini.CourseManagementSysstem.entity.CourseDetails;
import com.capgemini.CourseManagementSysstem.exception.ResourceNotFoundException;
import com.capgemini.CourseManagementSysstem.repository.CourseDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseDetailsService {

    private final CourseDetailsRepository courseDetailsRepository;

    public CourseDetails addCourseDetails(CourseDetails course){
        return  courseDetailsRepository.save(course);
    }

    public CourseDetails updateCourseDetails(Long id, CourseDetails course){
        CourseDetails course1 = courseDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CourseDetails can not be found : "+course));

        course1.setDifficulty(course.getDifficulty());
        course1.setDuration(course.getDuration());
        course1.setSyllabus(course.getSyllabus());

        return courseDetailsRepository.save(course1);
    }

    public ResponseEntity<String> deleteCourseDetails(Long id){
        CourseDetails course1 = courseDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CourseDetails can not be found : "+id));
        courseDetailsRepository.deleteById(id);

        return ResponseEntity.ok("CourseDetails removed with Id: " + id);
    }

    public CourseDetails getCourseDetailsById(Long id){
        CourseDetails course1 = courseDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CourseDetails can not be found : "+id));
        return course1;
    }

    public List<CourseDetails> getAllCourseDetails(){
        return courseDetailsRepository.findAll();
    }
}
