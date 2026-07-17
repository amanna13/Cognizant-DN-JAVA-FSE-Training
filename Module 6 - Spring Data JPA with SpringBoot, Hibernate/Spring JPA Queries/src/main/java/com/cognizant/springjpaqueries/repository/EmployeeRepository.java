package com.cognizant.springjpaqueries.repository;

import com.cognizant.springjpaqueries.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select e from Employee e left join fetch e.department d left join e.skillSet where e.permanent = true ")
    List<Employee> getAllPermanentEmployees();

    @Query(value = "select avg(e.salary) from Employee e")
    double getAverageSalary();

    @Query(value = "SELECT AVG(e.salary) FROM Employee e where e.department.id = :id")
    double getAverageSalary(@Param("id") int id);

    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> getAllEmloyeesNative();

}
