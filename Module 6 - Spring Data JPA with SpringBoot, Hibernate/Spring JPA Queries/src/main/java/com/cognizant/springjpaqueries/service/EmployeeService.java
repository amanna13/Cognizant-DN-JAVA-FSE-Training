package com.cognizant.springjpaqueries.service;

import com.cognizant.springjpaqueries.model.Employee;
import com.cognizant.springjpaqueries.model.Skill;
import com.cognizant.springjpaqueries.repository.EmployeeRepository;
import com.cognizant.springjpaqueries.repository.SkillRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);


    @Transactional
    public void saveEmployee(Employee employee) {
        logger.info("Start");
        employeeRepository.save(employee);
        logger.info("End");
    }

    @Transactional
    public Optional<Employee> getEmployeeById(Integer id) {
        logger.info("Start");
        return employeeRepository.findById(id);
    }

    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }

    @Transactional
    public double getAverageSalary() {
        return employeeRepository.getAverageSalary();
    }

    @Transactional
    public double getAverageSalary(int id) {
        return employeeRepository.getAverageSalary(id);
    }
}
