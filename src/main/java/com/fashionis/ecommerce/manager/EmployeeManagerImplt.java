package com.fashionis.ecommerce.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fashionis.ecommerce.model.Employee;
import com.fashionis.ecommerce.repo.EmployeeRepo;

public class EmployeeManagerImplt implements EmployeeManager {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee findEmployeeById(Integer id) {
		Employee emFound = this.employeeRepo.findById(id);
		return emFound;
	}

	public Employee Create(Employee employee) {
		Employee emSaved = this.employeeRepo.save(employee);
		return emSaved;
	}

	public List<Employee> getAllEmployees() {
		
		return this.employeeRepo.findAll();
	}

	public Employee deleteById(Integer id) {
		Employee empToDelete = this.employeeRepo.findById(id);
		this.employeeRepo.delete(id);
		return empToDelete;
	}

	public Employee updateEmploye(Integer id, Employee employee) {
		Employee emp = this.employeeRepo.findById(id);
		emp.setName(employee.getName());
		emp.setCreatedDate(employee.getCreatedDate());
		return this.employeeRepo.save(emp);
	}

	

}
