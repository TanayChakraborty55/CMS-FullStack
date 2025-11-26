package com.capgemini.CourseManagementSysstem.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    private String description;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "details_id")
//    @JsonManagedReference
//    private CourseDetails courseDetails;



    @ManyToOne
    @JoinColumn(name = "instructor_id")
    @JsonBackReference("instructor-course")
//    @JsonIgnore
    private Instructor instructor;


    //Many-Many with student
//    @ManyToMany(mappedBy = "courses")
//    private Set<Student> studentSet = new HashSet<>();


    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private Set<Enrollment> enrollments = new HashSet<>();

}
