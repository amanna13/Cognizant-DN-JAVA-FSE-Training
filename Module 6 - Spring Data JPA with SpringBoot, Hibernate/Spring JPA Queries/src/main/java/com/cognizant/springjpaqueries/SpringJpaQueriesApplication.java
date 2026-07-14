package com.cognizant.springjpaqueries;

import com.cognizant.springjpaqueries.model.Department;
import com.cognizant.springjpaqueries.model.Employee;
import com.cognizant.springjpaqueries.model.Skill;
import com.cognizant.springjpaqueries.service.DepartmentService;
import com.cognizant.springjpaqueries.service.EmployeeService;
import com.cognizant.springjpaqueries.service.SkillService;
import com.cognizant.springjpaqueries.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
public class SpringJpaQueriesApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringJpaQueriesApplication.class);
    private static StockService stockService;

    // Employee database
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringJpaQueriesApplication.class, args);
        stockService = applicationContext.getBean(StockService.class);

        employeeService = applicationContext.getBean(EmployeeService.class);
        departmentService = applicationContext.getBean(DepartmentService.class);
        skillService = applicationContext.getBean(SkillService.class);

//        testGetEmployee();
//        testAddEmployee();
//        testUpdateEmployee();
//        testGetSkill();
//        testGetDepartment();

        testAddSkillToEmployee();
    }

    public static void testQueryMethods() {
        logger.info("Start");
        logger.debug("getStocksByCodeAndDateRange - {}", stockService.getStocksByCodeAndDateRange("FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30)));
        logger.debug("getStocksByClosingPriceGreaterThan - {}", stockService.getStocksByClosingPriceGreaterThan("GOOGL", new BigDecimal("1250")));
        logger.debug("getTopThreeHighestVolumeStocks - {}", stockService.getTopThreeHighestVolumeStocks());
        logger.debug("getLowestThreeClosingPrices - {}", stockService.getLowestThreeClosingPrices("NFLX"));
        logger.info("End");
    }


    private static void testGetEmployee() {
        logger.info("Start");

        Employee employee = employeeService.getEmployeeById(1).get();

        logger.debug("Employe - {}", employee);

        logger.debug("Department : {}", employee.getDepartment());

        logger.debug("Skills: {}", employee.getSkillSet());

        logger.info("End");
    }

    private static void testAddEmployee() {

        Employee employee = new Employee();

        employee.setName("Rahul");
        employee.setSalary(45000);
        employee.setPermanent(true);

        employee.setDateOfBirth(
                LocalDate.parse("1999-05-20"));

        Department department = departmentService.getDepartmentById(1).get();

        employee.setDepartment(department);

        employeeService.saveEmployee(employee);

        logger.debug("{}", employee);

    }

    private static void testUpdateEmployee() {

        Employee employee = employeeService.getEmployeeById(2).get();

        Department department = departmentService.getDepartmentById(2).get();

        employee.setDepartment(department);

        employeeService.saveEmployee(employee);

        logger.debug("{}", employee);
    }

    private static void testGetDepartment() {
        Department department = departmentService.getDepartmentById(1).get();
        logger.debug("Department - {}", department);
        logger.debug("Department Employee List - {}", department.getEmployeeList());
    }

    private static void  testGetSkill() {
        Skill skill = skillService.getSkillById(1).get();
        logger.debug("Skill - {}", skill);
        logger.debug("Employee Set - {}", skill.getEmployeeSet());
    }

    private static void testAddSkillToEmployee() {

        logger.info("Start");

        int employeeId = 1;
        int skillId = 3;

        // Get employee
        Employee employee = employeeService.getEmployeeById(employeeId).get();

        // Get skill
        Skill skill = skillService.getSkillById(skillId).get();

        // Get employee's skill list and add new skill
        employee.getSkillSet().add(skill);

        // Save employee (updates join table)
        employeeService.saveEmployee(employee);

        logger.debug("Employee after adding skill: {}", employee);

        logger.info("End");
    }
}
