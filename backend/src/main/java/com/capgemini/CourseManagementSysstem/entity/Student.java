package com.capgemini.CourseManagementSysstem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sname;

    @Email
    private String email;

    //Have to create a many-many relation with course

//    @ManyToMany
//    @JoinTable(
//            name = "student_course",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns =  @JoinColumn(name = "course_id")
//    )
//    private Set<Course> courses = new HashSet<>();
//
//
//    //uncomment only this one
//
    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private Set<Enrollment> enrollments = new HashSet<>();
}
