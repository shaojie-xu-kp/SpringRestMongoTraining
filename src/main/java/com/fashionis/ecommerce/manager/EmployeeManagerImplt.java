package com.fashionis.ecommerce.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fashionis.ecommerce.model.Employee;
import com.fashionis.ecommerce.repo.EmployeeRepo;

public class EmployeeManagerImplt implements EmployeeManager {

	@Autowired
	private EmployeeRepo employeeRepo;

	
	@Override
	public Employee findEmployeeById(Integer id) {
		Employee emFound = this.employeeRepo.findById(id);
		return emFound;
	}

	@Override
	public Employee Create(Employee employee) {
		Employee emSaved = this.employeeRepo.save(employee);
		return emSaved;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return this.employeeRepo.findAll();
	}

	@Override
	public Employee deleteById(Integer id) {
		Employee empToDelete = this.employeeRepo.findById(id);
		this.employeeRepo.delete(id);
		return empToDelete;
	}

	@Override
	public Employee updateEmploye(Integer id, Employee employee) {
		Employee emp = this.employeeRepo.findById(id);
		emp.setName(employee.getName());
		emp.setCreatedDate(employee.getCreatedDate());
		return this.employeeRepo.save(emp);
	}

}
