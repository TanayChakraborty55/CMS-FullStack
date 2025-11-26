package com.capgemini.CourseManagementSysstem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String duration;

    private String difficulty;
    private String syllabus;


    // mapping to be done for course_id;

//    @OneToOne(mappedBy = "courseDetails")
//    @JsonBackReference
//    private Course course;
}
