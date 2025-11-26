package com.capgemini.CourseManagementSysstem.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Email
    private String email;

    @OneToMany(mappedBy = "instructor" ,cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference("instructor-course")
    private List<Course> courses;

}
