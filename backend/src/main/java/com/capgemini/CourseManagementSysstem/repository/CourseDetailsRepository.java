package com.capgemini.CourseManagementSysstem.repository;

import com.capgemini.CourseManagementSysstem.entity.CourseDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDetailsRepository extends JpaRepository<CourseDetails,Long> {
}
