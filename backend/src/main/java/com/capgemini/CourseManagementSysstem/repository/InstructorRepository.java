package com.capgemini.CourseManagementSysstem.repository;

import com.capgemini.CourseManagementSysstem.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {
}
