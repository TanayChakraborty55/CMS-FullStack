package com.capgemini.CourseManagementSysstem.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private Long id;

    @NotBlank(message = "Name is required")
    private String sname;

    @Email(message = "Email must be valid")
    private String email;


//    private Set<Long> courseIds;
//    private Set<Long> enrollmentIds;
}
