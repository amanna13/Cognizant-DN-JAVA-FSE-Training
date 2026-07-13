package com.cognizant.springjpaqueries.service;

import com.cognizant.springjpaqueries.model.Department;
import com.cognizant.springjpaqueries.model.Skill;
import com.cognizant.springjpaqueries.repository.DepartmentRepository;
import com.cognizant.springjpaqueries.repository.SkillRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Transactional
    public void saveDepartment(Department department) {
        logger.info("Start");
        departmentRepository.save(department);
        logger.info("End");
    }

    @Transactional
    public Optional<Department> getDepartmentById(Integer id) {
        logger.info("Start");
        return departmentRepository.findById(id);
    }
}
