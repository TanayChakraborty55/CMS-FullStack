package com.capgemini.CourseManagementSysstem.repository;

import com.capgemini.CourseManagementSysstem.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollementRepository extends JpaRepository<Enrollment,Long> {
}
