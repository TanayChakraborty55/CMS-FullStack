package com.capgemini.CourseManagementSysstem.repository;

import com.capgemini.CourseManagementSysstem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}