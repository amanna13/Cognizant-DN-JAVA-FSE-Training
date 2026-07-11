package com.cognizant.springjpaqueries.repository;

import com.cognizant.springjpaqueries.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
