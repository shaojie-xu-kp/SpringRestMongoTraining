package com.fashionis.ecommerce.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fashionis.ecommerce.manager.EmployeeManager;
import com.fashionis.ecommerce.model.Employee;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class EmployeeController {
     
	@Autowired
	EmployeeManager employeeManager;
	
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
     
          
    @RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
    public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
    	
        logger.info("Start getEmployee. ID="+empId);
         
        return employeeManager.findEmployeeById(empId);
    }
     
    @RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
    public @ResponseBody List<Employee> getAllEmployees() {
        logger.info("Start getAllEmployees.");
        List<Employee> emps = this.employeeManager.getAllEmployees();
        return emps;
    }
     
    @RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
    public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
        logger.info("Start createEmployee.");
        Employee employeeCreated = emp;
        emp.setCreatedDate(new Date());
        logger.info(employeeCreated + " created.");
        return employeeManager.Create(emp);
    }
     
    @RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
    public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
        logger.info("Start deleteEmployee.");
        return this.employeeManager.deleteById(empId);
    }
    
    @RequestMapping(value = EmpRestURIConstants.UPDATE_EMP, method = RequestMethod.PUT)
    public @ResponseBody Employee updateEmployee(@PathVariable("id") int empId, @RequestBody Employee emp) {
        logger.info("Start deleteEmployee.");
        return this.employeeManager.updateEmploye(empId, emp);
    }
     
     
}