package com.capgemini.CourseManagementSysstem.repository;

import com.capgemini.CourseManagementSysstem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}