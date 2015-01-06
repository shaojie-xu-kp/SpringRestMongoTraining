package com.fashionis.ecommerce.manager;

import java.util.List;

import com.fashionis.ecommerce.model.Employee;

public interface EmployeeManager {

	public Employee findEmployeeById(Integer id);
	public Employee Create(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee deleteById(Integer id);
	public Employee updateEmploye(Integer id, Employee employee);
	
}
