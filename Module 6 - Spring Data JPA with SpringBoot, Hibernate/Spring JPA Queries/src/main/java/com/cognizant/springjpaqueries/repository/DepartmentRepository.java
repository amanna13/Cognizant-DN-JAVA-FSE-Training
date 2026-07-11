package com.cognizant.springjpaqueries.repository;

import com.cognizant.springjpaqueries.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
