package com.capgemini.CourseManagementSysstem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnrollmentDto {
    private Long id;

    private Long studentId;
    private Long courseId;
}
